package net.warrentode.todevillagers.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> GLASS = modBlockTag("glass");
        public static final TagKey<Block> GLASS_BUTTONS = modBlockTag("glass_buttons");
        public static final TagKey<Block> GLASS_DOORS = modBlockTag("glass_doors");
        public static final TagKey<Block> GLASS_FENCE_GATES = modBlockTag("glass_fence_gates");
        public static final TagKey<Block> GLASS_FENCES = modBlockTag("glass_fences");
        public static final TagKey<Block> GLASS_PANES = modBlockTag("glass_panes");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES = modBlockTag("glass_pressure_plates");
        public static final TagKey<Block> GLASS_SLABS = modBlockTag("glass_slabs");
        public static final TagKey<Block> GLASS_STAIRS = modBlockTag("glass_stairs");
        public static final TagKey<Block> GLASS_TRAPDOORS = modBlockTag("glass_trapdoors");
        public static final TagKey<Block> GLASS_WALLS = modBlockTag("glass_walls");
        public static final TagKey<Block> SAND = modBlockTag("sand");
    }

    public static class Items {
        public static final TagKey<Item> GLASS = modItemTag("glass");
        public static final TagKey<Item> GLASS_BUTTONS = modItemTag("glass_buttons");
        public static final TagKey<Item> GLASS_DOORS = modItemTag("glass_doors");
        public static final TagKey<Item> GLASS_FENCE_GATES = modItemTag("glass_fence_gates");
        public static final TagKey<Item> GLASS_FENCES = modItemTag("glass_fences");
        public static final TagKey<Item> GLASS_PANES = modItemTag("glass_panes");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES = modItemTag("glass_pressure_plates");
        public static final TagKey<Item> GLASS_SLABS = modItemTag("glass_slabs");
        public static final TagKey<Item> GLASS_STAIRS = modItemTag("glass_stairs");
        public static final TagKey<Item> GLASS_TRAPDOORS = modItemTag("glass_trapdoors");
        public static final TagKey<Item> GLASS_WALLS = modItemTag("glass_walls");
        public static final TagKey<Item> SAND = modItemTag("sand");
    }


    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, path));
    }
    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, path));
    }
}