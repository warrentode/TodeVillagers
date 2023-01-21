package net.warrentode.todevillagers.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
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
    protected static final int FUEL = 0;
    protected static final int INGREDIENT = 1;
    protected static final int TOOL = 2;
    protected static final int DYE = 3;
    protected static final int MODIFIER = 4;
    protected static final int RESULT = 5;

    protected static ContainerData data;
    private int litTime = 0;
    private static int burnTime = 0;
    private int burnDuration = 0;
    private int progress = 0;
    private int maxProgress = 100;

    public GlassKilnBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GLASS_KILN_ENTITY.get(), pPos, pBlockState);
        data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> GlassKilnBlockEntity.this.progress;
                    case 1 -> GlassKilnBlockEntity.this.maxProgress;
                    case 2 -> burnTime;
                    case 3 -> GlassKilnBlockEntity.this.burnDuration;
                    case 4 -> GlassKilnBlockEntity.this.litTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> GlassKilnBlockEntity.this.progress = pValue;
                    case 1 -> GlassKilnBlockEntity.this.maxProgress = pValue;
                    case 2 -> burnTime = pValue;
                    case 3 -> GlassKilnBlockEntity.this.burnDuration = pValue;
                    case 4 -> GlassKilnBlockEntity.this.litTime = pValue;
                }
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
    }

    @Override
    public @NotNull Component getDisplayName()  {
        return Component.translatable("container.todevillagers.glass_kiln");
    }

    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return new GlassKilnMenu(pContainerId, pPlayerInventory, this, data);
    }


    private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.empty();

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

    public boolean burnOn() {
        return burnTime > 0;
    }

    public void tick(Level level, BlockPos pos, BlockState state, GlassKilnBlockEntity pEntity) {
        boolean burnOff = pEntity.burnOn();
        boolean smoke = false;
        if (pEntity.burnOn()) {
            data.set(burnTime, data.get(burnTime) - 1);
            state = state.setValue(GlassKilnBlock.LIT, pEntity.burnOn());
            level.setBlock(pos, state, 3);
        }

        if (level != null && !level.isClientSide()) {
            ItemStack fuel = pEntity.itemHandler.getStackInSlot(FUEL);
            boolean valid = false;
            if (pEntity.burnOn() || !fuel.isEmpty() && !pEntity.itemHandler.getStackInSlot(INGREDIENT).isEmpty()) {
                GlassblowingRecipe pRecipe = pEntity.getRecipe();
                valid = pEntity.canBurn(pRecipe);
                if (!pEntity.burnOn() && valid) {
                    data.set(burnTime, pEntity.getBurnDuration(fuel));
                    pEntity.litTime = pEntity.getBurnDuration(fuel);
                    if (pEntity.burnOn()) {
                        smoke = true;
                        if (fuel.hasCraftingRemainingItem())
                            pEntity.itemHandler.setStackInSlot(0, fuel.getCraftingRemainingItem());
                        else if (!fuel.isEmpty()) {
                            fuel.shrink(1);
                            if (fuel.isEmpty()) {
                                pEntity.itemHandler.setStackInSlot(0, fuel.getCraftingRemainingItem());
                            }
                        }
                    }
                }
            }

            if (pEntity.burnOn() && valid) {
                data.set(this.progress, (this.progress + 1));
                if (this.progress == this.maxProgress) {
                    this.progress = 0;
                    craftItem(pEntity);
                    smoke = true;
                }
            } else {
                this.progress = 0;
            }
        } else if (!pEntity.burnOn() && pEntity.progress > 0) {
            data.set(progress, Mth.clamp(data.get(progress) - 2, 0, data.get(maxProgress)));
        }

        if (burnOff != pEntity.burnOn()) {
            smoke = true;
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, pEntity.burnOn()), 3);
        }

        if (smoke) {
            pEntity.setChanged();
        }
    }

    private int getBurnDuration(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        } else {
            fuel.getItem();
            return ForgeHooks.getBurnTime(fuel, GlassblowingRecipe.Type.INSTANCE);
        }
    }

    private boolean canBurn(GlassblowingRecipe recipe) {
        if (!this.itemHandler.getStackInSlot(1).isEmpty() && recipe != null) {
            ItemStack recipeResult = recipe.getResultItem();
            if (!recipeResult.isEmpty()) {
                ItemStack result = this.itemHandler.getStackInSlot(RESULT);
                if (result.isEmpty()) return true;
                else if (!result.sameItem(recipeResult)) return false;
                else return result.getCount() + recipeResult.getCount() <= result.getMaxStackSize();
            }
        }
        return false;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem(GlassKilnBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<GlassblowingRecipe> recipe = level.getRecipeManager().getRecipeFor(GlassblowingRecipe.Type.INSTANCE, inventory, level);

        // need one for each slot in the GUI defined here?
        if (hasRecipe(pEntity)) {
            pEntity.itemHandler.extractItem(1, 1, false);
            pEntity.itemHandler.getStackInSlot(2).hurt(1, new SingleThreadedRandomSource(1), null);
            pEntity.itemHandler.extractItem(3, 1, false);
            pEntity.itemHandler.extractItem(4, 1, false);

            //noinspection OptionalGetWithoutIsPresent
            pEntity.itemHandler.setStackInSlot(5, new ItemStack(recipe.get().getResultItem().getItem(),
                    pEntity.itemHandler.getStackInSlot(2).getCount() + (recipe.get().getResultItem().getCount())));

            pEntity.resetProgress();
        }

        if ((pEntity.itemHandler.getStackInSlot(2).getDamageValue() == 64 && pEntity.itemHandler.getStackInSlot(2).getItem() == ModItems.MARVER.get())
                || (pEntity.itemHandler.getStackInSlot(2).getDamageValue() == 238 && pEntity.itemHandler.getStackInSlot(2).getItem() == Items.SHEARS)) {
            pEntity.itemHandler.extractItem(2,1, false);
        }
    }

    private boolean hasRecipe(GlassKilnBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        assert level != null;
        Optional<GlassblowingRecipe> recipe = level.getRecipeManager().getRecipeFor(GlassblowingRecipe.Type.INSTANCE, inventory, level);

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(5).getItem() == stack.getItem() || inventory.getItem(5).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(5).getMaxStackSize() > inventory.getItem(5).getCount();
    }

    private GlassblowingRecipe recipe;
    public GlassblowingRecipe getRecipe() {
        return recipe;
    }
}