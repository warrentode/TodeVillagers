package com.github.warrentode.todevillagers.recipes.remainder;

import com.github.warrentode.todevillagers.utils.IngredientRemainderUtil;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IShapedRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class RemainderShapedRecipe extends ShapedRecipe implements IShapedRecipe<CraftingContainer> {
    static final int MAX_WIDTH = 3;
    static final int MAX_HEIGHT = 3;
    final int width;
    final int height;
    final NonNullList<Ingredient> recipeItems;
    final ItemStack result;
    private final ResourceLocation id;
    final String group;
    public final CraftingBookCategory category;
    final boolean showNotification;

    public RemainderShapedRecipe(ResourceLocation id, String group, CraftingBookCategory category,
                                 int width, int height, NonNullList<Ingredient> ingredients,
                                 ItemStack result, boolean showNotification) {
        super(id, group, category, width, height, ingredients, result, showNotification);
        this.id = id;
        this.group = group;
        this.category = category;
        this.width = MAX_WIDTH;
        this.height = MAX_HEIGHT;
        this.recipeItems = ingredients;
        this.result = result;
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
        return this.recipeItems;
    }

    @Override
    public @NotNull ItemStack getResultItem(@NotNull RegistryAccess registryAccess) {
        return this.result;
    }

    @Override
    public boolean showNotification() {
        return this.showNotification;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth >= this.width && pHeight >= this.height;
    }

    @Override
    public boolean matches(@NotNull CraftingContainer container, @NotNull Level level) {
        for (int i = 0; i <= container.getWidth() - this.width; ++i) {
            for (int j = 0; j <= container.getHeight() - this.height; ++j) {
                if (this.matches(container, i, j, true)) {
                    return true;
                }

                if (this.matches(container, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(@NotNull CraftingContainer container, int width, int height, boolean mirrored) {
        for (int i = 0; i < container.getWidth(); ++i) {
            for (int j = 0; j < container.getHeight(); ++j) {
                int k = i - width;
                int l = j - height;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    if (mirrored) {
                        ingredient = this.recipeItems.get(this.width - k - 1 + l * this.width);
                    }
                    else {
                        ingredient = this.recipeItems.get(k + l * this.width);
                    }
                }

                if (!ingredient.test(container.getItem(i + j * container.getWidth()))) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer container, @NotNull RegistryAccess access) {
        return this.getResultItem(access).copy();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getRecipeWidth() {
        return getWidth();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getRecipeHeight() {
        return getHeight();
    }

    public static @NotNull NonNullList<Ingredient> dissolvePattern(String @NotNull [] pattern, @NotNull Map<String, Ingredient> keys, int patternWidth, int patternHeight) {
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(patternWidth * patternHeight, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(keys.keySet());
        set.remove(" ");

        for (int i = 0; i < pattern.length; ++i) {
            for (int j = 0; j < pattern[i].length(); ++j) {
                String s = pattern[i].substring(j, j + 1);
                Ingredient ingredient = keys.get(s);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                }

                set.remove(s);
                nonnulllist.set(j + patternWidth * i, ingredient);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        }
        else {
            return nonnulllist;
        }
    }

    static String @NotNull [] shrink(String @NotNull ... toShrink) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for (int i1 = 0; i1 < toShrink.length; ++i1) {
            String s = toShrink[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);
            if (j1 < 0) {
                if (k == i1) {
                    ++k;
                }

                ++l;
            }
            else {
                l = 0;
            }
        }

        if (toShrink.length == l) {
            return new String[0];
        }
        else {
            String[] astring = new String[toShrink.length - l - k];

            for (int k1 = 0; k1 < astring.length; ++k1) {
                astring[k1] = toShrink[k1 + k].substring(i, j + 1);
            }

            return astring;
        }
    }

    @Override
    public boolean isIncomplete() {
        NonNullList<Ingredient> nonnulllist = this.getIngredients();
        return nonnulllist.isEmpty() || nonnulllist.stream().filter((ingredient) -> !ingredient.isEmpty()).anyMatch(ForgeHooks::hasNoElements);
    }

    private static int firstNonSpace(@NotNull String entry) {
        int i;
        //noinspection StatementWithEmptyBody
        for (i = 0; i < entry.length() && entry.charAt(i) == ' '; ++i) {
        }
        return i;
    }

    private static int lastNonSpace(@NotNull String entry) {
        int i;
        //noinspection StatementWithEmptyBody
        for (i = entry.length() - 1; i >= 0 && entry.charAt(i) == ' '; --i) {
        }
        return i;
    }

    static String @NotNull [] patternFromJson(@NotNull JsonArray patternArray) {
        String[] astring = new String[patternArray.size()];
        if (astring.length > MAX_HEIGHT) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
        }
        else if (astring.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        }
        else {
            for (int i = 0; i < astring.length; ++i) {
                String s = GsonHelper.convertToString(patternArray.get(i), "pattern[" + i + "]");
                if (s.length() > MAX_WIDTH) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
                }

                if (i > 0 && astring[0].length() != s.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                astring[i] = s;
            }

            return astring;
        }
    }

    static @NotNull Map<String, Ingredient> keyFromJson(@NotNull JsonObject keyEntry) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> entry : keyEntry.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue(), false));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    public static @NotNull ItemStack itemStackFromJson(JsonObject stackObject) {
        return CraftingHelper.getItemStack(stackObject, true, true);
    }

    // --- Core custom bit: handle durability returns ---
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

    public static class Type implements RecipeType<RemainderShapedRecipe> {
        public static final Type INSTANCE = new Type();
        @SuppressWarnings("unused")
        public static final String ID = "crafting_shaped_remainder";

        private Type() {
        }
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    // --- Serializer: mostly copy of vanilla ShapedRecipe.Serializer ---
    public static class Serializer implements RecipeSerializer<RemainderShapedRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID = new ResourceLocation(MODID + "crafting_shaped_remainder");

        @Override
        public @NotNull RemainderShapedRecipe fromJson(@NotNull ResourceLocation recipeID, @NotNull JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group", "");
            CraftingBookCategory recipeCategory = CraftingBookCategory.CODEC.byName(GsonHelper.getAsString(jsonObject, "category", null), CraftingBookCategory.MISC);
            Map<String, Ingredient> ingredientMap = RemainderShapedRecipe.keyFromJson(GsonHelper.getAsJsonObject(jsonObject, "key"));
            String[] patterns = RemainderShapedRecipe.shrink(RemainderShapedRecipe.patternFromJson(GsonHelper.getAsJsonArray(jsonObject, "pattern")));
            int i = patterns[0].length();
            int j = patterns.length;
            NonNullList<Ingredient> ingredients = RemainderShapedRecipe.dissolvePattern(patterns, ingredientMap, i, j);
            ItemStack stack = RemainderShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
            boolean flag = GsonHelper.getAsBoolean(jsonObject, "show_notification", true);
            return new RemainderShapedRecipe(recipeID, group, recipeCategory, i, j, ingredients, stack, flag);
        }

        @Override
        public RemainderShapedRecipe fromNetwork(@NotNull ResourceLocation recipeID, @NotNull FriendlyByteBuf byteBuf) {
            int width = byteBuf.readVarInt();
            int height = byteBuf.readVarInt();
            String group = byteBuf.readUtf();
            CraftingBookCategory recipeCategory = byteBuf.readEnum(CraftingBookCategory.class);
            NonNullList<Ingredient> ingredients = NonNullList.withSize(width * height, Ingredient.EMPTY);

            ingredients.replaceAll(ignored -> Ingredient.fromNetwork(byteBuf));

            ItemStack stack = byteBuf.readItem();
            boolean flag = byteBuf.readBoolean();
            return new RemainderShapedRecipe(recipeID, group, recipeCategory, width, height, ingredients, stack, flag);
        }

        public void toNetwork(@NotNull FriendlyByteBuf byteBuf, @NotNull RemainderShapedRecipe recipe) {
            byteBuf.writeVarInt(recipe.width);
            byteBuf.writeVarInt(recipe.height);
            byteBuf.writeUtf(recipe.group);
            byteBuf.writeEnum(recipe.category);

            for (Ingredient ingredient : recipe.recipeItems) {
                ingredient.toNetwork(byteBuf);
            }

            byteBuf.writeItem(recipe.result);
            byteBuf.writeBoolean(recipe.showNotification);
        }
    }
}