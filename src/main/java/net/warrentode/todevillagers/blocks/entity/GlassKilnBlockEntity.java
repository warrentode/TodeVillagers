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
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.warrentode.todevillagers.blocks.custom.GlassKilnBlock;
import net.warrentode.todevillagers.items.ModItems;
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
        if (level.isClientSide()) {
            return;
        }

        if (isBurningFuel(pEntity)) {
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, true), 3);
            pEntity.fuelTime--;
        }
        else if (!isBurningFuel(pEntity) && pEntity.itemHandler.getStackInSlot(4).isEmpty() && pEntity.progress > 0) {
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, false), 3);
            pEntity.progress--;
            setChanged(level, pos, state);
        }
        else if (!isBurningFuel(pEntity) && (pEntity.itemHandler.getStackInSlot(4).isEmpty() || !hasRecipe(pEntity))) {
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, false), 3);
            setChanged(level, pos, state);
        }

        if (hasRecipe(pEntity)) {
            if (isBurningFuel(pEntity)) {
                pEntity.progress++;
                if (pEntity.progress >= pEntity.maxProgress) {
                    craftItem(pEntity);
                }
                setChanged(level, pos, state);
            }
            else if (hasFuelInFuelSlot(pEntity) && !isBurningFuel(pEntity)) {
                setChanged(level, pos, state);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private static boolean hasFuelInFuelSlot(GlassKilnBlockEntity pEntity) {
        if (!pEntity.itemHandler.getStackInSlot(4).isEmpty() && pEntity.fuelTime == 0) {
            burnFuel(pEntity);
        } else return pEntity.fuelTime > 0;
        return false;
    }

    private static boolean isBurningFuel(GlassKilnBlockEntity pEntity) {
        return pEntity.fuelTime > 0;
    }

    private static void burnFuel(GlassKilnBlockEntity pEntity) {
        ItemStack pFuel = pEntity.itemHandler.getStackInSlot(4).getItem().getDefaultInstance();
        int burnTimeForItem = getItemBurnTime(pFuel);

        if (pEntity.fuelTime == 0) {
            if (!pFuel.isEmpty() && getItemBurnTime(pFuel) > 0) {
                pEntity.fuelDuration = burnTimeForItem;
                pEntity.fuelTime = pEntity.fuelDuration;
                if (pEntity.itemHandler.getStackInSlot(4).hasCraftingRemainingItem()) {
                    ItemStack remainingItem = pEntity.itemHandler.getStackInSlot(4).getCraftingRemainingItem();
                    pEntity.itemHandler.setStackInSlot(4, remainingItem);
                }
                else {
                    pEntity.itemHandler.extractItem(4, 1, false);
                }
            }
        }
    }

    public static int getItemBurnTime(ItemStack pFuel) {
        return ForgeHooks.getBurnTime(pFuel, null);
    }

    private static boolean hasRecipe(GlassKilnBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<GlassblowingRecipe> match = level.getRecipeManager().getRecipeFor(GlassblowingRecipe.Type.INSTANCE, inventory, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
    }

    private static void craftItem(GlassKilnBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<GlassblowingRecipe> match = level.getRecipeManager().getRecipeFor(GlassblowingRecipe.Type.INSTANCE, inventory, level);

        // need one for each slot in the GUI defined here
        if (match.isPresent()) {

            // check input 1 for tool and damage it if not at max damage rather than extract it, otherwise extract item
            if (entity.itemHandler.getStackInSlot(0).getItem() == ModItems.GLASSBLOWING_PIPE.get()
                    && (entity.itemHandler.getStackInSlot(0).getDamageValue() != entity.itemHandler.getStackInSlot(0).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(0).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(0).getItem() == ModItems.GLASSBLOWER_SHEARS.get()
                    && (entity.itemHandler.getStackInSlot(0).getDamageValue() != entity.itemHandler.getStackInSlot(0).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(0).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(0).getItem() == ModItems.MARVER.get()
                    && (entity.itemHandler.getStackInSlot(0).getDamageValue() != entity.itemHandler.getStackInSlot(0).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(0).hurt(1, new SingleThreadedRandomSource(1), null);
            } else {
                entity.itemHandler.extractItem(0, 1, false);
            }
            // check input 2 for tool and damage it if not at max damage rather than extract it, otherwise extract item
            if (entity.itemHandler.getStackInSlot(1).getItem() == ModItems.GLASSBLOWING_PIPE.get()
                    && (entity.itemHandler.getStackInSlot(1).getDamageValue() != entity.itemHandler.getStackInSlot(1).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(1).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(1).getItem() == ModItems.GLASSBLOWER_SHEARS.get()
                    && (entity.itemHandler.getStackInSlot(1).getDamageValue() != entity.itemHandler.getStackInSlot(1).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(1).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(1).getItem() == ModItems.MARVER.get()
                    && (entity.itemHandler.getStackInSlot(1).getDamageValue() != entity.itemHandler.getStackInSlot(1).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(1).hurt(1, new SingleThreadedRandomSource(1), null);
            } else {
                entity.itemHandler.extractItem(1, 1, false);
            }
            // check input 3 for tool and damage it if not at max damage rather than extract it, otherwise extract item
            if (entity.itemHandler.getStackInSlot(2).getItem() == ModItems.GLASSBLOWING_PIPE.get()
                    && (entity.itemHandler.getStackInSlot(2).getDamageValue() != entity.itemHandler.getStackInSlot(2).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(2).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(2).getItem() == ModItems.GLASSBLOWER_SHEARS.get()
                    && (entity.itemHandler.getStackInSlot(2).getDamageValue() != entity.itemHandler.getStackInSlot(2).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(2).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(2).getItem() == ModItems.MARVER.get()
                    && (entity.itemHandler.getStackInSlot(2).getDamageValue() != entity.itemHandler.getStackInSlot(2).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(2).hurt(1, new SingleThreadedRandomSource(1), null);
            } else {
                entity.itemHandler.extractItem(2, 1, false);
            }
            // check input 4 for tool and damage it if not at max damage rather than extract it, otherwise extract item
            if (entity.itemHandler.getStackInSlot(3).getItem() == ModItems.GLASSBLOWING_PIPE.get()
                    && (entity.itemHandler.getStackInSlot(3).getDamageValue() != entity.itemHandler.getStackInSlot(3).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(3).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(3).getItem() == ModItems.GLASSBLOWER_SHEARS.get()
                    && (entity.itemHandler.getStackInSlot(3).getDamageValue() != entity.itemHandler.getStackInSlot(3).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(3).hurt(1, new SingleThreadedRandomSource(1), null);
            } else if (entity.itemHandler.getStackInSlot(3).getItem() == ModItems.MARVER.get()
                    && (entity.itemHandler.getStackInSlot(3).getDamageValue() != entity.itemHandler.getStackInSlot(3).getMaxDamage())) {
                entity.itemHandler.getStackInSlot(3).hurt(1, new SingleThreadedRandomSource(1), null);
            } else {
                entity.itemHandler.extractItem(3, 1, false);
            }

            // place product of recipe into result slot
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