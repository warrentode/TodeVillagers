package com.github.warrentode.todevillagers.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> GLASS = forgeBlockTag("glass");
        public static final TagKey<Block> GLASS_COLORLESS = forgeBlockTag("glass/colorless");
        public static final TagKey<Block> GLASS_SILICA = forgeBlockTag("glass/silica");
        public static final TagKey<Block> GLASS_TINTED = forgeBlockTag("glass/tinted");
        public static final TagKey<Block> STAINED_GLASS = forgeBlockTag("stained_glass");
        public static final TagKey<Block> GLASS_INFUSED = modBlockTag("glass/infused");
        public static final TagKey<Block> GLASS_REINFORCED = modBlockTag("glass/reinforced");
        public static final TagKey<Block> GLASS_GLOWING = modBlockTag("glass/glowing");
        public static final TagKey<Block> GLASS_SHIFTING = modBlockTag("glass/shifting");
        public static final TagKey<Block> GLASS_BUTTONS = modBlockTag("glass_buttons");
        public static final TagKey<Block> GLASS_DOORS = modBlockTag("glass_doors");
        public static final TagKey<Block> GLASS_FENCE_GATES = modBlockTag("glass_fence_gates");
        public static final TagKey<Block> GLASS_FENCES = modBlockTag("glass_fences");
        public static final TagKey<Block> GLASS_PANES = forgeBlockTag("glass_panes");
        public static final TagKey<Block> GLASS_PANES_COLORLESS = forgeBlockTag("glass_panes/colorless");
        public static final TagKey<Block> GLASS_PANES_SILICA = modBlockTag("glass_panes/silica");
        public static final TagKey<Block> GLASS_PANES_TINTED = modBlockTag("glass_panes/tinted");
        public static final TagKey<Block> STAINED_GLASS_PANES = forgeBlockTag("stained_glass_panes");
        public static final TagKey<Block> GLASS_PANES_REINFORCED = modBlockTag("glass_panes/reinforced");
        public static final TagKey<Block> GLASS_PANES_GLOWING = modBlockTag("glass_panes/glowing");
        public static final TagKey<Block> GLASS_PANES_SHIFTING = modBlockTag("glass_panes/shifting");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES = modBlockTag("glass_pressure_plates");
        public static final TagKey<Block> GLASS_SLABS = modBlockTag("glass_slabs");
        public static final TagKey<Block> GLASS_STAIRS = modBlockTag("glass_stairs");
        public static final TagKey<Block> GLASS_TRAPDOORS = modBlockTag("glass_trapdoors");
        public static final TagKey<Block> GLASS_WALLS = modBlockTag("glass_walls");
        public static final TagKey<Block> SAND = forgeBlockTag("sand");
        public static final TagKey<Block> SAND_COLORLESS = forgeBlockTag("sand/colorless");
        public static final TagKey<Block> SAND_RED = forgeBlockTag("sand/red");
        public static final TagKey<Block> SAND_ORANGE = forgeBlockTag("sand/orange");
        public static final TagKey<Block> SAND_BLACK = forgeBlockTag("sand/black");
        public static final TagKey<Block> SAND_WHITE = forgeBlockTag("sand/white");
    }

    public static class Items {
        public static final TagKey<Item> GLASSBLOWER_TOOLS = modItemTag("glassblower_tools");
        public static final TagKey<Item> GLASS = forgeItemTag("glass");
        public static final TagKey<Item> GLASS_COLORLESS = forgeItemTag("glass/colorless");
        public static final TagKey<Item> GLASS_SILICA = forgeItemTag("glass/silica");
        public static final TagKey<Item> GLASS_TINTED = forgeItemTag("glass/tinted");
        public static final TagKey<Item> STAINED_GLASS = forgeItemTag("stained_glass");
        public static final TagKey<Item> GLASS_INFUSED = modItemTag("glass/infused");
        public static final TagKey<Item> GLASS_REINFORCED = modItemTag("glass/reinforced");
        public static final TagKey<Item> GLASS_GLOWING = modItemTag("glass/glowing");
        public static final TagKey<Item> GLASS_SHIFTING = modItemTag("glass/shifting");
        public static final TagKey<Item> GLASS_BUTTONS = modItemTag("glass_buttons");
        public static final TagKey<Item> GLASS_DOORS = modItemTag("glass_doors");
        public static final TagKey<Item> GLASS_FENCE_GATES = modItemTag("glass_fence_gates");
        public static final TagKey<Item> GLASS_FENCES = modItemTag("glass_fences");
        public static final TagKey<Item> GLASS_PANES = forgeItemTag("glass_panes");
        public static final TagKey<Item> GLASS_PANES_COLORLESS = forgeItemTag("glass_panes/colorless");
        public static final TagKey<Item> GLASS_PANES_SILICA = modItemTag("glass_panes/silica");
        public static final TagKey<Item> GLASS_PANES_TINTED = modItemTag("glass_panes/tinted");
        public static final TagKey<Item> STAINED_GLASS_PANES = forgeItemTag("stained_glass_panes");
        public static final TagKey<Item> GLASS_PANES_REINFORCED = modItemTag("glass_panes/reinforced");
        public static final TagKey<Item> GLASS_PANES_GLOWING = modItemTag("glass_panes/glowing");
        public static final TagKey<Item> GLASS_PANES_SHIFTING = modItemTag("glass_panes/shifting");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES = modItemTag("glass_pressure_plates");
        public static final TagKey<Item> GLASS_SLABS = modItemTag("glass_slabs");
        public static final TagKey<Item> GLASS_STAIRS = modItemTag("glass_stairs");
        public static final TagKey<Item> GLASS_TRAPDOORS = modItemTag("glass_trapdoors");
        public static final TagKey<Item> GLASS_WALLS = modItemTag("glass_walls");
        public static final TagKey<Item> SAND = forgeItemTag("sand");
        public static final TagKey<Item> SAND_COLORLESS = forgeItemTag("sand/colorless");
        public static final TagKey<Item> SAND_RED = forgeItemTag("sand/red");
        public static final TagKey<Item> SAND_ORANGE = forgeItemTag("sand/orange");
        public static final TagKey<Item> SAND_BLACK = forgeItemTag("sand/black");
        public static final TagKey<Item> SAND_WHITE = forgeItemTag("sand/white");
    }

    private static TagKey<Block> modBlockTag(String path) {
        return BlockTags.create(new ResourceLocation(MODID, path));
    }

    private static TagKey<Item> modItemTag(String path) {
        return ItemTags.create(new ResourceLocation(MODID, path));
    }

    private static TagKey<Block> forgeBlockTag(String path) {
        return BlockTags.create(new ResourceLocation("forge", path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(new ResourceLocation("forge", path));
    }
}