package com.github.warrentode.todevillagers.datagen;

import com.github.warrentode.todevillagers.datagen.recipes.CraftingRecipesGen;
import com.github.warrentode.todevillagers.datagen.recipes.GlassblowingRecipesGen;
import com.github.warrentode.todevillagers.datagen.recipes.StonecutterRecipesGen;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipesGen extends RecipeProvider {
    public RecipesGen(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        CraftingRecipesGen.register(consumer);
        StonecutterRecipesGen.register(consumer);
        GlassblowingRecipesGen.register(consumer);
    }
}