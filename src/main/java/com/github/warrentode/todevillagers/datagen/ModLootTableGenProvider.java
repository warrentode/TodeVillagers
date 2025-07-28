package com.github.warrentode.todevillagers.datagen;

import com.github.warrentode.todevillagers.datagen.loot_tables.ModGiftLootGen;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class ModLootTableGenProvider {
    @Contract("_ -> new")
    public static @NotNull LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModGiftLootGen::new, LootContextParamSets.GIFT)
        ));
    }
}