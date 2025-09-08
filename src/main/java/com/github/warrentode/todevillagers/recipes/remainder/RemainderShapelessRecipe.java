package com.github.warrentode.todevillagers.recipes.remainder;

import com.github.warrentode.todevillagers.utils.IngredientRemainderUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.common.crafting.CraftingHelper;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class RemainderShapelessRecipe extends ShapelessRecipe {
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;
    private final ResourceLocation id;
    private final String group;
    final CraftingBookCategory category;
    private final boolean showNotification;

    public RemainderShapelessRecipe(ResourceLocation id, String group, CraftingBookCategory category, ItemStack result,
                                    NonNullList<Ingredient> ingredients, boolean showNotification) {
        super(id, group, category, result, ingredients);
        this.id = id;
        this.group = group;
        this.category = category;
        this.result = result;
        this.ingredients = ingredients;
        this.showNotification = showNotification;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    @Override
    public @NotNull String getGroup() {
        return this.group;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess registryAccess) {
        return this.result;
    }

    @Override
    public boolean showNotification() {
        return this.showNotification;
    }

    // --- Custom remainder handling ---
    @Override
    public @NotNull NonNullList<ItemStack> getRemainingItems(@NotNull CraftingContainer container) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(container.getContainerSize(), ItemStack.EMPTY);

        for (int slot = 0; slot < container.getContainerSize(); ++slot) {
            ItemStack stack = container.getItem(slot);
            //noinspection DataFlowIssue
            remaining.set(slot, IngredientRemainderUtil.getRemainder(stack));
        }

        return remaining;
    }

    public static class Type implements RecipeType<RemainderShapelessRecipe> {
        public static final Type INSTANCE = new Type();
        @SuppressWarnings("unused")
        public static final String ID = "crafting_shapeless_remainder";

        private Type() {
        }
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    // --- Serializer ---
    public static class Serializer implements RecipeSerializer<RemainderShapelessRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID = new ResourceLocation(MODID + "crafting_shapeless_remainder");

        @Override
        public @NotNull RemainderShapelessRecipe fromJson(@NotNull ResourceLocation recipeID, @NotNull JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group", "");
            CraftingBookCategory recipeCategory = CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category", null), CraftingBookCategory.MISC);
            boolean flag = GsonHelper.getAsBoolean(jsonObject, "show_notification", true);
            NonNullList<Ingredient> ingredients = NonNullList.create();
            for (JsonElement element : GsonHelper.getAsJsonArray(jsonObject, "ingredients")) {
                ingredients.add(Ingredient.fromJson(element));
            }
            ItemStack result = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(jsonObject, "result"), true, true);
            return new RemainderShapelessRecipe(recipeID, group, recipeCategory, result, ingredients, flag);
        }

        @Override
        public RemainderShapelessRecipe fromNetwork(@NotNull ResourceLocation recipeID, @NotNull FriendlyByteBuf byteBuf) {
            String group = byteBuf.readUtf();
            CraftingBookCategory recipeCategory = byteBuf.readEnum(CraftingBookCategory.class);
            boolean flag = byteBuf.readBoolean();
            int size = byteBuf.readVarInt();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
            for (int i = 0; i < size; i++) {
                ingredients.set(i, Ingredient.fromNetwork(byteBuf));
            }
            ItemStack result = byteBuf.readItem();
            return new RemainderShapelessRecipe(recipeID, group, recipeCategory, result, ingredients, flag);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf byteBuf, @NotNull RemainderShapelessRecipe recipe) {
            byteBuf.writeUtf(recipe.group);
            byteBuf.writeEnum(recipe.category);
            byteBuf.writeBoolean(recipe.showNotification);
            byteBuf.writeVarInt(recipe.ingredients.size());
            for (Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(byteBuf);
            }
            byteBuf.writeItem(recipe.result);
        }
    }
}