package com.github.warrentode.todevillagers.block.custom.ceramics_table.slots;

import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class CeramicKilnFuelSlot extends SlotItemHandler {
    private final ContainerData kilnBlockData;

    public CeramicKilnFuelSlot(ContainerData kilnBlockData, IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
        this.kilnBlockData = kilnBlockData;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, null) > 0 || isBucket(stack);
    }

    @Override
    public int getMaxStackSize(@NotNull ItemStack stack) {
        return isBucket(stack) ? 1 : super.getMaxStackSize(stack);
    }

    public static boolean isBucket(@NotNull ItemStack stack) {
        return stack.is(Items.BUCKET);
    }
}