package com.github.warrentode.todevillagers.block.custom.glasskiln.slots;

import com.github.warrentode.todevillagers.block.custom.glasskiln.GlassKilnBlockEntity;
import com.github.warrentode.todevillagers.recipes.ModRecipes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collections;

public class GlassKilnResultSlot extends SlotItemHandler {
    public final GlassKilnBlockEntity kilnBlockEntity;
    private final Player player;
    private int removeCount;

    public GlassKilnResultSlot(Player player, GlassKilnBlockEntity kilnBlockEntity, IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
        this.kilnBlockEntity = kilnBlockEntity;
        this.player = player;
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, ModRecipes.RECIPE_TYPE_GLASSBLOWING.get()) > 0;
    }

    @Override
    @Nonnull
    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }

        return super.remove(amount);
    }

    @Override
    public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
        this.checkTakeAchievements(stack);
        super.onTake(player, stack);
    }

    @Override
    protected void onQuickCraft(@NotNull ItemStack stack, int amount) {
        this.removeCount += amount;
        this.checkTakeAchievements(stack);
    }

    @Override
    protected void checkTakeAchievements(@NotNull ItemStack stack) {
        stack.onCraftedBy(this.player.level(), this.player, this.removeCount);

        if (!this.player.level().isClientSide) {
            kilnBlockEntity.awardUsedRecipes(this.player, Collections.singletonList(stack));
        }

        this.removeCount = 0;
    }
}