package net.warrentode.todevillagers.screens.slots;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.warrentode.todevillagers.recipes.GlassblowingRecipe;
import org.jetbrains.annotations.NotNull;

public class ModFuelSlot extends SlotItemHandler {

    public ModFuelSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    private boolean isFuel(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, GlassblowingRecipe.Type.INSTANCE) > 0;
    }

    public boolean mayPlace(@NotNull ItemStack stack) {
        return this.isFuel(stack) || isBucket(stack);
    }

    public int getMaxStackSize(@NotNull ItemStack stack) {
        return isBucket(stack) ? 1 : super.getMaxStackSize(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.is(Items.BUCKET);
    }
}