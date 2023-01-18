package net.warrentode.todevillagers.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.warrentode.todevillagers.screens.GlassKilnMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlassKilnBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.empty();

    /* Data being tracked and synced through the menu */
    /* data variables being tracked within the container
     * progress is the same as Cook Time here
     * revisit this when ready to track fuel with the entity as a furnace */
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;

    public GlassKilnBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GLASS_KILN_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> GlassKilnBlockEntity.this.progress;
                    case 1 -> GlassKilnBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> GlassKilnBlockEntity.this.progress = pValue;
                    case 1 -> GlassKilnBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("container.todevillagers.glass_kiln");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new GlassKilnMenu(id, inventory, this, this.data);
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction facing) {
        if(capability == ForgeCapabilities.ITEM_HANDLER) {
            return itemHandlerLazyOptional.cast();
        }

        return super.getCapability(capability, facing);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        itemHandlerLazyOptional = LazyOptional.of(()-> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazyOptional.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(nbt);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        assert this.level != null;
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, GlassKilnBlockEntity pEntity) {
        if(hasRecipe(pEntity)) {
            pEntity.progress++;
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    /* to be changed here when ready to serialize recipes */
    private static void craftItem(GlassKilnBlockEntity blockEntity) {
        // need one for each slot in the GUI defined here
        if (hasRecipe(blockEntity)) {
            blockEntity.itemHandler.extractItem(1, 1, false);

            blockEntity.itemHandler.setStackInSlot(5, new ItemStack(Blocks.GLASS,
                    blockEntity.itemHandler.getStackInSlot(5).getCount() + 1));

            blockEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(GlassKilnBlockEntity blockEntity) {
        SimpleContainer inventory = new SimpleContainer(blockEntity.itemHandler.getSlots());
        for (int i = 0; i < blockEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, blockEntity.itemHandler.getStackInSlot(i));
        }

        boolean hasSandInFirstSlot = blockEntity.itemHandler.getStackInSlot(1).getItem() == Items.SAND;

        return hasSandInFirstSlot && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, new ItemStack(Blocks.GLASS), 1);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack, @SuppressWarnings({"unused", "SameParameterValue"}) int i) {
        return inventory.getItem(5).getItem() == stack.getItem() || inventory.getItem(5).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(5).getMaxStackSize() > inventory.getItem(5).getCount();
    }
}