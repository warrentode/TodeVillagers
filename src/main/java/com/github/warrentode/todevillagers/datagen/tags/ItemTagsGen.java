package com.github.warrentode.todevillagers.datagen.tags;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
    public ItemTagsGen(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        this.registerModTags();
    }

    private void registerModTags() {
        tag(ModTags.Items.COOKIES)
                .add(Items.COOKIE);
        tag(ModTags.Items.CAKES)
                .add(Items.CAKE);
        tag(ModTags.Items.PIES)
                .add(Items.PUMPKIN_PIE);
        tag(ModTags.Items.JAR_ITEMS)
                .add(ModItems.CERAMIC_CHIP.get())
                .add(Items.HEART_OF_THE_SEA)
                .add(Items.ENDER_PEARL)
                .add(Items.ENDER_EYE)
                .add(Items.DRAGON_BREATH)
                .add(Items.LINGERING_POTION)
                .add(Items.SPLASH_POTION)
                .add(Items.POTION)
                .add(Items.EXPERIENCE_BOTTLE)
                .add(Items.HONEY_BOTTLE)
                .add(Items.GLASS_BOTTLE)
                .add(Items.BOWL)
                .add(Items.SUGAR)
                .addTag(Tags.Items.STRING)
                .addTag(Tags.Items.DYES)
                .addTag(Tags.Items.SLIMEBALLS)
                .addTag(Tags.Items.SEEDS)
                .addTag(Tags.Items.RODS)
                .addTag(Tags.Items.RAW_MATERIALS)
                .addTag(Tags.Items.NETHER_STARS)
                .addTag(Tags.Items.MUSHROOMS)
                .addTag(Tags.Items.GUNPOWDER)
                .addTag(Tags.Items.EGGS)
                .addTag(Tags.Items.BONES)
                .addTag(Tags.Items.GEMS)
                .addTag(Tags.Items.NUGGETS)
                .addTag(Tags.Items.DUSTS)
                .addTag(Tags.Items.DYES)
                .addTag(ItemTags.MUSIC_DISCS)
                .addOptionalTag(Objects.requireNonNull(ResourceLocation.tryParse("todecoins:tip_jar_tems")));
        tag(ModTags.Items.VASE_PLANTS)
                .add(Items.BAMBOO)
                .add(Blocks.DEAD_BUSH.asItem())
                .add(Blocks.SWEET_BERRY_BUSH.asItem())
                .add(Items.CRIMSON_FUNGUS)
                .add(Items.WARPED_FUNGUS)
                .add(Items.RED_MUSHROOM)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.LARGE_FERN)
                .add(Items.FERN)
                .addTag(ItemTags.SAPLINGS)
                .addTag(ItemTags.FLOWERS);
        tag(ModTags.Items.BUCKET_REMAINDERS)
                .add(Items.TROPICAL_FISH_BUCKET)
                .add(Items.SALMON_BUCKET)
                .add(Items.PUFFERFISH_BUCKET)
                .add(Items.COD_BUCKET)
                .add(Items.AXOLOTL_BUCKET)
                .add(Items.POWDER_SNOW_BUCKET)
                .add(Items.WATER_BUCKET);
        tag(ModTags.Items.MATCHING_ITEM_REMAINDERS)
                .addTag(ModTags.Items.TOOLS_CHISELS)
                .addTag(ModTags.Items.TOOLS_KNIVES)
                .addTag(ModTags.Items.GLASSBLOWER_TOOLS);
        tag(ModTags.Items.TOOLS_KNIVES)
                .addTag(ModTags.Items.STONE_TIER_KNIVES);
        tag(ModTags.Items.STONE_TIER_KNIVES)
                .add(ModItems.KNIFE_CERAMIC.get());
        tag(ModTags.Items.TOOLS_CHISELS)
                .addTag(ModTags.Items.IRON_TIER_CHISELS);
        tag(ModTags.Items.IRON_TIER_CHISELS)
                .add(ModItems.CHISEL_IRON.get());
        tag(ModTags.Items.BOTTLE_REMAINDERS)
                .add(Items.EXPERIENCE_BOTTLE)
                .add(Items.LINGERING_POTION)
                .add(Items.SPLASH_POTION)
                .add(Items.POTION);
        tag(ModTags.Items.BOWL_REMAINDERS)
                .addTag(ModTags.Items.SOUPS);
        tag(ModTags.Items.SOUPS)
                .add(Items.SUSPICIOUS_STEW)
                .add(Items.BEETROOT_SOUP)
                .add(Items.MUSHROOM_STEW)
                .add(Items.RABBIT_STEW);
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