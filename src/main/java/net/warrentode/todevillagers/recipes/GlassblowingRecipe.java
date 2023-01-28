package net.warrentode.todevillagers.recipes;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class GlassblowingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final int width;
    private final int height;
    final String group;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;
    @SuppressWarnings("CanBeFinal")
    static int MAX_WIDTH = 2;
    @SuppressWarnings("CanBeFinal")
    static int MAX_HEIGHT = 2;

    public GlassblowingRecipe(ResourceLocation id, int width, int height, String group, ItemStack result, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.group = group;
        this.result = result;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer inventory, @NotNull Level level) {
        for (int i = 0; i <= inventory.getContainerSize() - this.width; ++i) {
            for (int j = 0; j <= inventory.getContainerSize() - this.height; ++j) {
                if (this.matches(inventory, i, j, true)) {
                    return true;
                }

                if (this.matches(inventory, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(SimpleContainer inventory, int width, int height, boolean mirrored) {
        for (int i = 0; i < inventory.getContainerSize(); ++i) {
            for (int j = 0; j < inventory.getContainerSize(); ++j) {
                int k = i - width;
                int l = j - height;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    if (mirrored) {
                        ingredient = this.recipeItems.get(this.width - k - 1 + l * this.width);
                    } else {
                        ingredient = this.recipeItems.get(k + l * this.width);
                    }
                }

                if (!ingredient.test(inventory.getItem(i + j * inventory.getContainerSize()))) {
                    return false;
                }
            }
        }

        return true;
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
        return pWidth >= this.width && pHeight >= this.height;
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
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        @SuppressWarnings("unused")
        public static final String ID = "glassblowing";
    }

    static NonNullList<Ingredient> dissolvePattern(String[] pPattern, Map<String, Ingredient> pKeys, int pPatternWidth, int pPatternHeight) {
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(pPatternWidth * pPatternHeight, Ingredient.EMPTY);
        Set<String> set = Sets.newHashSet(pKeys.keySet());
        set.remove(" ");

        for (int i = 0; i < pPattern.length; ++i) {
            for (int j = 0; j < pPattern[i].length(); ++j) {
                String s = pPattern[i].substring(j, j + 1);
                Ingredient ingredient = pKeys.get(s);
                if (ingredient == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                }

                set.remove(s);
                nonnulllist.set(j + pPatternWidth * i, ingredient);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        } else {
            return nonnulllist;
        }
    }

    @VisibleForTesting
    static String[] shrink(String... pToShrink) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for (int i1 = 0; i1 < pToShrink.length; ++i1) {
            String s = pToShrink[i1];
            i = Math.min(i, firstNonSpace(s));
            int j1 = lastNonSpace(s);
            j = Math.max(j, j1);
            if (j1 < 0) {
                if (k == i1) {
                    ++k;
                }

                ++l;
            } else {
                l = 0;
            }
        }

        if (pToShrink.length == l) {
            return new String[0];
        } else {
            String[] astring = new String[pToShrink.length - l - k];

            for (int k1 = 0; k1 < astring.length; ++k1) {
                astring[k1] = pToShrink[k1 + k].substring(i, j + 1);
            }

            return astring;
        }
    }

    public boolean isIncomplete() {
        NonNullList<Ingredient> nonnulllist = this.getIngredients();
        return nonnulllist.isEmpty() || nonnulllist.stream().filter((p_151277_) ->
                !p_151277_.isEmpty()).anyMatch(ForgeHooks::hasNoElements);
    }

    private static int firstNonSpace(String pEntry) {
        int i;
        //noinspection StatementWithEmptyBody
        for (i = 0; i < pEntry.length() && pEntry.charAt(i) == ' '; ++i) {
        }

        return i;
    }

    private static int lastNonSpace(String pEntry) {
        int i;
        //noinspection StatementWithEmptyBody
        for (i = pEntry.length() - 1; i >= 0 && pEntry.charAt(i) == ' '; --i) {
        }

        return i;
    }

    static String[] patternFromJson(JsonArray pPatternArray) {
        String[] astring = new String[pPatternArray.size()];
        if (astring.length > MAX_HEIGHT) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
        } else if (astring.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else {
            for (int i = 0; i < astring.length; ++i) {
                String s = GsonHelper.convertToString(pPatternArray.get(i), "pattern[" + i + "]");
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

    @SuppressWarnings("RedundantCast")
    static Map<String, Ingredient> keyFromJson(JsonObject pKeyEntry) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> entry : pKeyEntry.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    public static ItemStack itemStackFromJson(JsonObject pStackObject) {
        return net.minecraftforge.common.crafting.CraftingHelper.getItemStack(pStackObject, true, true);
    }

    public static class Serializer implements RecipeSerializer<GlassblowingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        @SuppressWarnings("unused")
        public static final ResourceLocation ID = new ResourceLocation(MODID, "glassblowing");

        @Override
        public @NotNull GlassblowingRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject pSerializedRecipe) {
            String group = GsonHelper.getAsString(pSerializedRecipe, "group", "");
            Map<String, Ingredient> map = GlassblowingRecipe.keyFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "key"));
            String[] astring = GlassblowingRecipe.shrink(GlassblowingRecipe.patternFromJson(GsonHelper.getAsJsonArray(pSerializedRecipe, "pattern")));
            int i = astring[0].length();
            int j = astring.length;
            NonNullList<Ingredient> ingredients = GlassblowingRecipe.dissolvePattern(astring, map, i, j);
            ItemStack result = GlassblowingRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
            return new GlassblowingRecipe(id, i, j, group, result, ingredients);
        }

        public GlassblowingRecipe fromNetwork(@NotNull ResourceLocation id, FriendlyByteBuf pBuffer) {
            int i = pBuffer.readVarInt();
            int j = pBuffer.readVarInt();
            String group = pBuffer.readUtf();
            NonNullList<Ingredient> ingredients = NonNullList.withSize(i * j, Ingredient.EMPTY);

            //noinspection Java8ListReplaceAll
            for (int k = 0; k < ingredients.size(); ++k) {
                ingredients.set(k, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack result = pBuffer.readItem();
            return new GlassblowingRecipe(id, i, j, group, result, ingredients);
        }

        public void toNetwork(FriendlyByteBuf pBuffer, GlassblowingRecipe pRecipe) {
            pBuffer.writeVarInt(pRecipe.width);
            pBuffer.writeVarInt(pRecipe.height);
            pBuffer.writeUtf(pRecipe.group);

            for (Ingredient ingredient : pRecipe.recipeItems) {
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItem(pRecipe.result);
        }
    }
}