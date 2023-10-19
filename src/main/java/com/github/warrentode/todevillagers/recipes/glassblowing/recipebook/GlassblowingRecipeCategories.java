package com.github.warrentode.todevillagers.recipes.glassblowing.recipebook;

import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.recipes.glassblowing.GlassblowingRecipe;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class GlassblowingRecipeCategories {
    public static final Supplier<RecipeBookCategories> GLASSBLOWING_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("GLASSBLOWING_SEARCH", new ItemStack(Items.COMPASS)));
    public static final Supplier<RecipeBookCategories> GLASS_WORK = Suppliers.memoize(() -> RecipeBookCategories.create("GLASS_WORK", new ItemStack(ModItems.GLASSBLOWING_PIPE.get())));
    public static final Supplier<RecipeBookCategories> RECYCLE = Suppliers.memoize(() -> RecipeBookCategories.create("RECYCLE", new ItemStack(ModItems.CRUSHED_GLASS.get())));

    public static void init(@NotNull RegisterRecipeBookCategoriesEvent event) {
        event.registerBookCategories(ModRecipes.GLASSBLOWING_BOOK, ImmutableList.of(GLASSBLOWING_SEARCH.get(), GLASS_WORK.get(), RECYCLE.get()));
        event.registerAggregateCategory(GLASSBLOWING_SEARCH.get(), ImmutableList.of(GLASS_WORK.get(), RECYCLE.get()));
        event.registerRecipeCategoryFinder(ModRecipes.RECIPE_TYPE_GLASSBLOWING.get(), recipe ->
        {
            if (recipe instanceof GlassblowingRecipe glassblowingRecipe) {
                GlassblowingRecipeBookTab tab = glassblowingRecipe.getRecipeBookTab();
                if (tab != null) {
                    return switch (tab) {
                        case GLASS_WORK -> GLASS_WORK.get();
                        case RECYCLING -> RECYCLE.get();
                    };
                }
            }

            // If no tab is specified in recipe, this fallback organizes them instead
            return GLASS_WORK.get();
        });
    }
}