package com.github.warrentode.todevillagers.datagen.tags;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class BlockTagsGen extends BlockTagsProvider {
    public BlockTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerBlockMineables();
    }

    private void registerModTags() {
        tag(ModTags.Blocks.GLASS)
                .addTag(ModTags.Blocks.GLASS_COLORLESS)
                .addTag(ModTags.Blocks.GLASS_SILICA)
                .addTag(ModTags.Blocks.GLASS_TINTED)
                .addTag(ModTags.Blocks.STAINED_GLASS)
                .addTag(ModTags.Blocks.GLASS_INFUSED)
                .addTag(ModTags.Blocks.GLASS_REINFORCED)
                .addTag(ModTags.Blocks.GLASS_GLOWING)
                .addTag(ModTags.Blocks.GLASS_SHIFTING);
        tag(ModTags.Blocks.GLASS_COLORLESS)
                .add(ModBlocks.REDSTONE_INFUSED_GLASS.get())
                .add(ModBlocks.REINFORCED_GLASS.get())
                .add(ModBlocks.GLOWING_GLASS.get());
        tag(ModTags.Blocks.GLASS_SILICA)
                .add(ModBlocks.REDSTONE_INFUSED_GLASS.get())
                .add(ModBlocks.REINFORCED_GLASS.get())
                .add(ModBlocks.GLOWING_GLASS.get())
                .add(ModBlocks.SHIFTING_GLASS.get())
                .add(Blocks.TINTED_GLASS);
        tag(ModTags.Blocks.GLASS_TINTED)
                .add(Blocks.TINTED_GLASS);
        tag(ModTags.Blocks.STAINED_GLASS)
                .add(Blocks.WHITE_STAINED_GLASS)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS)
                .add(Blocks.GRAY_STAINED_GLASS)
                .add(Blocks.BLACK_STAINED_GLASS)
                .add(Blocks.BROWN_STAINED_GLASS)
                .add(Blocks.RED_STAINED_GLASS)
                .add(Blocks.ORANGE_STAINED_GLASS)
                .add(Blocks.YELLOW_STAINED_GLASS)
                .add(Blocks.LIME_STAINED_GLASS)
                .add(Blocks.GREEN_STAINED_GLASS)
                .add(Blocks.CYAN_STAINED_GLASS)
                .add(Blocks.BLUE_STAINED_GLASS)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS)
                .add(Blocks.PINK_STAINED_GLASS)
                .add(Blocks.MAGENTA_STAINED_GLASS)
                .add(Blocks.PURPLE_STAINED_GLASS);
        tag(ModTags.Blocks.GLASS_INFUSED)
                .add(ModBlocks.REDSTONE_INFUSED_GLASS.get());
        tag(ModTags.Blocks.GLASS_REINFORCED)
                .add(ModBlocks.REINFORCED_GLASS.get());
        tag(ModTags.Blocks.GLASS_GLOWING)
                .add(ModBlocks.GLOWING_GLASS.get());
        tag(ModTags.Blocks.GLASS_SHIFTING)
                .add(ModBlocks.SHIFTING_GLASS.get());
        tag(ModTags.Blocks.GLASS_PANES)
                .addTag(ModTags.Blocks.GLASS_PANES_COLORLESS)
                .addTag(ModTags.Blocks.GLASS_PANES_SILICA)
                .addTag(ModTags.Blocks.GLASS_PANES_TINTED)
                .addTag(Tags.Blocks.STAINED_GLASS_PANES)
                .addTag(ModTags.Blocks.GLASS_PANES_REINFORCED)
                .addTag(ModTags.Blocks.GLASS_PANES_GLOWING)
                .addTag(ModTags.Blocks.GLASS_PANES_SHIFTING);
        tag(ModTags.Blocks.GLASS_PANES_COLORLESS)
                .add(ModBlocks.REINFORCED_GLASS_PANE.get())
                .add(ModBlocks.GLOWING_GLASS_PANE.get());
        tag(ModTags.Blocks.GLASS_PANES_SILICA)
                .add(ModBlocks.REINFORCED_GLASS_PANE.get())
                .add(ModBlocks.GLOWING_GLASS_PANE.get())
                .add(ModBlocks.SHIFTING_GLASS_PANE.get())
                .add(ModBlocks.TINTED_GLASS_PANE.get());
        tag(ModTags.Blocks.GLASS_PANES_TINTED)
                .add(ModBlocks.TINTED_GLASS_PANE.get());
        tag(ModTags.Blocks.STAINED_GLASS_PANES)
                .add(Blocks.WHITE_STAINED_GLASS_PANE)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)
                .add(Blocks.GRAY_STAINED_GLASS_PANE)
                .add(Blocks.BLACK_STAINED_GLASS_PANE)
                .add(Blocks.BROWN_STAINED_GLASS_PANE)
                .add(Blocks.RED_STAINED_GLASS_PANE)
                .add(Blocks.ORANGE_STAINED_GLASS_PANE)
                .add(Blocks.YELLOW_STAINED_GLASS_PANE)
                .add(Blocks.LIME_STAINED_GLASS_PANE)
                .add(Blocks.GREEN_STAINED_GLASS_PANE)
                .add(Blocks.CYAN_STAINED_GLASS_PANE)
                .add(Blocks.BLUE_STAINED_GLASS_PANE)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)
                .add(Blocks.PINK_STAINED_GLASS_PANE)
                .add(Blocks.MAGENTA_STAINED_GLASS_PANE)
                .add(Blocks.PURPLE_STAINED_GLASS_PANE);
        tag(ModTags.Blocks.GLASS_PANES_REINFORCED)
                .add(ModBlocks.REINFORCED_GLASS_PANE.get());
        tag(ModTags.Blocks.GLASS_PANES_GLOWING)
                .add(ModBlocks.GLOWING_GLASS_PANE.get());
        tag(ModTags.Blocks.GLASS_PANES_SHIFTING)
                .add(ModBlocks.SHIFTING_GLASS_PANE.get());
        tag(ModTags.Blocks.GLASS_BUTTONS)
                .add(ModBlocks.REINFORCED_GLASS_BUTTON.get())
                .add(ModBlocks.GLOWING_GLASS_BUTTON.get())
                .add(ModBlocks.SHIFTING_GLASS_BUTTON.get())
                .add(ModBlocks.TINTED_GLASS_BUTTON.get());
        tag(ModTags.Blocks.GLASS_DOORS)
                .add(ModBlocks.REINFORCED_GLASS_DOOR.get())
                .add(ModBlocks.GLOWING_GLASS_DOOR.get())
                .add(ModBlocks.SHIFTING_GLASS_DOOR.get())
                .add(ModBlocks.TINTED_GLASS_DOOR.get());
        tag(ModTags.Blocks.GLASS_FENCE_GATES)
                .add(ModBlocks.REINFORCED_GLASS_FENCE_GATE.get())
                .add(ModBlocks.GLOWING_GLASS_FENCE_GATE.get())
                .add(ModBlocks.SHIFTING_GLASS_FENCE_GATE.get())
                .add(ModBlocks.TINTED_GLASS_FENCE_GATE.get());
        tag(ModTags.Blocks.GLASS_FENCES)
                .add(ModBlocks.REINFORCED_GLASS_FENCE.get())
                .add(ModBlocks.GLOWING_GLASS_FENCE.get())
                .add(ModBlocks.SHIFTING_GLASS_FENCE.get())
                .add(ModBlocks.TINTED_GLASS_FENCE.get());
        tag(ModTags.Blocks.GLASS_PRESSURE_PLATES)
                .add(ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get())
                .add(ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get())
                .add(ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get())
                .add(ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get());
        tag(ModTags.Blocks.GLASS_SLABS)
                .add(ModBlocks.REINFORCED_GLASS_SLAB.get())
                .add(ModBlocks.GLOWING_GLASS_SLAB.get())
                .add(ModBlocks.SHIFTING_GLASS_SLAB.get())
                .add(ModBlocks.TINTED_GLASS_SLAB.get());
        tag(ModTags.Blocks.GLASS_STAIRS)
                .add(ModBlocks.REINFORCED_GLASS_STAIRS.get())
                .add(ModBlocks.GLOWING_GLASS_STAIRS.get())
                .add(ModBlocks.SHIFTING_GLASS_STAIRS.get())
                .add(ModBlocks.TINTED_GLASS_STAIRS.get());
        tag(ModTags.Blocks.GLASS_TRAPDOORS)
                .add(ModBlocks.REINFORCED_GLASS_TRAPDOOR.get())
                .add(ModBlocks.GLOWING_GLASS_TRAPDOOR.get())
                .add(ModBlocks.SHIFTING_GLASS_TRAPDOOR.get())
                .add(ModBlocks.TINTED_GLASS_TRAPDOOR.get());
        tag(ModTags.Blocks.GLASS_WALLS)
                .add(ModBlocks.REINFORCED_GLASS_WALL.get())
                .add(ModBlocks.GLOWING_GLASS_WALL.get())
                .add(ModBlocks.SHIFTING_GLASS_WALL.get())
                .add(ModBlocks.TINTED_GLASS_WALL.get());

        tag(ModTags.Blocks.SAND)
                .addTag(ModTags.Blocks.SAND_COLORLESS)
                .addTag(ModTags.Blocks.SAND_RED)
                .addTag(ModTags.Blocks.SAND_ORANGE)
                .addTag(ModTags.Blocks.SAND_BLACK)
                .addTag(ModTags.Blocks.SAND_WHITE);
        tag(ModTags.Blocks.SAND_COLORLESS)
                .add(Blocks.SAND)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:origin_sand")));
        tag(ModTags.Blocks.SAND_RED)
                .add(Blocks.RED_SAND);
        tag(ModTags.Blocks.SAND_ORANGE)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:orange_sand")));
        tag(ModTags.Blocks.SAND_BLACK)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:black_sand")));
        tag(ModTags.Blocks.SAND_WHITE)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:white_sand")));
    }

    private void registerMinecraftTags() {
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GLASS_KILN_BLOCK.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.TINTED_GLASS_WALL.get())
                .add(ModBlocks.SHIFTING_GLASS_WALL.get())
                .add(ModBlocks.GLOWING_GLASS_WALL.get())
                .add(ModBlocks.REINFORCED_GLASS_WALL.get());
        tag(BlockTags.FENCES)
                .add(ModBlocks.TINTED_GLASS_FENCE.get())
                .add(ModBlocks.SHIFTING_GLASS_FENCE.get())
                .add(ModBlocks.GLOWING_GLASS_FENCE.get())
                .add(ModBlocks.REINFORCED_GLASS_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.TINTED_GLASS_FENCE_GATE.get())
                .add(ModBlocks.SHIFTING_GLASS_FENCE_GATE.get())
                .add(ModBlocks.GLOWING_GLASS_FENCE_GATE.get())
                .add(ModBlocks.REINFORCED_GLASS_FENCE_GATE.get());
    }

    protected void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GLASS_KILN_BLOCK.get());
    }
}