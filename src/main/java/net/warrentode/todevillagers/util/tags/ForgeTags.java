package net.warrentode.todevillagers.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {

    @SuppressWarnings("unused")
    public static class Blocks {
        public static final TagKey<Block> GLASS_BUTTONS = forgeBlockTag("glass_buttons");
        public static final TagKey<Block> GLASS_DOORS = forgeBlockTag("glass_doors");
        public static final TagKey<Block> GLASS_FENCE_GATES = forgeBlockTag("glass_fence_gates");
        public static final TagKey<Block> GLASS_FENCES = forgeBlockTag("glass_fences");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES = forgeBlockTag("glass_pressure_plates");
        public static final TagKey<Block> GLASS_SLABS = forgeBlockTag("glass_slabs");
        public static final TagKey<Block> GLASS_STAIRS = forgeBlockTag("glass_stairs");
        public static final TagKey<Block> GLASS_TRAPDOORS = forgeBlockTag("glass_trapdoors");
        public static final TagKey<Block> GLASS_WALLS = forgeBlockTag("glass_walls");
    }

    @SuppressWarnings("unused")
    public static class Items {
        public static final TagKey<Item> GLASS_BUTTONS = forgeItemTag("glass_buttons");
        public static final TagKey<Item> GLASS_DOORS = forgeItemTag("glass_doors");
        public static final TagKey<Item> GLASS_FENCE_GATES = forgeItemTag("glass_fence_gates");
        public static final TagKey<Item> GLASS_FENCES = forgeItemTag("glass_fences");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES = forgeItemTag("glass_pressure_plates");
        public static final TagKey<Item> GLASS_SLABS = forgeItemTag("glass_slabs");
        public static final TagKey<Item> GLASS_STAIRS = forgeItemTag("glass_stairs");
        public static final TagKey<Item> GLASS_TRAPDOORS = forgeItemTag("glass_trapdoors");
        public static final TagKey<Item> GLASS_WALLS = forgeItemTag("glass_walls");
    }

    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }
}
