package net.warrentode.todevillagers.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {
    @SuppressWarnings("unused")
    public static class Blocks {
        public static final TagKey<Block> GLASS_REINFORCED = forgeBlockTag("glass/reinforced");
        public static final TagKey<Block> GLASS_GLOWING = forgeBlockTag("glass/glowing");
        public static final TagKey<Block> GLASS_SHIFTING = forgeBlockTag("glass/shifting");

        public static final TagKey<Block> GLASS_PANES_SILICA = forgeBlockTag("glass_panes/silica");
        public static final TagKey<Block> GLASS_PANES_REINFORCED = forgeBlockTag("glass_panes/reinforced");
        public static final TagKey<Block> GLASS_PANES_GLOWING = forgeBlockTag("glass_panes/glowing");
        public static final TagKey<Block> GLASS_PANES_SHIFTING = forgeBlockTag("glass_panes/shifting");
        public static final TagKey<Block> GLASS_PANES_TINTED = forgeBlockTag("glass_panes/tinted");

        public static final TagKey<Block> GLASS_STAIRS = forgeBlockTag("glass_stairs");
        public static final TagKey<Block> GLASS_STAIRS_REINFORCED = forgeBlockTag("glass_stairs/reinforced");
        public static final TagKey<Block> GLASS_STAIRS_GLOWING = forgeBlockTag("glass_stairs/glowing");
        public static final TagKey<Block> GLASS_STAIRS_SHIFTING = forgeBlockTag("glass_stairs/shifting");
        public static final TagKey<Block> GLASS_STAIRS_TINTED = forgeBlockTag("glass_stairs/tinted");

        public static final TagKey<Block> GLASS_SLABS = forgeBlockTag("glass_slabs");
        public static final TagKey<Block> GLASS_SLABS_REINFORCED = forgeBlockTag("glass_slabs/reinforced");
        public static final TagKey<Block> GLASS_SLABS_GLOWING = forgeBlockTag("glass_slabs/glowing");
        public static final TagKey<Block> GLASS_SLABS_SHIFTING = forgeBlockTag("glass_slabs/shifting");
        public static final TagKey<Block> GLASS_SLABS_TINTED = forgeBlockTag("glass_slabs/tinted");

        public static final TagKey<Block> GLASS_WALLS = forgeBlockTag("glass_walls");
        public static final TagKey<Block> GLASS_WALLS_REINFORCED = forgeBlockTag("glass_walls/reinforced");
        public static final TagKey<Block> GLASS_WALLS_GLOWING = forgeBlockTag("glass_walls/glowing");
        public static final TagKey<Block> GLASS_WALLS_SHIFTING = forgeBlockTag("glass_walls/shifting");
        public static final TagKey<Block> GLASS_WALLS_TINTED = forgeBlockTag("glass_walls/tinted");

        public static final TagKey<Block> GLASS_FENCES = forgeBlockTag("glass_fences");
        public static final TagKey<Block> GLASS_FENCES_REINFORCED = forgeBlockTag("glass_fences/reinforced");
        public static final TagKey<Block> GLASS_FENCES_GLOWING = forgeBlockTag("glass_fences/glowing");
        public static final TagKey<Block> GLASS_FENCES_SHIFTING = forgeBlockTag("glass_fences/shifting");
        public static final TagKey<Block> GLASS_FENCES_TINTED = forgeBlockTag("glass_fences/tinted");

        public static final TagKey<Block> GLASS_FENCE_GATES = forgeBlockTag("glass_fence_gates");
        public static final TagKey<Block> GLASS_FENCE_GATES_REINFORCED = forgeBlockTag("glass_fence_gates/reinforced");
        public static final TagKey<Block> GLASS_FENCE_GATES_GLOWING = forgeBlockTag("glass_fence_gates/glowing");
        public static final TagKey<Block> GLASS_FENCE_GATES_SHIFTING = forgeBlockTag("glass_fence_gates/shifting");
        public static final TagKey<Block> GLASS_FENCE_GATES_TINTED = forgeBlockTag("glass_fence_gates/tinted");

        public static final TagKey<Block> GLASS_BUTTONS = forgeBlockTag("glass_buttons");
        public static final TagKey<Block> GLASS_BUTTONS_REINFORCED = forgeBlockTag("glass_buttons/reinforced");
        public static final TagKey<Block> GLASS_BUTTONS_GLOWING = forgeBlockTag("glass_buttons/glowing");
        public static final TagKey<Block> GLASS_BUTTONS_SHIFTING = forgeBlockTag("glass_buttons/shifting");
        public static final TagKey<Block> GLASS_BUTTONS_TINTED = forgeBlockTag("glass_buttons/tinted");

        public static final TagKey<Block> GLASS_PRESSURE_PLATES = forgeBlockTag("glass_pressure_plates");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_REINFORCED = forgeBlockTag("glass_pressure_plates/reinforced");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_GLOWING = forgeBlockTag("glass_pressure_plates/glowing");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_SHIFTING = forgeBlockTag("glass_pressure_plates/shifting");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_TINTED = forgeBlockTag("glass_pressure_plates/tinted");

        public static final TagKey<Block> GLASS_DOORS = forgeBlockTag("glass_doors");
        public static final TagKey<Block> GLASS_DOORS_REINFORCED = forgeBlockTag("glass_doors/reinforced");
        public static final TagKey<Block> GLASS_DOORS_GLOWING = forgeBlockTag("glass_doors/glowing");
        public static final TagKey<Block> GLASS_DOORS_SHIFTING = forgeBlockTag("glass_doors/shifting");
        public static final TagKey<Block> GLASS_DOORS_TINTED = forgeBlockTag("glass_doors/tinted");

        public static final TagKey<Block> GLASS_TRAPDOORS = forgeBlockTag("glass_trapdoors");
        public static final TagKey<Block> GLASS_TRAPDOORS_REINFORCED = forgeBlockTag("glass_trapdoors/reinforced");
        public static final TagKey<Block> GLASS_TRAPDOORS_GLOWING = forgeBlockTag("glass_trapdoors/glowing");
        public static final TagKey<Block> GLASS_TRAPDOORS_SHIFTING = forgeBlockTag("glass_trapdoors/shifting");
        public static final TagKey<Block> GLASS_TRAPDOORS_TINTED = forgeBlockTag("glass_trapdoors/tinted");
    }

    @SuppressWarnings("unused")
    public static class Items {
        public static final TagKey<Item> GLASS_REINFORCED = forgeItemTag("glass/reinforced");
        public static final TagKey<Item> GLASS_GLOWING = forgeItemTag("glass/glowing");
        public static final TagKey<Item> GLASS_SHIFTING = forgeItemTag("glass/shifting");

        public static final TagKey<Item> GLASS_PANES_SILICA = forgeItemTag("glass_panes/silica");
        public static final TagKey<Item> GLASS_PANES_REINFORCED = forgeItemTag("glass_panes/reinforced");
        public static final TagKey<Item> GLASS_PANES_GLOWING = forgeItemTag("glass_panes/glowing");
        public static final TagKey<Item> GLASS_PANES_SHIFTING = forgeItemTag("glass_panes/shifting");
        public static final TagKey<Item> GLASS_PANES_TINTED = forgeItemTag("glass_panes/tinted");

        public static final TagKey<Item> GLASS_STAIRS = forgeItemTag("glass_stairs");
        public static final TagKey<Item> GLASS_STAIRS_REINFORCED = forgeItemTag("glass_stairs/reinforced");
        public static final TagKey<Item> GLASS_STAIRS_GLOWING = forgeItemTag("glass_stairs/glowing");
        public static final TagKey<Item> GLASS_STAIRS_SHIFTING = forgeItemTag("glass_stairs/shifting");
        public static final TagKey<Item> GLASS_STAIRS_TINTED = forgeItemTag("glass_stairs/tinted");

        public static final TagKey<Item> GLASS_SLABS = forgeItemTag("glass_slabs");
        public static final TagKey<Item> GLASS_SLABS_REINFORCED = forgeItemTag("glass_slabs/reinforced");
        public static final TagKey<Item> GLASS_SLABS_GLOWING = forgeItemTag("glass_slabs/glowing");
        public static final TagKey<Item> GLASS_SLABS_SHIFTING = forgeItemTag("glass_slabs/shifting");
        public static final TagKey<Item> GLASS_SLABS_TINTED = forgeItemTag("glass_slabs/tinted");

        public static final TagKey<Item> GLASS_WALLS = forgeItemTag("glass_walls");
        public static final TagKey<Item> GLASS_WALLS_REINFORCED = forgeItemTag("glass_walls/reinforced");
        public static final TagKey<Item> GLASS_WALLS_GLOWING = forgeItemTag("glass_walls/glowing");
        public static final TagKey<Item> GLASS_WALLS_SHIFTING = forgeItemTag("glass_walls/shifting");
        public static final TagKey<Item> GLASS_WALLS_TINTED = forgeItemTag("glass_walls/tinted");

        public static final TagKey<Item> GLASS_FENCES = forgeItemTag("glass_fences");
        public static final TagKey<Item> GLASS_FENCES_REINFORCED = forgeItemTag("glass_fences/reinforced");
        public static final TagKey<Item> GLASS_FENCES_GLOWING = forgeItemTag("glass_fences/glowing");
        public static final TagKey<Item> GLASS_FENCES_SHIFTING = forgeItemTag("glass_fences/shifting");
        public static final TagKey<Item> GLASS_FENCES_TINTED = forgeItemTag("glass_fences/tinted");

        public static final TagKey<Item> GLASS_FENCE_GATES = forgeItemTag("glass_fence_gates");
        public static final TagKey<Item> GLASS_FENCE_GATES_REINFORCED = forgeItemTag("glass_fence_gates/reinforced");
        public static final TagKey<Item> GLASS_FENCE_GATES_GLOWING = forgeItemTag("glass_fence_gates/glowing");
        public static final TagKey<Item> GLASS_FENCE_GATES_SHIFTING = forgeItemTag("glass_fence_gates/shifting");
        public static final TagKey<Item> GLASS_FENCE_GATES_TINTED = forgeItemTag("glass_fence_gates/tinted");

        public static final TagKey<Item> GLASS_BUTTONS = forgeItemTag("glass_buttons");
        public static final TagKey<Item> GLASS_BUTTONS_REINFORCED = forgeItemTag("glass_buttons/reinforced");
        public static final TagKey<Item> GLASS_BUTTONS_GLOWING = forgeItemTag("glass_buttons/glowing");
        public static final TagKey<Item> GLASS_BUTTONS_SHIFTING = forgeItemTag("glass_buttons/shifting");
        public static final TagKey<Item> GLASS_BUTTONS_TINTED = forgeItemTag("glass_buttons/tinted");

        public static final TagKey<Item> GLASS_PRESSURE_PLATES = forgeItemTag("glass_pressure_plates");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_REINFORCED = forgeItemTag("glass_pressure_plates/reinforced");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_GLOWING = forgeItemTag("glass_pressure_plates/glowing");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_SHIFTING = forgeItemTag("glass_pressure_plates/shifting");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_TINTED = forgeItemTag("glass_pressure_plates/tinted");

        public static final TagKey<Item> GLASS_DOORS = forgeItemTag("glass_doors");
        public static final TagKey<Item> GLASS_DOORS_REINFORCED = forgeItemTag("glass_doors/reinforced");
        public static final TagKey<Item> GLASS_DOORS_GLOWING = forgeItemTag("glass_doors/glowing");
        public static final TagKey<Item> GLASS_DOORS_SHIFTING = forgeItemTag("glass_doors/shifting");
        public static final TagKey<Item> GLASS_DOORS_TINTED = forgeItemTag("glass_doors/tinted");

        public static final TagKey<Item> GLASS_TRAPDOORS = forgeItemTag("glass_trapdoors");
        public static final TagKey<Item> GLASS_TRAPDOORS_REINFORCED = forgeItemTag("glass_trapdoors/reinforced");
        public static final TagKey<Item> GLASS_TRAPDOORS_GLOWING = forgeItemTag("glass_trapdoors/glowing");
        public static final TagKey<Item> GLASS_TRAPDOORS_SHIFTING = forgeItemTag("glass_trapdoors/shifting");
        public static final TagKey<Item> GLASS_TRAPDOORS_TINTED = forgeItemTag("glass_trapdoors/tinted");
    }

    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", path));
    }
}
