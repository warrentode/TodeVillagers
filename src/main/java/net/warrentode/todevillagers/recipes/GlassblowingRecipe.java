package net.warrentode.todevillagers.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.RecipeMatcher;
import org.jetbrains.annotations.NotNull;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class GlassblowingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    final String group;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;
    private final boolean isSimple;
    static int width = 0;
    static int height = 0;
    static final int MAX_WIDTH = 2;
    static final int MAX_HEIGHT = 2;

    public GlassblowingRecipe(ResourceLocation id, String group, ItemStack result, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.group = group;
        this.result = result;
        this.recipeItems = recipeItems;
        this.isSimple = recipeItems.stream().allMatch(Ingredient::isSimple);
        width = MAX_WIDTH;
        height = MAX_HEIGHT;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer inventory, @NotNull Level level) {
        if(level.isClientSide()) {
            return false;
        }
        StackedContents stackedcontents = new StackedContents();
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for(int j = 0; j < 4; ++j) {
            ItemStack itemstack = inventory.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                if (isSimple)
                    stackedcontents.accountStack(itemstack, 1);
                else inputs.add(itemstack);
            }
        }

        return i == this.recipeItems.size() && (isSimple ? stackedcontents.canCraft(this, null) : RecipeMatcher.findMatches(inputs,  this.recipeItems) != null);
    }

    @Override
    public @NotNull NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer inventory) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return 2 * 2 >= this.recipeItems.size();
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
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
        @SuppressWarnings("unused")
        public static final String ID = "glassblowing";
    }

    public static class Serializer implements RecipeSerializer<GlassblowingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID = new ResourceLocation(MODID, "glassblowing");
        private static final int width = MAX_WIDTH;
        private static final int height = MAX_HEIGHT;

        @Override
        public @NotNull GlassblowingRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject pSerializedRecipe) {
            String group = GsonHelper.getAsString(pSerializedRecipe, "group", "");
            NonNullList<Ingredient> inputs = itemsFromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients"));
            if (inputs.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (inputs.size() > width * height) {
                throw new JsonParseException("Too many ingredients for shapeless recipe. The maximum is " + width * height);
            } else {
                ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
                return new GlassblowingRecipe(id, group, itemstack, inputs);
            }
        }

        private NonNullList<Ingredient> itemsFromJson(JsonArray ingredients) {
            NonNullList<Ingredient> inputs = NonNullList.create();

            for(int i = 0; i < ingredients.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredients.get(i));
                //noinspection ConstantValue,PointlessBooleanExpression
                if (true || !ingredient.isEmpty()) { // FORGE: Skip checking if an ingredient is empty during shapeless recipe deserialization to prevent complex ingredients from caching tags too early. Can not be done using a config value due to sync issues.
                    inputs.add(ingredient);
                }
            }

            return inputs;
        }

        public GlassblowingRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf buf) {
            String group = buf.readUtf();
            int i = buf.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(i, Ingredient.EMPTY);

            //noinspection Java8ListReplaceAll
            for(int j = 0; j < inputs.size(); ++j) {
                inputs.set(j, Ingredient.fromNetwork(buf));
            }

            ItemStack itemstack = buf.readItem();
            return new GlassblowingRecipe(id, group, itemstack, inputs);
        }

        public void toNetwork(FriendlyByteBuf buf, GlassblowingRecipe pRecipe) {
            buf.writeVarInt(GlassblowingRecipe.width);
            buf.writeVarInt(GlassblowingRecipe.height);
            buf.writeUtf(pRecipe.group);

            for (Ingredient ingredient : pRecipe.recipeItems) {
                ingredient.toNetwork(buf);
            }

            buf.writeItem(pRecipe.result);
        }
    }
}