package com.github.warrentode.todevillagers.utils;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class ModGlassTab extends CreativeModeTab {
    public static final ModGlassTab TODEVILLAGERS_GLASS_TAB = new ModGlassTab("todevillagers_glass_tab");

    public ModGlassTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModBlocks.REINFORCED_GLASS.get());
    }

    @Override
    public void fillItemList(final @NotNull NonNullList<ItemStack> items) {
        items.add((ModBlocks.GLASS_KILN_BLOCK.get().asItem().getDefaultInstance()));
        items.add(ModItems.GLASSBLOWER_SHEARS.get().getDefaultInstance());
        items.add(ModItems.GLASSBLOWING_PIPE.get().getDefaultInstance());
        items.add(ModItems.MARVER.get().getDefaultInstance());
        items.add(ModItems.CRUSHED_GLASS.get().getDefaultInstance());

        items.add(Items.GLASS_BOTTLE.getDefaultInstance());

        items.add((ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS.get().asItem().getDefaultInstance()));
        items.add((Blocks.TINTED_GLASS.asItem().getDefaultInstance()));

        items.add((Blocks.GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.WHITE_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.ORANGE_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.MAGENTA_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.LIGHT_BLUE_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.YELLOW_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.LIME_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.PINK_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.GRAY_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.LIGHT_GRAY_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.CYAN_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.PURPLE_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.BLUE_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.BROWN_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.GREEN_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.RED_STAINED_GLASS.asItem().getDefaultInstance()));
        items.add((Blocks.BLACK_STAINED_GLASS.asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_PANE.get().asItem().getDefaultInstance()));

        items.add((Blocks.GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.WHITE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.ORANGE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.MAGENTA_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.LIGHT_BLUE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.YELLOW_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.LIME_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.PINK_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.GRAY_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.LIGHT_GRAY_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.CYAN_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.PURPLE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.BLUE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.BROWN_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.GREEN_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.RED_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
        items.add((Blocks.BLACK_STAINED_GLASS_PANE.asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_STAIRS.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_SLAB.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_WALL.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_FENCE.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_BUTTON.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_DOOR.get().asItem().getDefaultInstance()));

        items.add((ModBlocks.REINFORCED_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
    }
}