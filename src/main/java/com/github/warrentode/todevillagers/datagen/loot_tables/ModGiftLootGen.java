package com.github.warrentode.todevillagers.datagen.loot_tables;

import com.github.warrentode.todevillagers.utils.ModTags;
import com.github.warrentode.todevillagers.villagers.ModGiftLootTables;
import net.minecraft.data.loot.packs.VanillaGiftLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ModGiftLootGen extends VanillaGiftLoot {
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(ModGiftLootTables.BAKER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(TagEntry.expandTag(ModTags.Items.COOKIES))
                                        .add(TagEntry.expandTag(ModTags.Items.CAKES))
                                        .add(TagEntry.expandTag(ModTags.Items.PIES))
                        )
        );
        consumer.accept(ModGiftLootTables.RETIRED_TRADER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(TagEntry.expandTag(ItemTags.FLOWERS))
                                        .add(TagEntry.expandTag(ItemTags.CANDLES))
                                        .add(TagEntry.expandTag(ItemTags.COALS))
                        )
        );
        consumer.accept(ModGiftLootTables.GLASSBLOWER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(TagEntry.expandTag(ModTags.Items.GLASS))
                                        .add(TagEntry.expandTag(ModTags.Items.SAND))
                        )
        );
        consumer.accept(ModGiftLootTables.DISC_JOCKEY_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(50))
                                        .add(TagEntry.expandTag(ItemTags.MUSIC_DISCS).setWeight(1))
                        )
        );
        consumer.accept(ModGiftLootTables.POTTER_GIFT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(LootItem.lootTableItem(Items.CLAY_BALL))
                        )
        );
    }
}