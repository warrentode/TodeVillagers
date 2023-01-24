package net.warrentode.todevillagers.util;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.warrentode.todevillagers.blocks.ModBlocks;
import net.warrentode.todevillagers.items.ModItems;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab extends CreativeModeTab {
    public static final ModCreativeModeTab TODEVILLAGERS_TAB = new ModCreativeModeTab(CreativeModeTab.TABS.length, "todevillagers_tab");

    public ModCreativeModeTab(int length, String label) {
        super(length, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Items.LECTERN);
    }

    @Override
    public void fillItemList(final NonNullList<ItemStack> items) {
        items.add(ModItems.GLASSBLOWER_SHEARS.get().getDefaultInstance());
        items.add(ModItems.GLASSBLOWING_PIPE.get().getDefaultInstance());
        items.add(ModItems.MARVER.get().getDefaultInstance());
        items.add(ModItems.CHAKRA_DREAM_MUSIC_DISC.get().getDefaultInstance());
        items.add((ModBlocks.GLASS_KILN.get().asItem().getDefaultInstance()));
    }
}