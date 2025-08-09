package com.github.warrentode.todevillagers.villagers;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModGiftLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();

    public static final ResourceLocation RETIRED_TRADER_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/retired_trader_gift");
    public static final ResourceLocation GLASSBLOWER_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/glassblower_gift");
    public static final ResourceLocation DISC_JOCKEY_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/disc_jockey_gift");
    public static final ResourceLocation POTTER_GIFT = register(MODID + ":" + "gameplay/hero_of_the_village/potter_gift");

    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        }
        else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}