package com.github.warrentode.todevillagers.datagen.recipes.builder;

import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.recipes.ceramic.recipebook.CeramicRecipeBookTab;
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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class CeramicRecipesBuilder {
    private CeramicRecipeBookTab tab;
    private String group;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final String recipeName;
    private final Item result;
    private final int count;
    private final int ceramicKilnTime;
    private final float experience;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public CeramicRecipesBuilder(String recipeName, @NotNull ItemLike result, int count, int ceramicKilnTime, float experience) {
        this.recipeName = recipeName;
        this.result = result.asItem();
        this.count = count;
        this.ceramicKilnTime = ceramicKilnTime;
        this.experience = experience;
        this.tab = null;
        this.group = null;
    }

    @Contract("_, _, _, _, _ -> new")
    public static @NotNull CeramicRecipesBuilder ceramicRecipe(String recipeName, ItemLike mainResult, int count, int cookingTime, float experience) {
        return new CeramicRecipesBuilder(recipeName, mainResult, count, cookingTime, experience);
    }

    public CeramicRecipesBuilder addIngredient(TagKey<Item> tagIn) {
        return addIngredient(Ingredient.of(tagIn));
    }

    public CeramicRecipesBuilder addIngredient(ItemLike itemIn) {
        return addIngredient(itemIn, 1);
    }

    public CeramicRecipesBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            addIngredient(Ingredient.of(itemIn));
        }
        return this;
    }

    public CeramicRecipesBuilder addIngredient(Ingredient ingredientIn) {
        return addIngredient(ingredientIn, 1);
    }

    public CeramicRecipesBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            ingredients.add(ingredientIn);
        }
        return this;
    }

    public CeramicRecipesBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public CeramicRecipesBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public CeramicRecipesBuilder unlockedByAnyIngredient(ItemLike... items) {
        advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public CeramicRecipesBuilder setRecipeBookTab(CeramicRecipeBookTab tab) {
        this.tab = tab;
        return this;
    }

    public CeramicRecipesBuilder setGroup(String group) {
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
        build(consumerIn, MODID + ":ceramics/" + tab + "/" + group + "/" + location.getPath());
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Ceramic Recipe " + save + " should remove its 'save' argument");
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
            consumerIn.accept(new Result(id, result, count, ingredients, ceramicKilnTime, experience, tab, group, advancement, advancementId));
        }
        else {
            consumerIn.accept(new Result(id, result, count, ingredients, ceramicKilnTime, experience, tab, group));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final CeramicRecipeBookTab tab;
        private final String group;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int ceramicKilnTime;
        private final float experience;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int ceramicKilnTimeIn, float experienceIn, @Nullable CeramicRecipeBookTab tabIn, String groupIn, @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = idIn;
            this.tab = tabIn;
            this.group = groupIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.ceramicKilnTime = ceramicKilnTimeIn;
            this.experience = experienceIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int ceramicKilnTimeIn, float experienceIn, @Nullable CeramicRecipeBookTab tabIn, String groupIn) {
            this(idIn, resultIn, countIn, ingredientsIn, ceramicKilnTimeIn, experienceIn, tabIn, groupIn, null, null);
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
            json.addProperty("ceramicKilnTime", ceramicKilnTime);

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
            return ModRecipes.CERAMIC_SERIALIZER.get();
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