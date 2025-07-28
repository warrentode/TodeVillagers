package com.github.warrentode.todevillagers.block.custom.glasskiln.screens;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.block.custom.glasskiln.GlassKilnBlockEntity;
import com.github.warrentode.todevillagers.block.custom.glasskiln.slots.GlassKilnFuelSlot;
import com.github.warrentode.todevillagers.block.custom.glasskiln.slots.GlassKilnResultSlot;
import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.utils.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@SuppressWarnings("CanBeFinal")
public class GlassKilnMenu extends RecipeBookMenu<RecipeWrapper> {
    public static int FUEL_SLOT = 4;
    public static int RESULT_SLOT = 5;
    public static int INVENTORY_SIZE = RESULT_SLOT + 1;
    public final GlassKilnBlockEntity kilnBlock;
    public final ItemStackHandler inventory;
    protected final Level level;
    private final ContainerData kilnBlockData;
    @SuppressWarnings("unused")
    private final ContainerLevelAccess canInteractWithCallable;

    public GlassKilnMenu(int id, Inventory playerInventory, BlockEntity blockEntity, ContainerData data) {
        super(ModMenuTypes.GLASS_KILN_MENU.get(), id);
        this.kilnBlock = (GlassKilnBlockEntity) blockEntity;
        this.inventory = ((GlassKilnBlockEntity) blockEntity).getInventory();
        this.kilnBlockData = data;
        this.level = playerInventory.player.level();
        this.canInteractWithCallable = ContainerLevelAccess.create(Objects.requireNonNull(kilnBlock.getLevel()), kilnBlock.getBlockPos());
        /* this value must be the same as the one given for the size of the itemStackHandler within the GlassKilnBlockEntity */
        checkContainerSize(playerInventory, 6);

        // Ingredient Slots - 2 Rows x 2 Columns
        int startX = 8;
        @SuppressWarnings("unused") int startY = 18;
        int borderSlotSize = 18;

        int inputStartX = 43;
        int inputStartY = 18;
        int totalRows = 2;
        int totalCols = 2;
        for (int row = 0; row < totalRows; ++row) {
            for (int column = 0; column < totalCols; ++column) {
                this.addSlot(new SlotItemHandler(inventory, (row * totalCols) + column,
                        inputStartX + (column * (borderSlotSize + 1)),
                        inputStartY + (row * (borderSlotSize + 1))));
            }
        }
        // Fuel Slot
        this.addSlot(new GlassKilnFuelSlot(kilnBlockData, inventory, FUEL_SLOT, 62, 63));
        // Result Slot
        this.addSlot(new GlassKilnResultSlot(playerInventory.player, kilnBlock, inventory, RESULT_SLOT, 122, 45));

        // Player Inventory
        int startPlayerInvY = 86;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * borderSlotSize),
                        startPlayerInvY + (row * borderSlotSize)));
            }
        }

        // Player Hotbar
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startX + (column * borderSlotSize), 144));
        }

        addDataSlots(data);
    }

    public GlassKilnMenu(int id, Inventory inventory, @NotNull FriendlyByteBuf extraData) {
        /* the size of the SimpleContainerData must be the same size the getCount within the GlassKilnBlockEntity container data
         * be sure to change these values when you readjust these methods to track furnace/fuel data as well  */
        this(id, inventory, Objects.requireNonNull(inventory.player.level().getBlockEntity(extraData.readBlockPos())), new SimpleContainerData(4));
    }

    private static GlassKilnBlockEntity getBlockEntity(final Inventory playerInventory, final FriendlyByteBuf data) {
        Objects.requireNonNull(playerInventory, "playerInventory for Glass Kiln cannot be null");
        Objects.requireNonNull(data, "Glass Kiln data cannot be null");
        final BlockEntity blockAtPos = playerInventory.player.level().getBlockEntity(data.readBlockPos());
        if (blockAtPos instanceof GlassKilnBlockEntity) {
            return (GlassKilnBlockEntity) blockAtPos;
        }
        throw new IllegalStateException("Glass Kiln entity is not correct! " + blockAtPos);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(ContainerLevelAccess.create(level, kilnBlock.getBlockPos()),
                player, ModBlocks.GLASS_KILN_BLOCK.get());
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        @SuppressWarnings("unused") int fuelIndex = FUEL_SLOT;
        int resultIndex = RESULT_SLOT;
        int startPlayerInv = resultIndex + 1;
        int endPlayerInv = startPlayerInv + 36;
        ItemStack slotStackCopy = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            slotStackCopy = slotStack.copy();
            if (index > RESULT_SLOT) {
                if (!moveItemStackTo(slotStackCopy, 0, RESULT_SLOT, false)) {
                    return ItemStack.EMPTY;  // EMPTY_ITEM
                }
            }
            else if (index < startPlayerInv) {
                if (!moveItemStackTo(slotStackCopy, startPlayerInv, endPlayerInv, false)) {
                    return ItemStack.EMPTY;  // EMPTY_ITEM
                }
            }
            else {
                System.out.println("Invalid slotIndex:" + index);
                return ItemStack.EMPTY;
            }

            if (slotStackCopy.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            }
            else {
                slot.setChanged();
            }

            slot.onTake(playerIn, slotStack);
        }

        slot.onTake(playerIn, slotStackCopy);
        return slotStackCopy;
    }

    public boolean isCrafting() {
        return kilnBlockData.get(0) > 0;
    }

    public boolean hasFuel() {
        return kilnBlockData.get(2) > 0;
    }

    public boolean isFuel(ItemStack stack) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, null) > 0;
    }

    public int getScaledProgress() {
        // these are from the cases set in the matching block entity class file
        int progress = this.kilnBlockData.get(0);
        int maxProgress = this.kilnBlockData.get(1);
        // the pixel length or height of the progress arrow/bar in this GUI
        // if your arrow/bar is vertical, you need the height, otherwise you need the length
        int progressArrowSize = 22;

        // this calculates how much of that progress arrow/bar needs to be rendered in the GUI
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledFuelProgress() {
        // these are from the cases set in the matching block entity class file
        int fuelTime = this.kilnBlockData.get(2);
        int fuelDuration = this.kilnBlockData.get(3);
        // the pixel length or height of the progress arrow/bar in this GUI
        // if your arrow/bar is vertical, you need the height, otherwise you need the length
        int fuelScaleSize = 60;

        // this calculates how much of that progress arrow/bar needs to be rendered in the GUI
        return fuelDuration != 0 ? (int) (((float) fuelTime / (float) fuelDuration) * fuelScaleSize) : 0;
    }

    @Override
    public void fillCraftSlotsStackedContents(@NotNull StackedContents helper) {
        for (int i = 0; i < inventory.getSlots(); i++) {
            helper.accountSimpleStack(inventory.getStackInSlot(i));
        }
    }

    @Override
    public void clearCraftingContent() {
        for (int i = 0; i < 2; i++) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    @Override
    public boolean recipeMatches(@NotNull Recipe<? super RecipeWrapper> recipe) {
        return recipe.matches(new RecipeWrapper(inventory), level);
    }

    @Override
    public int getResultSlotIndex() {
        return RESULT_SLOT;
    }

    @Override
    public int getGridWidth() {
        // width of ingredient slots
        return 2;
    }

    @Override
    public int getGridHeight() {
        // height of ingredient slots
        return 2;
    }

    @Override
    public int getSize() {
        return INVENTORY_SIZE;
    }

    @Override
    public @NotNull RecipeBookType getRecipeBookType() {
        return ModRecipes.GLASSBLOWING_BOOK;
    }

    @Override
    public boolean shouldMoveToInventory(int slot) {
        return slot < (getGridWidth() * getGridHeight());
    }
}