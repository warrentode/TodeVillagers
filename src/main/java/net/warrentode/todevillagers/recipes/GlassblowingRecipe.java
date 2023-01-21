package net.warrentode.todevillagers.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import static net.warrentode.todevillagers.TodeVillagers.MODID;
import static net.warrentode.todevillagers.recipes.GlassblowingRecipe.Serializer.ID;

public class GlassblowingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> tool;
    private final NonNullList<Ingredient> dye;
    private final NonNullList<Ingredient> modifier;
    private final NonNullList<Ingredient> ingredients;

    public GlassblowingRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> tool, NonNullList<Ingredient> dye, NonNullList<Ingredient> modifier, NonNullList<Ingredient> ingredients) {
        this.id = id;
        this.result = result;
        this.tool = tool;
        this.dye = dye;
        this.modifier = modifier;
        this.ingredients = ingredients;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, @NotNull Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        return ingredients.get(0).test(pContainer.getItem(1))
                && tool.get(0).test(pContainer.getItem(2))
                && dye.get(0).test(pContainer.getItem(3))
                && modifier.get(0).test(pContainer.getItem(4));
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }
    @Override
    public @NotNull ResourceLocation getId() {
        return ID;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer pContainer) {
        return result;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return result.copy();
    }

    public NonNullList<Ingredient> getTool() {
        return tool;
    }

    public NonNullList<Ingredient> getDye() {
        return dye;
    }

    public NonNullList<Ingredient> getModifier() {
        return modifier;
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GlassblowingRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "glassblowing";
    }

    public static class Serializer implements RecipeSerializer<GlassblowingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(MODID, "glassblowing");

        @Override
        public @NotNull GlassblowingRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> input1 = NonNullList.withSize(1, Ingredient.EMPTY);
            JsonArray tool = GsonHelper.getAsJsonArray(pSerializedRecipe, "tool");
            NonNullList<Ingredient> input2 = NonNullList.withSize(1, Ingredient.EMPTY);
            JsonArray dye = GsonHelper.getAsJsonArray(pSerializedRecipe, "dye");
            NonNullList<Ingredient> input3 = NonNullList.withSize(1, Ingredient.EMPTY);
            JsonArray modifier = GsonHelper.getAsJsonArray(pSerializedRecipe, "modifier");
            NonNullList<Ingredient> input4 = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < input1.size(); i++) { input1.set(i, Ingredient.fromJson(ingredients.get(i))); }
            for (int j = 0; j < input2.size(); j++) { input2.set(j, Ingredient.fromJson(tool.get(j))); }
            for (int k = 0; k < input3.size(); k++) { input3.set(k, Ingredient.fromJson(dye.get(k))); }
            for (int l = 0; l < input4.size(); l++) { input4.set(l, Ingredient.fromJson(modifier.get(l))); }

            return new GlassblowingRecipe(pRecipeId, result, input1, input2, input3, input4);

        }

        @Override
        public GlassblowingRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> input1 = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            NonNullList<Ingredient> input2 = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            NonNullList<Ingredient> input3 = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            NonNullList<Ingredient> input4 = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < input1.size(); i++) { input1.set(i, Ingredient.fromNetwork(buf)); }
            for (int j = 0; j < input2.size(); j++) { input2.set(j, Ingredient.fromNetwork(buf)); }
            for (int k = 0; k < input3.size(); k++) { input3.set(k, Ingredient.fromNetwork(buf)); }
            for (int l = 0; l < input4.size(); l++) { input4.set(l, Ingredient.fromNetwork(buf)); }

            ItemStack result = buf.readItem();
            return new GlassblowingRecipe(id, result, input1, input2, input3, input4);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, GlassblowingRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            buf.writeInt(recipe.getTool().size());
            buf.writeInt(recipe.getDye().size());
            buf.writeInt(recipe.getModifier().size());

            for (Ingredient ing : recipe.getIngredients()) { ing.toNetwork(buf); }
            for (Ingredient ing : recipe.getTool()) { ing.toNetwork(buf); }
            for (Ingredient ing : recipe.getDye()) { ing.toNetwork(buf); }
            for (Ingredient ing : recipe.getModifier()) {ing.toNetwork(buf);}
            buf.writeItemStack(recipe.getResultItem(), false);
        }
    }

}
