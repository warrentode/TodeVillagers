package net.warrentode.todevillagers.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab TODEVILLAGERS_TAB = new CreativeModeTab("todevillagers_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.LECTERN);
        }
    };
}
