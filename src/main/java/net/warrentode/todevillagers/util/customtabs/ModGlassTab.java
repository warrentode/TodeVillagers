package net.warrentode.todevillagers.util.customtabs;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.warrentode.todevillagers.blocks.ModBlocks;
import net.warrentode.todevillagers.items.ModItems;
import org.jetbrains.annotations.NotNull;

public class ModGlassTab extends CreativeModeTab {
    public static final ModGlassTab TODEVILLAGERS_GLASS_TAB = new ModGlassTab(CreativeModeTab.TABS.length, "todevillagers_glass_tab");

    public ModGlassTab(int length, String label) {
        super(length, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(ModBlocks.REINFORCED_GLASS.get());
    }

    @Override
    public void fillItemList(final @NotNull NonNullList<ItemStack> items) {
        items.add(ModItems.GLASSBLOWER_SHEARS.get().getDefaultInstance());
        items.add(ModItems.GLASSBLOWING_PIPE.get().getDefaultInstance());
        items.add(ModItems.MARVER.get().getDefaultInstance());
        items.add(ModItems.CRUSHED_GLASS.get().getDefaultInstance());
        items.add((ModBlocks.GLASS_KILN.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.REINFORCED_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.GLOWING_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.SHIFTING_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
        items.add((Blocks.TINTED_GLASS.asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_PANE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_STAIRS.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_SLAB.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_WALL.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_FENCE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_BUTTON.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_DOOR.get().asItem().getDefaultInstance()));
        items.add((ModBlocks.TINTED_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
    }
}