package com.github.warrentode.todevillagers.recipes.ceramic.recipebook;

import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.recipes.ceramic.CeramicRecipe;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CeramicRecipeCategories {
    public static final Supplier<RecipeBookCategories> CERAMIC_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("CERAMIC_SEARCH", new ItemStack(Items.COMPASS)));
    public static final Supplier<RecipeBookCategories> CERAMICS = Suppliers.memoize(() -> RecipeBookCategories.create("CERAMICS", new ItemStack(Items.FLOWER_POT)));
    public static final Supplier<RecipeBookCategories> GLAZING = Suppliers.memoize(() -> RecipeBookCategories.create("GLAZING", new ItemStack(Items.WHITE_GLAZED_TERRACOTTA)));
    public static final Supplier<RecipeBookCategories> FIRING = Suppliers.memoize(() -> RecipeBookCategories.create("FIRING", new ItemStack(Items.BRICK)));

    public static void init(@NotNull RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(ModRecipes.CERAMIC_BOOK, ImmutableList.of(CERAMIC_SEARCH.get(), CERAMICS.get(), GLAZING.get(), FIRING.get()));
        event.registerAggregateCategory(CERAMIC_SEARCH.get(), ImmutableList.of(CERAMICS.get(), GLAZING.get(), FIRING.get()));
        event.registerRecipeCategoryFinder(ModRecipes.RECIPE_TYPE_CERAMIC.get(), recipe ->
        {
            if (recipe instanceof CeramicRecipe ceramicRecipe) {
                CeramicRecipeBookTab tab = ceramicRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case CERAMICS -> CERAMICS.get();
                        case GLAZING -> GLAZING.get();
                        case FIRING -> FIRING.get();
                    };
                }
            }

            // If no tab is specified in recipe, this fallback organizes them instead
            return CERAMICS.get();
        });
    }
}