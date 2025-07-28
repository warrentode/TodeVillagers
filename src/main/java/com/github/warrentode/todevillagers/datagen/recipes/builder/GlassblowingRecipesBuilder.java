package com.github.warrentode.todevillagers.datagen.recipes.builder;

import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.recipes.glassblowing.recipebook.GlassblowingRecipeBookTab;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

@SuppressWarnings("removal") // ResourceLocation method marked for removal
public class GlassblowingRecipesBuilder {
    private GlassblowingRecipeBookTab tab;
    private String group;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final String recipeName;
    private final Item result;
    private final int count;
    private final int glassblowingTime;
    private final float experience;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public GlassblowingRecipesBuilder(String recipeName, ItemLike result, int count, int glassblowingTime, float experience) {
        this.recipeName = recipeName;
        this.result = result.asItem();
        this.count = count;
        this.glassblowingTime = glassblowingTime;
        this.experience = experience;
        this.tab = null;
        this.group = null;
    }

    public static GlassblowingRecipesBuilder glassblowingRecipe(String recipeName, ItemLike mainResult, int count, int cookingTime, float experience) {
        return new GlassblowingRecipesBuilder(recipeName, mainResult, count, cookingTime, experience);
    }

    public GlassblowingRecipesBuilder addIngredient(TagKey<Item> tagIn) {
        return addIngredient(Ingredient.of(tagIn));
    }

    public GlassblowingRecipesBuilder addIngredient(ItemLike itemIn) {
        return addIngredient(itemIn, 1);
    }

    public GlassblowingRecipesBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            addIngredient(Ingredient.of(itemIn));
        }
        return this;
    }

    public GlassblowingRecipesBuilder addIngredient(Ingredient ingredientIn) {
        return addIngredient(ingredientIn, 1);
    }

    public GlassblowingRecipesBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            ingredients.add(ingredientIn);
        }
        return this;
    }

    public GlassblowingRecipesBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public GlassblowingRecipesBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public GlassblowingRecipesBuilder unlockedByAnyIngredient(ItemLike... items) {
        advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public GlassblowingRecipesBuilder setRecipeBookTab(GlassblowingRecipeBookTab tab) {
        this.tab = tab;
        return this;
    }

    public GlassblowingRecipesBuilder setGroup(String group) {
        this.group = group;
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location;
        if (recipeName != null) {
            location = ResourceLocation.tryParse(recipeName);
        }
        else {
            location = ForgeRegistries.ITEMS.getKey(result);
        }
        assert location != null;
        build(consumerIn, MODID + ":glassblowing/" + tab + "/" + group + "/" + location.getPath());
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Glassblowing Recipe " + save + " should remove its 'save' argument");
        }
        else {
            build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        if (!advancement.getCriteria().isEmpty()) {
            advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id))
                    .requirements(RequirementsStrategy.OR);
            ResourceLocation advancementId = new ResourceLocation(MODID, "recipes/" + id.getPath());
            consumerIn.accept(new Result(id, result, count, ingredients, glassblowingTime, experience, tab, group, advancement, advancementId));
        }
        else {
            consumerIn.accept(new Result(id, result, count, ingredients, glassblowingTime, experience, tab, group));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final GlassblowingRecipeBookTab tab;
        private final String group;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int glassblowingTime;
        private final float experience;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int glassblowingTimeIn, float experienceIn, @Nullable GlassblowingRecipeBookTab tabIn, String groupIn, @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = idIn;
            this.tab = tabIn;
            this.group = groupIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.glassblowingTime = glassblowingTimeIn;
            this.experience = experienceIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int glassblowingTimeIn, float experienceIn, @Nullable GlassblowingRecipeBookTab tabIn, String groupIn) {
            this(idIn, resultIn, countIn, ingredientsIn, glassblowingTimeIn, experienceIn, tabIn, groupIn, null, null);
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            if (tab != null) {
                json.addProperty("recipe_book_tab", tab.toString());
            }
            if (group != null) {
                json.addProperty("group", group);
            }

            if (experience > 0) {
                json.addProperty("experience", experience);
            }
            json.addProperty("glassblowingTime", glassblowingTime);

            JsonArray arrayIngredients = new JsonArray();

            for (Ingredient ingredient : ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)).toString());
            if (count > 1) {
                objectResult.addProperty("count", count);
            }
            json.add("result", objectResult);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return ModRecipes.GLASSBLOWING_SERIALIZER.get();
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