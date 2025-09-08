package com.github.warrentode.todevillagers.utils;

/*
 * Copyright (c) 2024 Warren Tode
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the “Software”), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class IngredientRemainderUtil {

    /**
     * modified from the FarmersDelight <a href="https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/common/block/entity/CookingPotBlockEntity.java">CookingPotBlockEntity</a>
     * into a utility class and adapted to include item tags for datapack customization -
     * anyone may copy and edit/adapt this class in its entirety to use in their mod to meet
     * their mod's unique crafting needs, it's not required, but it would be nice if this class remains
     * open source and under an MIT license to be shared with others to make coding for
     * crafting remainders easier to manage and improve cross compatibilty as a whole within the
     * modding community - this is really my only desired goal in setting it up this way and I'm hoping
     * it's the right way to go about it since I just want it to be availble to anyone to learn from and use
     * as freely as possible given that it's just a utility class
     **/

    // Private constructor to prevent instantiation
    private IngredientRemainderUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Maps for storing item remainders and tag remainders
    public static final Map<Item, Item> INGREDIENT_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_BUCKET_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_BOWL_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_BOTTLE_REMAINDER_OVERRIDES = new HashMap<>();
    public static final Map<TagKey<Item>, Item> TAG_MATCHING_ITEM_REMAINDER_OVERRIDES = new HashMap<>();

    static {
        // default remainder map
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.POWDER_SNOW_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.AXOLOTL_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.COD_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.PUFFERFISH_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.SALMON_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.TROPICAL_FISH_BUCKET, Items.BUCKET);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.SUSPICIOUS_STEW, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.MUSHROOM_STEW, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.RABBIT_STEW, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.BEETROOT_SOUP, Items.BOWL);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.POTION, Items.GLASS_BOTTLE);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.SPLASH_POTION, Items.GLASS_BOTTLE);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.LINGERING_POTION, Items.GLASS_BOTTLE);
        INGREDIENT_REMAINDER_OVERRIDES.put(Items.EXPERIENCE_BOTTLE, Items.GLASS_BOTTLE);
        // remainder tag maps
        TAG_BUCKET_REMAINDER_OVERRIDES.put(ModTags.Items.BUCKET_REMAINDERS, Items.BUCKET);
        TAG_BOWL_REMAINDER_OVERRIDES.put(ModTags.Items.BOWL_REMAINDERS, Items.BOWL);
        TAG_BOTTLE_REMAINDER_OVERRIDES.put(ModTags.Items.BOTTLE_REMAINDERS, Items.GLASS_BOTTLE);
        /* this tag is for items not already addressed above, the null is there
         * in order for items to be properly matched in the getRemainder method */
        TAG_MATCHING_ITEM_REMAINDER_OVERRIDES.put(ModTags.Items.MATCHING_ITEM_REMAINDERS, null);
    }

    // Utility method to get the remainder stack and handle durability if needed
    public static @Nullable ItemStack getRemainder(@NotNull ItemStack stack) {
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        }

        Item item = stack.getItem();

        // Vanilla remainder
        if (stack.hasCraftingRemainingItem()) {
            return stack.getCraftingRemainingItem();
        }

        // Explicit item overrides
        if (INGREDIENT_REMAINDER_OVERRIDES.containsKey(item)) {
            return new ItemStack(INGREDIENT_REMAINDER_OVERRIDES.get(item));
        }

        // Tag-based overrides
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_BUCKET_REMAINDER_OVERRIDES.entrySet()) {
            if (stack.is(entry.getKey())) return new ItemStack(entry.getValue());
        }
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_BOWL_REMAINDER_OVERRIDES.entrySet()) {
            if (stack.is(entry.getKey())) return new ItemStack(entry.getValue());
        }
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_BOTTLE_REMAINDER_OVERRIDES.entrySet()) {
            if (stack.is(entry.getKey())) return new ItemStack(entry.getValue());
        }
        for (Map.Entry<TagKey<Item>, Item> entry : TAG_MATCHING_ITEM_REMAINDER_OVERRIDES.entrySet()) {
            if (stack.is(entry.getKey())) {
                ItemStack copy = stack.copy();
                copy.setCount(1);
                if (copy.isDamageableItem() && (copy.getDamageValue() >= copy.getMaxDamage() - 1)) {
                    // item breaks
                    return ItemStack.EMPTY;
                }
                else if (copy.isDamageableItem()) {
                    copy.hurt(1, RandomSource.create(), null);
                    return copy;
                }
                else {
                    return copy;
                }
            }
        }

        return ItemStack.EMPTY;
    }
}