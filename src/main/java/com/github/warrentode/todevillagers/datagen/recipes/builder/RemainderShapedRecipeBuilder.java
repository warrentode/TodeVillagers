package com.github.warrentode.todevillagers.datagen.recipes.builder;

import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class RemainderShapedRecipeBuilder {
    private CraftingBookCategory category;
    private final Item result;
    private final int count;
    private String group = "";
    private final List<String> pattern = new ArrayList<>();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private final Map<String, Ingredient> keyMap = Maps.newHashMap();

    private RemainderShapedRecipeBuilder(@NotNull ItemLike resultIn, int countIn) {
        this.result = resultIn.asItem();
        this.count = countIn;
        this.category = CraftingBookCategory.MISC;
    }

    public static @NotNull RemainderShapedRecipeBuilder shapedRemainderRecipe(ItemLike result, int count) {
        return new RemainderShapedRecipeBuilder(result, count);
    }

    public RemainderShapedRecipeBuilder setRecipeBookCategory(CraftingBookCategory category) {
        this.category = category;
        return this;
    }

    public RemainderShapedRecipeBuilder setGroup(String groupIn) {
        this.group = groupIn;
        return this;
    }

    public RemainderShapedRecipeBuilder pattern(String... patternRows) {
        Collections.addAll(this.pattern, patternRows); // append instead of overwrite
        return this;
    }

    public RemainderShapedRecipeBuilder define(@NotNull String symbol, Ingredient ingredient) {
        if (symbol.length() != 1) throw new IllegalArgumentException("Key symbol must be a single character");
        keyMap.put(symbol, ingredient);
        return this;
    }

    public RemainderShapedRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
        assert location != null;
        save(consumerIn, new ResourceLocation(MODID + ":shaped_remainder/" + location.getPath()));
    }

    public void save(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        if (!advancement.getCriteria().isEmpty()) {
            advancement.parent(new ResourceLocation("recipes/root"))
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id))
                    .requirements(RequirementsStrategy.OR);
            ResourceLocation advancementId = new ResourceLocation(id.getNamespace() + ":recipes/" + id.getPath());
            consumerIn.accept(new Result(id, result, count, pattern, keyMap, category, group, advancement, advancementId));
        }
        else {
            consumerIn.accept(new Result(id, result, count, pattern, keyMap, category, group, null, null));
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private List<String> pattern = new ArrayList<>();
        private final Map<String, Ingredient> keyMap;
        private final CraftingBookCategory category;
        private final String group; // NEW
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, Item result, int count, List<String> pattern, Map<String, Ingredient> keyMap,
                      CraftingBookCategory category, String group,
                      @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId) {
            this.id = id;
            this.result = result;
            this.count = count;
            this.pattern = pattern;
            this.keyMap = keyMap;
            this.category = category;
            this.group = group;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            if (pattern != null && keyMap != null) {
                JsonArray patternArray = new JsonArray();
                for (String row : pattern) patternArray.add(row);
                json.add("pattern", patternArray);

                JsonObject keyObject = new JsonObject();
                keyMap.forEach((symbol, ingredient) -> keyObject.add(symbol, ingredient.toJson()));
                json.add("key", keyObject);
            }

            if (!group.isEmpty()) json.addProperty("group", group); // NEW

            JsonObject resultObj = new JsonObject();
            resultObj.addProperty("item", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)).toString());
            if (count > 1) resultObj.addProperty("count", count);
            json.add("result", resultObj);

            if (category != null) json.addProperty("category", category.getSerializedName());
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return ModRecipes.REMAINDER_SHAPED_SERIALIZER.get();
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