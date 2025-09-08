package com.github.warrentode.todevillagers.datagen.recipes.builder;

import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;


public class RemainderShapelessRecipeBuilder {
    private final RecipeCategory category;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int count;
    private String group = "";
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    private RemainderShapelessRecipeBuilder(RecipeCategory category, @NotNull ItemLike resultIn, int countIn) {
        this.result = resultIn.asItem();
        this.count = countIn;
        this.category = category;
    }

    public static @NotNull RemainderShapelessRecipeBuilder shapelessRemainderRecipe(RecipeCategory category, ItemLike result, int count) {
        return new RemainderShapelessRecipeBuilder(category, result, count);
    }

    public RemainderShapelessRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return addIngredient(Ingredient.of(tagIn));
    }

    public RemainderShapelessRecipeBuilder addIngredient(ItemLike itemIn) {
        return addIngredient(itemIn, 1);
    }

    public RemainderShapelessRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            addIngredient(Ingredient.of(itemIn));
        }
        return this;
    }

    public RemainderShapelessRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return addIngredient(ingredientIn, 1);
    }

    public RemainderShapelessRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            ingredients.add(ingredientIn);
        }
        return this;
    }

    public RemainderShapelessRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public RemainderShapelessRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public RemainderShapelessRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        advancement.addCriterion("has_any_ingredient",
                InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public RemainderShapelessRecipeBuilder group(String groupIn) {
        this.group = groupIn;
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
        assert location != null;
        build(consumerIn, MODID + ":shapeless_remainder/" + location.getPath());
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        build(consumerIn, new ResourceLocation(save));
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        if (!advancement.getCriteria().isEmpty()) {
            advancement.parent(new ResourceLocation("recipes/root"))
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id))
                    .requirements(RequirementsStrategy.OR);

            ResourceLocation advancementId = new ResourceLocation(id.getNamespace() + ":recipes/" + id.getPath());
            consumerIn.accept(new Result(id, result, count, ingredients, category, group, advancement, advancementId));
        }
        else {
            consumerIn.accept(new Result(id, result, count, ingredients, category, group, null, null));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final RecipeCategory category;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final String group; // NEW
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn,
                      RecipeCategory categoryIn, String groupIn,
                      @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = idIn;
            this.result = resultIn;
            this.count = countIn;
            this.ingredients = ingredientsIn;
            this.category = categoryIn;
            this.group = groupIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            if (!group.isEmpty()) json.addProperty("group", group); // NEW

            if (category != null) json.addProperty("recipe_book_category", category.toString());

            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient ingredient : ingredients) arrayIngredients.add(ingredient.toJson());
            json.add("ingredients", arrayIngredients);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)).toString());
            if (count > 1) objectResult.addProperty("count", count);
            json.add("result", objectResult);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return ModRecipes.REMAINDER_SHAPELESS_SERIALIZER.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return advancement != null ? advancement.serializeToJson() : null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return advancementId;
        }
    }
}