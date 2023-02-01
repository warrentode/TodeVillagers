package net.warrentode.todevillagers.util.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModTags {
    @SuppressWarnings("unused")
    public static class Blocks {
        public static final TagKey<Block> GLASS_COLORLESS = modBlockTag("glass/colorless");
        public static final TagKey<Block> GLASS_SILICA = modBlockTag("glass/silica");
        public static final TagKey<Block> GLASS_TINTED = modBlockTag("glass/tinted");
        public static final TagKey<Block> GLASS_REINFORCED = modBlockTag("glass/reinforced");
        public static final TagKey<Block> GLASS_GLOWING = modBlockTag("glass/glowing");
        public static final TagKey<Block> GLASS_SHIFTING = modBlockTag("glass/shifting");

        public static final TagKey<Block> GLASS_PANES_SILICA = modBlockTag("glass_panes/silica");
        public static final TagKey<Block> GLASS_PANES_REINFORCED = modBlockTag("glass_panes/reinforced");
        public static final TagKey<Block> GLASS_PANES_GLOWING = modBlockTag("glass_panes/glowing");
        public static final TagKey<Block> GLASS_PANES_SHIFTING = modBlockTag("glass_panes/shifting");
        public static final TagKey<Block> GLASS_PANES_TINTED = modBlockTag("glass_panes/tinted");

        public static final TagKey<Block> GLASS_STAIRS = modBlockTag("glass_stairs");
        public static final TagKey<Block> GLASS_STAIRS_REINFORCED = modBlockTag("glass_stairs/reinforced");
        public static final TagKey<Block> GLASS_STAIRS_GLOWING = modBlockTag("glass_stairs/glowing");
        public static final TagKey<Block> GLASS_STAIRS_SHIFTING = modBlockTag("glass_stairs/shifting");
        public static final TagKey<Block> GLASS_STAIRS_TINTED = modBlockTag("glass_stairs/tinted");

        public static final TagKey<Block> GLASS_SLABS = modBlockTag("glass_slabs");
        public static final TagKey<Block> GLASS_SLABS_REINFORCED = modBlockTag("glass_slabs/reinforced");
        public static final TagKey<Block> GLASS_SLABS_GLOWING = modBlockTag("glass_slabs/glowing");
        public static final TagKey<Block> GLASS_SLABS_SHIFTING = modBlockTag("glass_slabs/shifting");
        public static final TagKey<Block> GLASS_SLABS_TINTED = modBlockTag("glass_slabs/tinted");

        public static final TagKey<Block> GLASS_WALLS = modBlockTag("glass_walls");
        public static final TagKey<Block> GLASS_WALLS_REINFORCED = modBlockTag("glass_walls/reinforced");
        public static final TagKey<Block> GLASS_WALLS_GLOWING = modBlockTag("glass_walls/glowing");
        public static final TagKey<Block> GLASS_WALLS_SHIFTING = modBlockTag("glass_walls/shifting");
        public static final TagKey<Block> GLASS_WALLS_TINTED = modBlockTag("glass_walls/tinted");

        public static final TagKey<Block> GLASS_FENCES = modBlockTag("glass_fences");
        public static final TagKey<Block> GLASS_FENCES_REINFORCED = modBlockTag("glass_fences/reinforced");
        public static final TagKey<Block> GLASS_FENCES_GLOWING = modBlockTag("glass_fences/glowing");
        public static final TagKey<Block> GLASS_FENCES_SHIFTING = modBlockTag("glass_fences/shifting");
        public static final TagKey<Block> GLASS_FENCES_TINTED = modBlockTag("glass_fences/tinted");

        public static final TagKey<Block> GLASS_FENCE_GATES = modBlockTag("glass_fence_gates");
        public static final TagKey<Block> GLASS_FENCE_GATES_REINFORCED = modBlockTag("glass_fence_gates/reinforced");
        public static final TagKey<Block> GLASS_FENCE_GATES_GLOWING = modBlockTag("glass_fence_gates/glowing");
        public static final TagKey<Block> GLASS_FENCE_GATES_SHIFTING = modBlockTag("glass_fence_gates/shifting");
        public static final TagKey<Block> GLASS_FENCE_GATES_TINTED = modBlockTag("glass_fence_gates/tinted");

        public static final TagKey<Block> GLASS_BUTTONS = modBlockTag("glass_buttons");
        public static final TagKey<Block> GLASS_BUTTONS_REINFORCED = modBlockTag("glass_buttons/reinforced");
        public static final TagKey<Block> GLASS_BUTTONS_GLOWING = modBlockTag("glass_buttons/glowing");
        public static final TagKey<Block> GLASS_BUTTONS_SHIFTING = modBlockTag("glass_buttons/shifting");
        public static final TagKey<Block> GLASS_BUTTONS_TINTED = modBlockTag("glass_buttons/tinted");

        public static final TagKey<Block> GLASS_PRESSURE_PLATES = modBlockTag("glass_pressure_plates");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_REINFORCED = modBlockTag("glass_pressure_plates/reinforced");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_GLOWING = modBlockTag("glass_pressure_plates/glowing");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_SHIFTING = modBlockTag("glass_pressure_plates/shifting");
        public static final TagKey<Block> GLASS_PRESSURE_PLATES_TINTED = modBlockTag("glass_pressure_plates/tinted");

        public static final TagKey<Block> GLASS_DOORS = modBlockTag("glass_doors");
        public static final TagKey<Block> GLASS_DOORS_REINFORCED = modBlockTag("glass_doors/reinforced");
        public static final TagKey<Block> GLASS_DOORS_GLOWING = modBlockTag("glass_doors/glowing");
        public static final TagKey<Block> GLASS_DOORS_SHIFTING = modBlockTag("glass_doors/shifting");
        public static final TagKey<Block> GLASS_DOORS_TINTED = modBlockTag("glass_doors/tinted");

        public static final TagKey<Block> GLASS_TRAPDOORS = modBlockTag("glass_trapdoors");
        public static final TagKey<Block> GLASS_TRAPDOORS_REINFORCED = modBlockTag("glass_trapdoors/reinforced");
        public static final TagKey<Block> GLASS_TRAPDOORS_GLOWING = modBlockTag("glass_trapdoors/glowing");
        public static final TagKey<Block> GLASS_TRAPDOORS_SHIFTING = modBlockTag("glass_trapdoors/shifting");
        public static final TagKey<Block> GLASS_TRAPDOORS_TINTED = modBlockTag("glass_trapdoors/tinted");

        public static final TagKey<Block> SAND_COLORLESS = modBlockTag("sand/colorless");
        public static final TagKey<Block> SAND_RED = modBlockTag("sand/red");
    }

    @SuppressWarnings("unused")
    public static class Items {
        public static final TagKey<Item> GLASS_COLORLESS = modItemTag("glass/colorless");
        public static final TagKey<Item> GLASS_SILICA = modItemTag("glass/silica");
        public static final TagKey<Item> GLASS_TINTED = modItemTag("glass/tinted");
        public static final TagKey<Item> GLASS_REINFORCED = modItemTag("glass/reinforced");
        public static final TagKey<Item> GLASS_GLOWING = modItemTag("glass/glowing");
        public static final TagKey<Item> GLASS_SHIFTING = modItemTag("glass/shifting");

        public static final TagKey<Item> GLASS_PANES_SILICA = modItemTag("glass_panes/silica");
        public static final TagKey<Item> GLASS_PANES_REINFORCED = modItemTag("glass_panes/reinforced");
        public static final TagKey<Item> GLASS_PANES_GLOWING = modItemTag("glass_panes/glowing");
        public static final TagKey<Item> GLASS_PANES_SHIFTING = modItemTag("glass_panes/shifting");
        public static final TagKey<Item> GLASS_PANES_TINTED = modItemTag("glass_panes/tinted");

        public static final TagKey<Item> GLASS_STAIRS = modItemTag("glass_stairs");
        public static final TagKey<Item> GLASS_STAIRS_REINFORCED = modItemTag("glass_stairs/reinforced");
        public static final TagKey<Item> GLASS_STAIRS_GLOWING = modItemTag("glass_stairs/glowing");
        public static final TagKey<Item> GLASS_STAIRS_SHIFTING = modItemTag("glass_stairs/shifting");
        public static final TagKey<Item> GLASS_STAIRS_TINTED = modItemTag("glass_stairs/tinted");

        public static final TagKey<Item> GLASS_SLABS = modItemTag("glass_slabs");
        public static final TagKey<Item> GLASS_SLABS_REINFORCED = modItemTag("glass_slabs/reinforced");
        public static final TagKey<Item> GLASS_SLABS_GLOWING = modItemTag("glass_slabs/glowing");
        public static final TagKey<Item> GLASS_SLABS_SHIFTING = modItemTag("glass_slabs/shifting");
        public static final TagKey<Item> GLASS_SLABS_TINTED = modItemTag("glass_slabs/tinted");

        public static final TagKey<Item> GLASS_WALLS = modItemTag("glass_walls");
        public static final TagKey<Item> GLASS_WALLS_REINFORCED = modItemTag("glass_walls/reinforced");
        public static final TagKey<Item> GLASS_WALLS_GLOWING = modItemTag("glass_walls/glowing");
        public static final TagKey<Item> GLASS_WALLS_SHIFTING = modItemTag("glass_walls/shifting");
        public static final TagKey<Item> GLASS_WALLS_TINTED = modItemTag("glass_walls/tinted");

        public static final TagKey<Item> GLASS_FENCES = modItemTag("glass_fences");
        public static final TagKey<Item> GLASS_FENCES_REINFORCED = modItemTag("glass_fences/reinforced");
        public static final TagKey<Item> GLASS_FENCES_GLOWING = modItemTag("glass_fences/glowing");
        public static final TagKey<Item> GLASS_FENCES_SHIFTING = modItemTag("glass_fences/shifting");
        public static final TagKey<Item> GLASS_FENCES_TINTED = modItemTag("glass_fences/tinted");

        public static final TagKey<Item> GLASS_FENCE_GATES = modItemTag("glass_fence_gates");
        public static final TagKey<Item> GLASS_FENCE_GATES_REINFORCED = modItemTag("glass_fence_gates/reinforced");
        public static final TagKey<Item> GLASS_FENCE_GATES_GLOWING = modItemTag("glass_fence_gates/glowing");
        public static final TagKey<Item> GLASS_FENCE_GATES_SHIFTING = modItemTag("glass_fence_gates/shifting");
        public static final TagKey<Item> GLASS_FENCE_GATES_TINTED = modItemTag("glass_fence_gates/tinted");

        public static final TagKey<Item> GLASS_BUTTONS = modItemTag("glass_buttons");
        public static final TagKey<Item> GLASS_BUTTONS_REINFORCED = modItemTag("glass_buttons/reinforced");
        public static final TagKey<Item> GLASS_BUTTONS_GLOWING = modItemTag("glass_buttons/glowing");
        public static final TagKey<Item> GLASS_BUTTONS_SHIFTING = modItemTag("glass_buttons/shifting");
        public static final TagKey<Item> GLASS_BUTTONS_TINTED = modItemTag("glass_buttons/tinted");

        public static final TagKey<Item> GLASS_PRESSURE_PLATES = modItemTag("glass_pressure_plates");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_REINFORCED = modItemTag("glass_pressure_plates/reinforced");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_GLOWING = modItemTag("glass_pressure_plates/glowing");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_SHIFTING = modItemTag("glass_pressure_plates/shifting");
        public static final TagKey<Item> GLASS_PRESSURE_PLATES_TINTED = modItemTag("glass_pressure_plates/tinted");

        public static final TagKey<Item> GLASS_DOORS = modItemTag("glass_doors");
        public static final TagKey<Item> GLASS_DOORS_REINFORCED = modItemTag("glass_doors/reinforced");
        public static final TagKey<Item> GLASS_DOORS_GLOWING = modItemTag("glass_doors/glowing");
        public static final TagKey<Item> GLASS_DOORS_SHIFTING = modItemTag("glass_doors/shifting");
        public static final TagKey<Item> GLASS_DOORS_TINTED = modItemTag("glass_doors/tinted");

        public static final TagKey<Item> GLASS_TRAPDOORS = modItemTag("glass_trapdoors");
        public static final TagKey<Item> GLASS_TRAPDOORS_REINFORCED = modItemTag("glass_trapdoors/reinforced");
        public static final TagKey<Item> GLASS_TRAPDOORS_GLOWING = modItemTag("glass_trapdoors/glowing");
        public static final TagKey<Item> GLASS_TRAPDOORS_SHIFTING = modItemTag("glass_trapdoors/shifting");
        public static final TagKey<Item> GLASS_TRAPDOORS_TINTED = modItemTag("glass_trapdoors/tinted");

        public static final TagKey<Item> SAND_COLORLESS = modItemTag("sand/colorless");
        public static final TagKey<Item> SAND_RED = modItemTag("sand/red");
    }


    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(MODID, path));
    }
    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, path));
    }
}