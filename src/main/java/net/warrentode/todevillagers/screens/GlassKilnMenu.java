package net.warrentode.todevillagers.screens;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import net.warrentode.todevillagers.blocks.ModBlocks;
import net.warrentode.todevillagers.blocks.entity.GlassKilnBlockEntity;
import net.warrentode.todevillagers.screens.slots.ModFuelSlot;
import net.warrentode.todevillagers.screens.slots.ModResultSlot;
import org.jetbrains.annotations.NotNull;

public class GlassKilnMenu extends AbstractContainerMenu {
    public final GlassKilnBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public GlassKilnMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        /* the size of the SimpleContainerData must be the same size the getCount within the GlassKilnBlockEntity container data
         * be sure to change these values when you readjust these methods to track furnace/fuel data as well  */
        this(id, inventory, inventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    public GlassKilnMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.GLASS_KILN_MENU.get(), id);
        /* this value must be the same as the one given for the size of the itemStackHandler within the GlassKilnBlockEntity */
        checkContainerSize(inventory, 6);
        blockEntity = (GlassKilnBlockEntity) entity;
        this.level = inventory.player.level;
        this.data = data;

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            // need one "addSlot" for each slot in your GUI
            // the index is the slot's number
            // x and y is the pixel position of that slot
            /* you can also label the result slot and create a ResultSlot extending SlotItemHandler class file
             * to block items from being placed into that particular slot  */
            this.addSlot(new SlotItemHandler(handler, 0,43, 18));
            this.addSlot(new SlotItemHandler(handler, 1,62, 18));
            this.addSlot(new SlotItemHandler(handler, 2,43, 37));
            this.addSlot(new SlotItemHandler(handler, 3,62, 37));
            this.addSlot(new ModFuelSlot(handler, 4,62, 63));
            this.addSlot(new ModResultSlot(handler, 5,122, 45));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public boolean hasFuel() {
        return data.get(2) > 0;
    }

    public int getScaledProgress() {
        // these are from the cases set in the matching block entity class file
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        // the pixel length or height of the progress arrow/bar in this GUI
        // if your arrow/bar is vertical, you need the height, otherwise you need the length
        int progressArrowSize = 22;

        // this calculates how much of that progress arrow/bar needs to be rendered in the GUI
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledFuelProgress() {
        // these are from the cases set in the matching block entity class file
        int fuelTime = this.data.get(2);
        int fuelDuration = this.data.get(3);
        // the pixel length or height of the progress arrow/bar in this GUI
        // if your arrow/bar is vertical, you need the height, otherwise you need the length
        int fuelScaleSize = 60;

        // this calculates how much of that progress arrow/bar needs to be rendered in the GUI
        return fuelDuration != 0 ? (int)(((float)fuelTime / (float)fuelDuration) * fuelScaleSize) : 0;
    }

    /* quickMoveStack method start (the shift click remove stack in game) */

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    // must be the number of slots you have!
    /* this value is defined within the checkContainerSize above */
    /* failure to set this one value correctly will cause a crash */
    private static final int TE_INVENTORY_SLOT_COUNT = 6;

    /* all this big chuck of "stuff" is just calculating whether a stack of items can be quickly moved into any given slot
     * within the player's inventory or hotbar slots, so system needs to know where the slots are and how many items are
     * in the slot being checked and whether that slot has a matching stackable item for the moving stack to be merged into
     * if the slot being checked is full or not matching, the system moves on to check the next slot and so on until either the moving stack has
     * finished moving or all the slots have been checked */
    /* we see this in action all the time whenever we shift click something from a crafting result slot to dump it all into our inventory in one shot
     * this series of if/then/else statements is what makes that possible */
    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    /* quickMoveStack method end */

    @Override
    public boolean stillValid(@NotNull Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.GLASS_KILN.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }

}