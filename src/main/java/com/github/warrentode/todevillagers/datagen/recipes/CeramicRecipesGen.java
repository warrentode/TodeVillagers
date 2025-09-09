package com.github.warrentode.todevillagers.datagen.recipes;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.datagen.recipes.builder.CeramicRecipesBuilder;
import com.github.warrentode.todevillagers.recipes.ceramic.recipebook.CeramicRecipeBookTab;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CeramicRecipesGen extends RecipeProvider implements IConditionBuilder {
    public static final float DEFAULT_XP = 0.35F;
    public static final int DEFAULT_TIME = 100;

    public CeramicRecipesGen(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        CeramicRecipesBuilder.ceramicRecipe(getItemName(Items.BRICK), Items.BRICK, 1, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("brick")
                .addIngredient(Items.CLAY_BALL)
                .setRecipeBookTab(CeramicRecipeBookTab.FIRING)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .build(consumer);
        CeramicRecipesBuilder.ceramicRecipe(getItemName(Items.BRICKS), Items.BRICKS, 1, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("brick")
                .addIngredient(Items.CLAY_BALL)
                .addIngredient(Items.CLAY_BALL)
                .addIngredient(Items.CLAY_BALL)
                .addIngredient(Items.CLAY_BALL)
                .setRecipeBookTab(CeramicRecipeBookTab.FIRING)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                .build(consumer);
        CeramicRecipesBuilder.ceramicRecipe("bulk_" + getItemName(Items.TERRACOTTA), Items.TERRACOTTA, 4, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("terracotta")
                .addIngredient(Items.CLAY)
                .addIngredient(Items.CLAY)
                .addIngredient(Items.CLAY)
                .addIngredient(Items.CLAY)
                .setRecipeBookTab(CeramicRecipeBookTab.FIRING)
                .unlockedBy("has_clay", has(Items.CLAY))
                .build(consumer);
        CeramicRecipesBuilder.ceramicRecipe(getItemName(ModBlocks.VASE_TERRACOTTA.get()), ModBlocks.VASE_TERRACOTTA.get(), 4, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("vase")
                .addIngredient(ModBlocks.VASE_RAW.get())
                .addIngredient(ModBlocks.VASE_RAW.get())
                .addIngredient(ModBlocks.VASE_RAW.get())
                .addIngredient(ModBlocks.VASE_RAW.get())
                .setRecipeBookTab(CeramicRecipeBookTab.FIRING)
                .unlockedBy("has_raw_vase", has(ModBlocks.VASE_RAW.get()))
                .build(consumer);
        // glazed terracotta bulk recipes
        glazedTerracottaTemplate(consumer, Items.WHITE_TERRACOTTA, Items.WHITE_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.ORANGE_TERRACOTTA, Items.ORANGE_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.MAGENTA_TERRACOTTA, Items.MAGENTA_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.LIGHT_BLUE_TERRACOTTA, Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.YELLOW_TERRACOTTA, Items.YELLOW_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.LIME_TERRACOTTA, Items.LIME_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.PINK_TERRACOTTA, Items.PINK_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.GRAY_TERRACOTTA, Items.GRAY_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.LIGHT_GRAY_TERRACOTTA, Items.LIGHT_GRAY_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.CYAN_TERRACOTTA, Items.CYAN_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.PURPLE_TERRACOTTA, Items.PURPLE_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.BLUE_TERRACOTTA, Items.BLUE_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.BROWN_TERRACOTTA, Items.BROWN_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.GREEN_TERRACOTTA, Items.GREEN_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.RED_TERRACOTTA, Items.RED_GLAZED_TERRACOTTA);
        glazedTerracottaTemplate(consumer, Items.BLACK_TERRACOTTA, Items.BLACK_GLAZED_TERRACOTTA);
        // glazed terracotta plate bulk recipes
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_WHITE.get().asItem(), ModBlocks.PLATE_GLAZED_WHITE.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_ORANGE.get().asItem(), ModBlocks.PLATE_GLAZED_ORANGE.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_MAGENTA.get().asItem(), ModBlocks.PLATE_GLAZED_MAGENTA.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_LIGHT_BLUE.get().asItem(), ModBlocks.PLATE_GLAZED_LIGHT_BLUE.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_YELLOW.get().asItem(), ModBlocks.PLATE_GLAZED_YELLOW.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_LIME.get().asItem(), ModBlocks.PLATE_GLAZED_LIME.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_PINK.get().asItem(), ModBlocks.PLATE_GLAZED_PINK.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_GRAY.get().asItem(), ModBlocks.PLATE_GLAZED_GRAY.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_LIGHT_GRAY.get().asItem(), ModBlocks.PLATE_GLAZED_LIGHT_GRAY.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_CYAN.get().asItem(), ModBlocks.PLATE_GLAZED_CYAN.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_PURPLE.get().asItem(), ModBlocks.PLATE_GLAZED_PURPLE.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_BLUE.get().asItem(), ModBlocks.PLATE_GLAZED_BLUE.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_BROWN.get().asItem(), ModBlocks.PLATE_GLAZED_BROWN.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_GREEN.get().asItem(), ModBlocks.PLATE_GLAZED_GREEN.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_RED.get().asItem(), ModBlocks.PLATE_GLAZED_RED.get().asItem());
        glazedPlatesTemplate(consumer, ModBlocks.PLATE_BLACK.get().asItem(), ModBlocks.PLATE_GLAZED_BLACK.get().asItem());
        // glazed terracotta vase bulk recipes
        glazedVasesTemplate(consumer, ModBlocks.VASE_WHITE.get().asItem(), ModBlocks.VASE_GLAZED_WHITE.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_ORANGE.get().asItem(), ModBlocks.VASE_GLAZED_ORANGE.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_MAGENTA.get().asItem(), ModBlocks.VASE_GLAZED_MAGENTA.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_LIGHT_BLUE.get().asItem(), ModBlocks.VASE_GLAZED_LIGHT_BLUE.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_YELLOW.get().asItem(), ModBlocks.VASE_GLAZED_YELLOW.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_LIME.get().asItem(), ModBlocks.VASE_GLAZED_LIME.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_PINK.get().asItem(), ModBlocks.VASE_GLAZED_PINK.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_GRAY.get().asItem(), ModBlocks.VASE_GLAZED_GRAY.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_LIGHT_GRAY.get().asItem(), ModBlocks.VASE_GLAZED_LIGHT_GRAY.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_CYAN.get().asItem(), ModBlocks.VASE_GLAZED_CYAN.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_PURPLE.get().asItem(), ModBlocks.VASE_GLAZED_PURPLE.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_BLUE.get().asItem(), ModBlocks.VASE_GLAZED_BLUE.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_BROWN.get().asItem(), ModBlocks.VASE_GLAZED_BROWN.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_GREEN.get().asItem(), ModBlocks.VASE_GLAZED_GREEN.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_RED.get().asItem(), ModBlocks.VASE_GLAZED_RED.get().asItem());
        glazedVasesTemplate(consumer, ModBlocks.VASE_BLACK.get().asItem(), ModBlocks.VASE_GLAZED_BLACK.get().asItem());
        // glazed terracotta jar bulk recipes
        glazedJarsTemplate(consumer, ModBlocks.JAR_WHITE.get().asItem(), ModBlocks.JAR_GLAZED_WHITE.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_ORANGE.get().asItem(), ModBlocks.JAR_GLAZED_ORANGE.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_MAGENTA.get().asItem(), ModBlocks.JAR_GLAZED_MAGENTA.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_LIGHT_BLUE.get().asItem(), ModBlocks.JAR_GLAZED_LIGHT_BLUE.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_YELLOW.get().asItem(), ModBlocks.JAR_GLAZED_YELLOW.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_LIME.get().asItem(), ModBlocks.JAR_GLAZED_LIME.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_PINK.get().asItem(), ModBlocks.JAR_GLAZED_PINK.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_GRAY.get().asItem(), ModBlocks.JAR_GLAZED_GRAY.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_LIGHT_GRAY.get().asItem(), ModBlocks.JAR_GLAZED_LIGHT_GRAY.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_CYAN.get().asItem(), ModBlocks.JAR_GLAZED_CYAN.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_PURPLE.get().asItem(), ModBlocks.JAR_GLAZED_PURPLE.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_BLUE.get().asItem(), ModBlocks.JAR_GLAZED_BLUE.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_BROWN.get().asItem(), ModBlocks.JAR_GLAZED_BROWN.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_GREEN.get().asItem(), ModBlocks.JAR_GLAZED_GREEN.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_RED.get().asItem(), ModBlocks.JAR_GLAZED_RED.get().asItem());
        glazedJarsTemplate(consumer, ModBlocks.JAR_BLACK.get().asItem(), ModBlocks.JAR_GLAZED_BLACK.get().asItem());
    }

    public static void glazedJarsTemplate(Consumer<FinishedRecipe> consumer, @NotNull Item ingredient, Item result) {
        CeramicRecipesBuilder.ceramicRecipe(getItemName(result), result, 4, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("glazed_jars")
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .setRecipeBookTab(CeramicRecipeBookTab.GLAZING)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .build(consumer);
    }

    public static void glazedVasesTemplate(Consumer<FinishedRecipe> consumer, @NotNull Item ingredient, Item result) {
        CeramicRecipesBuilder.ceramicRecipe(getItemName(result), result, 4, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("glazed_vases")
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .setRecipeBookTab(CeramicRecipeBookTab.GLAZING)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .build(consumer);
    }

    public static void glazedPlatesTemplate(Consumer<FinishedRecipe> consumer, @NotNull Item ingredient, Item result) {
        CeramicRecipesBuilder.ceramicRecipe(getItemName(result), result, 4, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("glazed_plates")
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .setRecipeBookTab(CeramicRecipeBookTab.GLAZING)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .build(consumer);
    }

    public static void glazedTerracottaTemplate(Consumer<FinishedRecipe> consumer, @NotNull Item ingredient, Item result) {
        CeramicRecipesBuilder.ceramicRecipe("bulk_" + getItemName(result), result, 4, DEFAULT_TIME, DEFAULT_XP)
                .setGroup("glazed_terracotta")
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .addIngredient(ingredient)
                .setRecipeBookTab(CeramicRecipeBookTab.GLAZING)
                .unlockedBy("has_" + getItemName(ingredient), has(ingredient))
                .build(consumer);
    }
}