package com.github.warrentode.todevillagers.datagen.recipes;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class StonecutterRecipesGen extends RecipeProvider implements IConditionBuilder {
    public StonecutterRecipesGen(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        createCrushedGlassRecipes(consumer);
        createGlassCuttingRecipes(consumer);
        createCeramicCuttingRecipes(consumer);
    }

    private static void createCrushedGlassRecipes(Consumer<FinishedRecipe> consumer) {
        List<Block> glassItems = ForgeRegistries.BLOCKS.getValues().stream()
                .filter(item -> item.getDescriptionId().contains("glass"))
                .filter(item -> !item.getDescriptionId().contains("kiln")).toList();
        glassItems.forEach(item ->
                SingleItemRecipeBuilder.stonecutting(Ingredient.of(item), RecipeCategory.MISC, ModItems.CRUSHED_GLASS.get(), 1)
                        .unlockedBy("has_" + getItemName(item), has(item))
                        .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/" +
                                getConversionRecipeName(ModItems.CRUSHED_GLASS.get(), item))));
    }
    private static void createGlassCuttingRecipes(Consumer<FinishedRecipe> consumer) {
        // glass buttons
        sixGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_BUTTON.get().asItem());
        sixGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_BUTTON.get().asItem());
        sixGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_BUTTON.get().asItem());
        sixGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_BUTTON.get().asItem());
        // glass doors
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_DOOR.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_DOOR.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_DOOR.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_DOOR.get().asItem());
        // glass trapdoors
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_TRAPDOOR.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_TRAPDOOR.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_TRAPDOOR.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_TRAPDOOR.get().asItem());
        // glass fences
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_FENCE.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_FENCE.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_FENCE.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_FENCE.get().asItem());
        // glass fence gates
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_FENCE_GATE.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_FENCE_GATE.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_FENCE_GATE.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_FENCE_GATE.get().asItem());
        // glass pressure plates
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get().asItem());
        // glass stairs
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_STAIRS.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_STAIRS.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_STAIRS.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_STAIRS.get().asItem());
        // glass walls
        oneGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_WALL.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_WALL.get().asItem());
        oneGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_WALL.get().asItem());
        oneGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_WALL.get().asItem());
        // glass panes
        threeGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_PANE.get().asItem());
        threeGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_PANE.get().asItem());
        threeGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_PANE.get().asItem());
        threeGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_PANE.get().asItem());
        // glass slabs
        twoGlassBlockResultTemplate(consumer, ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.GLOWING_GLASS_SLAB.get().asItem());
        twoGlassBlockResultTemplate(consumer, ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS_SLAB.get().asItem());
        twoGlassBlockResultTemplate(consumer, ModBlocks.SHIFTING_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS_SLAB.get().asItem());
        twoGlassBlockResultTemplate(consumer, Items.TINTED_GLASS, ModBlocks.TINTED_GLASS_SLAB.get().asItem());
    }

    private static void createCeramicCuttingRecipes(Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.BRICKS), RecipeCategory.DECORATIONS, ModItems.CERAMIC_CHIP.get(), 16)
                .unlockedBy("has_" + getItemName(Items.BRICKS), has(Items.BRICKS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/ceramic/" + getItemName(ModItems.CERAMIC_CHIP.get())));
        // plate recipes with stonecutter
        plateRecipeTemplate(consumer, ModBlocks.PLATE_TERRACOTTA.get().asItem(), Items.TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_WHITE.get().asItem(), Items.WHITE_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_ORANGE.get().asItem(), Items.ORANGE_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_MAGENTA.get().asItem(), Items.MAGENTA_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_LIGHT_BLUE.get().asItem(), Items.LIGHT_BLUE_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_YELLOW.get().asItem(), Items.YELLOW_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_LIME.get().asItem(), Items.LIME_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_PINK.get().asItem(), Items.PINK_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GRAY.get().asItem(), Items.GRAY_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_LIGHT_GRAY.get().asItem(), Items.LIGHT_GRAY_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_CYAN.get().asItem(), Items.CYAN_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_PURPLE.get().asItem(), Items.PURPLE_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_BLUE.get().asItem(), Items.BLUE_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_BROWN.get().asItem(), Items.BROWN_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GREEN.get().asItem(), Items.GREEN_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_RED.get().asItem(), Items.RED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_BLACK.get().asItem(), Items.BLACK_TERRACOTTA);
        // glazed plate recipes with stonecutter
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_WHITE.get().asItem(), Items.WHITE_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_ORANGE.get().asItem(), Items.ORANGE_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_MAGENTA.get().asItem(), Items.MAGENTA_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_LIGHT_BLUE.get().asItem(), Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_YELLOW.get().asItem(), Items.YELLOW_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_LIME.get().asItem(), Items.LIME_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_PINK.get().asItem(), Items.PINK_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_GRAY.get().asItem(), Items.GRAY_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_LIGHT_GRAY.get().asItem(), Items.LIGHT_GRAY_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_CYAN.get().asItem(), Items.CYAN_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_PURPLE.get().asItem(), Items.PURPLE_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_BLUE.get().asItem(), Items.BLUE_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_BROWN.get().asItem(), Items.BROWN_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_GREEN.get().asItem(), Items.GREEN_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_RED.get().asItem(), Items.RED_GLAZED_TERRACOTTA);
        plateRecipeTemplate(consumer, ModBlocks.PLATE_GLAZED_BLACK.get().asItem(), Items.BLACK_GLAZED_TERRACOTTA);
    }

    private static void plateRecipeTemplate(Consumer<FinishedRecipe> consumer, @NotNull Item result, Item ingredient) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.DECORATIONS, result, 4)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/ceramic/plates/" + getItemName(result)));
    }

    private static void sixGlassBlockResultTemplate(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.BUILDING_BLOCKS, result, 6)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/" + getItemName(result)));

    }

    private static void threeGlassBlockResultTemplate(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.BUILDING_BLOCKS, result, 3)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/" + getItemName(result)));
    }

    private static void twoGlassBlockResultTemplate(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.BUILDING_BLOCKS, result, 2)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/" + getItemName(result)));
    }

    private static void oneGlassBlockResultTemplate(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), RecipeCategory.BUILDING_BLOCKS, result, 1)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/" + getItemName(result)));
    }

}