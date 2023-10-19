package com.github.warrentode.todevillagers.block.custom.glasskiln.slots;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class GlassKilnItemHandler implements IItemHandler {
    private static final int FUEL_SLOT = 4;
    private static final int RESULT_SLOT = 5;
    private static final int INVENTORY_SIZE = RESULT_SLOT + 1;
    private final IItemHandler handler;
    private final Direction side;
    private final Predicate<Integer> extract;
    private final BiPredicate<Integer, ItemStack> insert;

    public GlassKilnItemHandler(IItemHandler handler, BiPredicate<Integer, ItemStack> insert, Predicate<Integer> extract, @Nullable Direction side) {
        this.handler = handler;
        this.side = side;
        this.extract = extract;
        this.insert = insert;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return handler.isItemValid(slot, stack);
    }

    @Override
    public int getSlots() {
        return handler.getSlots();
    }

    @Override
    @Nonnull
    public ItemStack getStackInSlot(int slot) {
        return handler.getStackInSlot(slot);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        return this.insert.test(slot, stack) ? this.handler.insertItem(slot, stack, simulate) : stack;
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return this.extract.test(slot) ? this.handler.extractItem(slot, amount, simulate) : ItemStack.EMPTY;
    }

    @Override
    public int getSlotLimit(int slot) {
        return handler.getSlotLimit(slot);
    }
}