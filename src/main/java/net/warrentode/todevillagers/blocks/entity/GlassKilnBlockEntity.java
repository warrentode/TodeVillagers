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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.warrentode.todevillagers.recipes.GlassblowingRecipe;
import net.warrentode.todevillagers.screens.GlassKilnMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

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
     * Fuel Time is the same as Burn Time here */
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelTime = 0;
    private int fuelDuration = 0;

    public GlassKilnBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GLASS_KILN_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> GlassKilnBlockEntity.this.progress;
                    case 1 -> GlassKilnBlockEntity.this.maxProgress;
                    case 2 -> GlassKilnBlockEntity.this.fuelTime;
                    case 3 -> GlassKilnBlockEntity.this.fuelDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> GlassKilnBlockEntity.this.progress = pValue;
                    case 1 -> GlassKilnBlockEntity.this.maxProgress = pValue;
                    case 2 -> GlassKilnBlockEntity.this.fuelTime = pValue;
                    case 3 -> GlassKilnBlockEntity.this.fuelDuration = pValue;
                }
            }

            @Override
            public int getCount() {
                return 4;
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
        nbt.putInt("glass_kiln.progress", this.progress);
        nbt.putInt("glass_kiln.fuelTime", this.fuelTime);
        nbt.putInt("glass_kiln.fuelDuration", this.fuelDuration);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("glass_kiln.progress");
        fuelTime = nbt.getInt("glass_kiln.fuelTime");
        fuelDuration = nbt.getInt("glass_kiln.fuelDuration");
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
        if(isBurningFuel(pEntity)) {
            pEntity.fuelTime--;
        }

        if(hasRecipe(pEntity)) {
            if(hasFuelInFuelSlot(pEntity) && !isBurningFuel(pEntity)) {
                pEntity.burnFuel();
                setChanged(level, pos, state);
            }
            if(isBurningFuel(pEntity)) {
                pEntity.progress++;
                if(pEntity.progress >= pEntity.maxProgress) {
                    craftItem(pEntity);
                }
                setChanged(level, pos, state);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private static boolean hasFuelInFuelSlot(GlassKilnBlockEntity pEntity) {
        return !pEntity.itemHandler.getStackInSlot(4).isEmpty();
    }

    private static boolean isBurningFuel(GlassKilnBlockEntity pEntity) {
        return pEntity.fuelTime > 0;
    }

    private int burnFuel() {
        ItemStack pFuel = itemHandler.getStackInSlot(4).getItem().getDefaultInstance();
        int burnTimeForItem = getItemBurnTime(this.level, pFuel);

        if (this.fuelTime == 0) {
            if (!pFuel.isEmpty() && getItemBurnTime(this.level, pFuel) > 0) {
                this.fuelDuration = burnTimeForItem;
                this.fuelTime = this.fuelDuration;
                this.itemHandler.extractItem(4, 1, false);
            }
        } else if (pFuel.isEmpty()) {
            ItemStack containerItem = pFuel.getCraftingRemainingItem();
            itemHandler.setStackInSlot(4, containerItem);
            return 0;
        }
        return this.fuelTime;
    }

    public static int getItemBurnTime(Level level, ItemStack pFuel) {
        int burnTime = net.minecraftforge.common.ForgeHooks.getBurnTime(pFuel, null);
        return burnTime;
    }

    private static boolean hasRecipe(GlassKilnBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GlassblowingRecipe> match = level.getRecipeManager().getRecipeFor(GlassblowingRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
    }

    private static void craftItem(GlassKilnBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GlassblowingRecipe> match = level.getRecipeManager().getRecipeFor(GlassblowingRecipe.Type.INSTANCE, inventory, level);

        // need one for each slot in the GUI defined here
        if (match.isPresent()) {

            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 1, false);
            entity.itemHandler.extractItem(2, 1, false);
            entity.itemHandler.extractItem(3, 1, false);

            entity.itemHandler.setStackInSlot(5, new ItemStack(match.get().getResultItem().getItem(),
                    entity.itemHandler.getStackInSlot(5).getCount() + (match.get().getResultItem().getCount())));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(5).getItem() == stack.getItem() || inventory.getItem(5).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(5).getMaxStackSize() > inventory.getItem(5).getCount();
    }
}