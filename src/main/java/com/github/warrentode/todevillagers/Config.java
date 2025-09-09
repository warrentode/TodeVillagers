package com.github.warrentode.todevillagers;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue BAKER_HOUSE_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue DISC_JOCKEY_HOUSE_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue GLASSBLOWER_HOUSE_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue POTTER_HOUSE_SPAWN_WEIGHT;
    public static final ForgeConfigSpec.IntValue RETIRED_TRADER_HOUSE_SPAWN_WEIGHT;

    static {
        // Villager House spawn weights
        BUILDER.push("Villager House Spawn Weights");
        BAKER_HOUSE_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance in villages")
                .defineInRange("baker_house_spawn_weight", 3, 1, Integer.MAX_VALUE);
        DISC_JOCKEY_HOUSE_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance in villages")
                .defineInRange("disc_jockey_house_spawn_weight", 1, 1, Integer.MAX_VALUE);
        GLASSBLOWER_HOUSE_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance in villages")
                .defineInRange("glassblower_house_spawn_weight", 2, 1, Integer.MAX_VALUE);
        POTTER_HOUSE_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance in villages")
                .defineInRange("potter_house_spawn_weight", 2, 1, Integer.MAX_VALUE);
        RETIRED_TRADER_HOUSE_SPAWN_WEIGHT = BUILDER
                .comment("Frequency chance in villages")
                .defineInRange("retired_trader_house_spawn_weight", 1, 1, Integer.MAX_VALUE);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    public static int getBakerSpawnWeight() {
        if (Objects.equals(BAKER_HOUSE_SPAWN_WEIGHT.get(), BAKER_HOUSE_SPAWN_WEIGHT.getDefault())) {
            return BAKER_HOUSE_SPAWN_WEIGHT.getDefault();
        }
        else {
            return BAKER_HOUSE_SPAWN_WEIGHT.get();
        }
    }

    public static int getDiscJockeySpawnWeight() {
        if (Objects.equals(DISC_JOCKEY_HOUSE_SPAWN_WEIGHT.get(), DISC_JOCKEY_HOUSE_SPAWN_WEIGHT.getDefault())) {
            return DISC_JOCKEY_HOUSE_SPAWN_WEIGHT.getDefault();
        }
        else {
            return DISC_JOCKEY_HOUSE_SPAWN_WEIGHT.get();
        }
    }

    public static int getGlassblowerSpawnWeight() {
        if (Objects.equals(GLASSBLOWER_HOUSE_SPAWN_WEIGHT.get(), GLASSBLOWER_HOUSE_SPAWN_WEIGHT.getDefault())) {
            return GLASSBLOWER_HOUSE_SPAWN_WEIGHT.getDefault();
        }
        else {
            return GLASSBLOWER_HOUSE_SPAWN_WEIGHT.get();
        }
    }

    public static int getPotterSpawnWeight() {
        if (Objects.equals(POTTER_HOUSE_SPAWN_WEIGHT.get(), POTTER_HOUSE_SPAWN_WEIGHT.getDefault())) {
            return POTTER_HOUSE_SPAWN_WEIGHT.getDefault();
        }
        else {
            return POTTER_HOUSE_SPAWN_WEIGHT.get();
        }
    }

    public static int getRetiredTraderSpawnWeight() {
        if (Objects.equals(RETIRED_TRADER_HOUSE_SPAWN_WEIGHT.get(), RETIRED_TRADER_HOUSE_SPAWN_WEIGHT.getDefault())) {
            return RETIRED_TRADER_HOUSE_SPAWN_WEIGHT.getDefault();
        }
        else {
            return RETIRED_TRADER_HOUSE_SPAWN_WEIGHT.get();
        }
    }
}