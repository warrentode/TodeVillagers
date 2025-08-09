package com.github.warrentode.todevillagers.datagen.tags;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ItemTagsGen extends ItemTagsProvider {
    public ItemTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        this.registerModTags();
    }

    private void registerModTags() {
        tag(ModTags.Items.GLASSBLOWER_TOOLS)
                .add(ModItems.MARVER.get())
                .add(ModItems.GLASSBLOWING_PIPE.get())
                .add(ModItems.GLASSBLOWER_SHEARS.get());
        tag(ModTags.Items.GLASS)
                .addTag(ModTags.Items.GLASS_COLORLESS)
                .addTag(ModTags.Items.GLASS_SILICA)
                .addTag(ModTags.Items.GLASS_TINTED)
                .addTag(ModTags.Items.STAINED_GLASS)
                .addTag(ModTags.Items.GLASS_INFUSED)
                .addTag(ModTags.Items.GLASS_REINFORCED)
                .addTag(ModTags.Items.GLASS_GLOWING)
                .addTag(ModTags.Items.GLASS_SHIFTING);
        tag(Tags.Items.GLASS_COLORLESS)
                .add(ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem())
                .add(ModBlocks.REINFORCED_GLASS.get().asItem())
                .add(ModBlocks.GLOWING_GLASS.get().asItem());
        tag(Tags.Items.GLASS_SILICA)
                .add(ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem())
                .add(ModBlocks.REINFORCED_GLASS.get().asItem())
                .add(ModBlocks.GLOWING_GLASS.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS.get().asItem())
                .add(Blocks.TINTED_GLASS.asItem());
        tag(ModTags.Items.GLASS_TINTED)
                .add(Blocks.TINTED_GLASS.asItem());
        tag(ModTags.Items.GLASS_INFUSED)
                .add(ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem());
        tag(ModTags.Items.GLASS_REINFORCED)
                .add(ModBlocks.REINFORCED_GLASS.get().asItem());
        tag(ModTags.Items.GLASS_GLOWING)
                .add(ModBlocks.GLOWING_GLASS.get().asItem());
        tag(ModTags.Items.GLASS_SHIFTING)
                .add(ModBlocks.SHIFTING_GLASS.get().asItem());
        tag(ModTags.Items.GLASS_PANES)
                .addTag(ModTags.Items.GLASS_PANES_COLORLESS)
                .addTag(ModTags.Items.GLASS_PANES_SILICA)
                .addTag(ModTags.Items.GLASS_PANES_TINTED)
                .addTag(ModTags.Items.STAINED_GLASS_PANES)
                .addTag(ModTags.Items.GLASS_PANES_REINFORCED)
                .addTag(ModTags.Items.GLASS_PANES_GLOWING)
                .addTag(ModTags.Items.GLASS_PANES_SHIFTING);
        tag(ModTags.Items.GLASS_PANES_COLORLESS)
                .add(ModBlocks.REINFORCED_GLASS_PANE.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_PANE.get().asItem());
        tag(ModTags.Items.GLASS_PANES_SILICA)
                .add(ModBlocks.REINFORCED_GLASS_PANE.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_PANE.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_PANE.get().asItem())
                .add(ModBlocks.TINTED_GLASS_PANE.get().asItem());
        tag(ModTags.Items.GLASS_PANES_TINTED)
                .add(ModBlocks.TINTED_GLASS_PANE.get().asItem());
        tag(ModTags.Items.GLASS_PANES_REINFORCED)
                .add(ModBlocks.REINFORCED_GLASS_PANE.get().asItem());
        tag(ModTags.Items.GLASS_PANES_GLOWING)
                .add(ModBlocks.GLOWING_GLASS_PANE.get().asItem());
        tag(ModTags.Items.GLASS_PANES_SHIFTING)
                .add(ModBlocks.SHIFTING_GLASS_PANE.get().asItem());
        tag(ModTags.Items.GLASS_BUTTONS)
                .add(ModBlocks.REINFORCED_GLASS_BUTTON.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_BUTTON.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_BUTTON.get().asItem())
                .add(ModBlocks.TINTED_GLASS_BUTTON.get().asItem());
        tag(ModTags.Items.GLASS_DOORS)
                .add(ModBlocks.REINFORCED_GLASS_DOOR.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_DOOR.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_DOOR.get().asItem())
                .add(ModBlocks.TINTED_GLASS_DOOR.get().asItem());
        tag(ModTags.Items.GLASS_FENCE_GATES)
                .add(ModBlocks.REINFORCED_GLASS_FENCE_GATE.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_FENCE_GATE.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_FENCE_GATE.get().asItem())
                .add(ModBlocks.TINTED_GLASS_FENCE_GATE.get().asItem());
        tag(ModTags.Items.GLASS_FENCES)
                .add(ModBlocks.REINFORCED_GLASS_FENCE.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_FENCE.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_FENCE.get().asItem())
                .add(ModBlocks.TINTED_GLASS_FENCE.get().asItem());
        tag(ModTags.Items.GLASS_PRESSURE_PLATES)
                .add(ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get().asItem())
                .add(ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get().asItem());
        tag(ModTags.Items.GLASS_SLABS)
                .add(ModBlocks.REINFORCED_GLASS_SLAB.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_SLAB.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_SLAB.get().asItem())
                .add(ModBlocks.TINTED_GLASS_SLAB.get().asItem());
        tag(ModTags.Items.GLASS_STAIRS)
                .add(ModBlocks.REINFORCED_GLASS_STAIRS.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_STAIRS.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_STAIRS.get().asItem())
                .add(ModBlocks.TINTED_GLASS_STAIRS.get().asItem());
        tag(ModTags.Items.GLASS_TRAPDOORS)
                .add(ModBlocks.REINFORCED_GLASS_TRAPDOOR.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_TRAPDOOR.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_TRAPDOOR.get().asItem())
                .add(ModBlocks.TINTED_GLASS_TRAPDOOR.get().asItem());
        tag(ModTags.Items.GLASS_WALLS)
                .add(ModBlocks.REINFORCED_GLASS_WALL.get().asItem())
                .add(ModBlocks.GLOWING_GLASS_WALL.get().asItem())
                .add(ModBlocks.SHIFTING_GLASS_WALL.get().asItem())
                .add(ModBlocks.TINTED_GLASS_WALL.get().asItem());

        tag(ModTags.Items.SAND)
                .addTag(ModTags.Items.SAND_COLORLESS)
                .addTag(ModTags.Items.SAND_RED)
                .addTag(ModTags.Items.SAND_ORANGE)
                .addTag(ModTags.Items.SAND_BLACK)
                .addTag(ModTags.Items.SAND_WHITE);
        tag(ModTags.Items.SAND_COLORLESS)
                .add(Items.SAND)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:origin_sand")));
        tag(ModTags.Items.SAND_RED)
                .add(Items.RED_SAND);
        tag(ModTags.Items.SAND_ORANGE)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:orange_sand")));
        tag(ModTags.Items.SAND_BLACK)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:black_sand")));
        tag(ModTags.Items.SAND_WHITE)
                .addOptional(Objects.requireNonNull(ResourceLocation.tryParse("biomesoplenty:white_sand")));
    }
}