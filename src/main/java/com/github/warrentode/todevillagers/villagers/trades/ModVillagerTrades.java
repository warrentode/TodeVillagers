package com.github.warrentode.todevillagers.villagers.trades;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.villagers.ModVillagers;
import com.github.warrentode.todevillagers.villagers.trades.trade_types.ItemForItemTrade;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModVillagerTrades {
    static RandomSource source = RandomSource.create();

    public static final int COMMON_USES = 16;
    public static final int RARE_USES = 3;
    public static final int BASE_XP = 5;
    public static final float COMMON_MULTIPLIER = 0.05F;
    public static final float RARE_MULTIPLIER = 0.2F;

    static int novice = 1;
    static int apprentice = 2;
    static int journeyman = 3;
    static int expert = 4;
    static int master = 5;

    static ArrayList<Item> MUSIC_DISC_LIST = Lists.newArrayList(ModItems.CHAKRA_DREAM_MUSIC_DISC.get(), Items.MUSIC_DISC_5, Items.MUSIC_DISC_11, Items.MUSIC_DISC_13, Items.MUSIC_DISC_BLOCKS, Items.MUSIC_DISC_CAT, Items.MUSIC_DISC_CHIRP, Items.MUSIC_DISC_FAR, Items.MUSIC_DISC_MALL, Items.MUSIC_DISC_MELLOHI, Items.MUSIC_DISC_OTHERSIDE, Items.MUSIC_DISC_PIGSTEP, Items.MUSIC_DISC_STAL, Items.MUSIC_DISC_STRAD, Items.MUSIC_DISC_WAIT, Items.MUSIC_DISC_WARD);
    static ArrayList<Item> GLASS_BLOCK_LIST = Lists.newArrayList(ModBlocks.GLOWING_GLASS.get().asItem(), ModBlocks.REINFORCED_GLASS.get().asItem(), ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem(), ModBlocks.SHIFTING_GLASS.get().asItem(), Blocks.GLASS.asItem(), Blocks.GRAY_STAINED_GLASS.asItem(), Blocks.GREEN_STAINED_GLASS.asItem(), Blocks.BLACK_STAINED_GLASS.asItem(), Blocks.BLUE_STAINED_GLASS.asItem(), Blocks.BROWN_STAINED_GLASS.asItem(), Blocks.CYAN_STAINED_GLASS.asItem(), Blocks.LIGHT_BLUE_STAINED_GLASS.asItem(), Blocks.LIGHT_GRAY_STAINED_GLASS.asItem(), Blocks.LIME_STAINED_GLASS.asItem(), Blocks.MAGENTA_STAINED_GLASS.asItem(), Blocks.ORANGE_STAINED_GLASS.asItem(), Blocks.PINK_STAINED_GLASS.asItem(), Blocks.PURPLE_STAINED_GLASS.asItem(), Blocks.RED_STAINED_GLASS.asItem(), Blocks.TINTED_GLASS.asItem(), Blocks.WHITE_STAINED_GLASS.asItem(), Blocks.YELLOW_STAINED_GLASS.asItem());
    static ArrayList<Item> GLASS_PANE_LIST = Lists.newArrayList(ModBlocks.GLOWING_GLASS_PANE.get().asItem(), ModBlocks.REINFORCED_GLASS_PANE.get().asItem(), ModBlocks.SHIFTING_GLASS_PANE.get().asItem(), Blocks.GLASS_PANE.asItem(), Blocks.GRAY_STAINED_GLASS_PANE.asItem(), Blocks.GREEN_STAINED_GLASS_PANE.asItem(), Blocks.BLACK_STAINED_GLASS_PANE.asItem(), Blocks.BLUE_STAINED_GLASS_PANE.asItem(), Blocks.BROWN_STAINED_GLASS_PANE.asItem(), Blocks.CYAN_STAINED_GLASS_PANE.asItem(), Blocks.LIGHT_BLUE_STAINED_GLASS_PANE.asItem(), Blocks.LIGHT_GRAY_STAINED_GLASS_PANE.asItem(), Blocks.LIME_STAINED_GLASS_PANE.asItem(), Blocks.MAGENTA_STAINED_GLASS_PANE.asItem(), Blocks.ORANGE_STAINED_GLASS_PANE.asItem(), Blocks.PINK_STAINED_GLASS_PANE.asItem(), Blocks.PURPLE_STAINED_GLASS_PANE.asItem(), Blocks.RED_STAINED_GLASS_PANE.asItem(), ModBlocks.TINTED_GLASS_PANE.get().asItem(), Blocks.WHITE_STAINED_GLASS_PANE.asItem(), Blocks.YELLOW_STAINED_GLASS_PANE.asItem());
    static ArrayList<Item> GLASSBLOWING_TOOL_LIST = Lists.newArrayList(ModItems.GLASSBLOWER_SHEARS.get(), ModItems.GLASSBLOWING_PIPE.get(), ModItems.MARVER.get());
    static ArrayList<Item> CORAL_BLOCK_LIST = Lists.newArrayList(Items.TUBE_CORAL_BLOCK, Items.HORN_CORAL_BLOCK, Items.FIRE_CORAL_BLOCK, Items.BUBBLE_CORAL_BLOCK, Items.BRAIN_CORAL_BLOCK);
    static ArrayList<Item> DYE_LIST = Lists.newArrayList(Items.CYAN_DYE, Items.BROWN_DYE, Items.LIME_DYE, Items.ORANGE_DYE, Items.LIGHT_BLUE_DYE, Items.PURPLE_DYE, Items.GRAY_DYE, Items.YELLOW_DYE, Items.MAGENTA_DYE, Items.LIGHT_GRAY_DYE, Items.GREEN_DYE, Items.BLACK_DYE, Items.PINK_DYE, Items.BLUE_DYE, Items.WHITE_DYE, Items.RED_DYE);
    static ArrayList<Item> SEEDS_LIST = Lists.newArrayList(Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.WHEAT_SEEDS);
    static ArrayList<Item> PLANT_LIST = Lists.newArrayList(Items.RED_MUSHROOM, Items.BROWN_MUSHROOM, Items.VINE, Items.LILY_OF_THE_VALLEY, Items.CORNFLOWER, Items.OXEYE_DAISY, Items.PINK_TULIP, Items.WHITE_TULIP, Items.ORANGE_TULIP, Items.RED_TULIP, Items.AZURE_BLUET, Items.ALLIUM, Items.BLUE_ORCHID, Items.POPPY, Items.DANDELION, Items.SUGAR_CANE, Items.FERN);
    static ArrayList<Item> SAPLING_LIST = Lists.newArrayList(Items.MANGROVE_PROPAGULE, Items.SPRUCE_SAPLING, Items.OAK_SAPLING, Items.JUNGLE_SAPLING, Items.DARK_OAK_SAPLING, Items.BIRCH_SAPLING, Items.ACACIA_SAPLING);
    static ArrayList<Item> TERRACOTTA_LIST = Lists.newArrayList(Items.BLACK_TERRACOTTA, Items.BLUE_TERRACOTTA, Items.BROWN_TERRACOTTA, Items.CYAN_TERRACOTTA, Items.GRAY_TERRACOTTA, Items.GREEN_TERRACOTTA, Items.LIGHT_BLUE_TERRACOTTA, Items.LIGHT_GRAY_TERRACOTTA, Items.LIME_TERRACOTTA, Items.MAGENTA_TERRACOTTA, Items.ORANGE_TERRACOTTA, Items.PINK_TERRACOTTA, Items.PURPLE_TERRACOTTA, Items.RED_TERRACOTTA, Items.WHITE_TERRACOTTA, Items.YELLOW_TERRACOTTA);
    static ArrayList<Item> GLAZED_TERRACOTTA_LIST = Lists.newArrayList(Items.BLACK_GLAZED_TERRACOTTA, Items.BLUE_GLAZED_TERRACOTTA, Items.BROWN_GLAZED_TERRACOTTA, Items.CYAN_GLAZED_TERRACOTTA, Items.GRAY_GLAZED_TERRACOTTA, Items.GREEN_GLAZED_TERRACOTTA, Items.LIGHT_BLUE_GLAZED_TERRACOTTA, Items.LIGHT_GRAY_GLAZED_TERRACOTTA, Items.LIME_GLAZED_TERRACOTTA, Items.MAGENTA_GLAZED_TERRACOTTA, Items.ORANGE_GLAZED_TERRACOTTA, Items.PINK_GLAZED_TERRACOTTA, Items.PURPLE_GLAZED_TERRACOTTA, Items.RED_GLAZED_TERRACOTTA, Items.WHITE_GLAZED_TERRACOTTA, Items.YELLOW_GLAZED_TERRACOTTA);

    public static Item getRandomItemFromList(@NotNull List<Item> list) {
        return list.get(source.nextInt(list.size()));
    }

    @Mod.EventBusSubscriber(modid = MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
                trades.get(novice).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.REDSTONE.getDefaultInstance(), 2,
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        COMMON_USES,
                                        BASE_XP * novice,
                                        COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.DISC_FRAGMENT_5.getDefaultInstance(), 1,
                                        Items.EMERALD.getDefaultInstance(), 3,
                                        RARE_USES,
                                        BASE_XP * novice,
                                        RARE_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        Items.AMETHYST_SHARD.getDefaultInstance(), 4,
                                        RARE_USES,
                                        BASE_XP * novice,
                                        RARE_MULTIPLIER
                                )
                        )
                );
                trades.get(apprentice).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * apprentice,
                                        RARE_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * apprentice,
                                        RARE_MULTIPLIER
                                )
                        )
                );
                trades.get(journeyman).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * journeyman,
                                        RARE_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * journeyman,
                                        RARE_MULTIPLIER
                                )
                        )
                );
                trades.get(expert).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * expert,
                                        RARE_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * expert,
                                        RARE_MULTIPLIER
                                )
                        )
                );
                trades.get(master).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * master,
                                        RARE_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 32,
                                        getRandomItemFromList(MUSIC_DISC_LIST).getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * master,
                                        RARE_MULTIPLIER
                                )
                        )
                );
            }
            if (event.getType() == ModVillagers.GLASSBLOWER.get()) {
                trades.get(novice).addAll(List.of(
                                new ItemForItemTrade(
                                        ModItems.CRUSHED_GLASS.get().getDefaultInstance(), 4,
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        COMMON_USES,
                                        BASE_XP * novice,
                                        COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.SAND.getDefaultInstance(), 8,
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * novice,
                                        RARE_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.COAL.getDefaultInstance(), 10,
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        RARE_USES,
                                        BASE_XP * novice,
                                        RARE_MULTIPLIER
                                )
                        )
                );
                trades.get(apprentice).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLASS_BLOCK_LIST).getDefaultInstance(), 4,
                                        COMMON_USES,
                                        BASE_XP * apprentice,
                                        COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLASS_PANE_LIST).getDefaultInstance(), 11,
                                        COMMON_USES,
                                        BASE_XP * apprentice,
                                        COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(journeyman).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 6,
                                        getRandomItemFromList(GLASSBLOWING_TOOL_LIST).getDefaultInstance(), 1,
                                        COMMON_USES,
                                        BASE_XP * journeyman,
                                        COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        Items.GLASS_BOTTLE.getDefaultInstance(), 9,
                                        RARE_USES,
                                        BASE_XP * journeyman,
                                        RARE_MULTIPLIER
                                )
                        )
                );
                trades.get(expert).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLASS_BLOCK_LIST).getDefaultInstance(), 4,
                                        COMMON_USES,
                                        BASE_XP * expert,
                                        COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLASS_BLOCK_LIST).getDefaultInstance(), 4,
                                        COMMON_USES,
                                        BASE_XP * expert,
                                        COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(master).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLASS_BLOCK_LIST).getDefaultInstance(), 4,
                                        COMMON_USES,
                                        BASE_XP * master,
                                        COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLASS_BLOCK_LIST).getDefaultInstance(), 4,
                                        COMMON_USES,
                                        BASE_XP * master,
                                        COMMON_MULTIPLIER
                                )
                        )
                );
            }
            if (event.getType() == ModVillagers.RETIRED_TRADER.get()) {
                trades.get(novice).addAll(List.of(
                                new VillagerTrades.ItemsForEmeralds(
                                        getRandomItemFromList(SAPLING_LIST).getDefaultInstance(),
                                        5, 1,
                                        COMMON_USES, BASE_XP * novice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.LILY_PAD.getDefaultInstance(),
                                        1, 2,
                                        RARE_USES, BASE_XP * novice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        getRandomItemFromList(PLANT_LIST).getDefaultInstance(),
                                        1, 1,
                                        COMMON_USES, BASE_XP * novice, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(apprentice).addAll(List.of(
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.SEA_PICKLE.getDefaultInstance(),
                                        2, 1,
                                        RARE_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.SLIME_BALL.getDefaultInstance(),
                                        4, 1,
                                        RARE_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.GLOWSTONE.getDefaultInstance(),
                                        2, 1,
                                        RARE_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.NAUTILUS_SHELL.getDefaultInstance(),
                                        5, 1,
                                        RARE_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.PUMPKIN.getDefaultInstance(),
                                        1, 1,
                                        RARE_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.KELP.getDefaultInstance(),
                                        3, 1,
                                        COMMON_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.CACTUS.getDefaultInstance(),
                                        3, 1,
                                        COMMON_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(journeyman).addAll(List.of(
                                new VillagerTrades.ItemsForEmeralds(
                                        getRandomItemFromList(SEEDS_LIST).getDefaultInstance(),
                                        1, 1,
                                        COMMON_USES, BASE_XP * journeyman, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        getRandomItemFromList(CORAL_BLOCK_LIST).getDefaultInstance(),
                                        3, 1,
                                        COMMON_USES, BASE_XP * journeyman, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        getRandomItemFromList(DYE_LIST).getDefaultInstance(),
                                        1, 3,
                                        COMMON_USES, BASE_XP * journeyman, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(expert).addAll(List.of(
                                new VillagerTrades.ItemsForEmeralds(Items.SMALL_DRIPLEAF.getDefaultInstance(),
                                        1, 2,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(Items.SAND.getDefaultInstance(),
                                        1, 8,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(Items.RED_SAND.getDefaultInstance(),
                                        1, 4,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(Items.POINTED_DRIPSTONE.getDefaultInstance(),
                                        1, 2,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(Items.ROOTED_DIRT.getDefaultInstance(),
                                        1, 2,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(Items.MOSS_BLOCK.getDefaultInstance(),
                                        1, 2,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(master).addAll(List.of(
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.BLUE_ICE.getDefaultInstance(),
                                        6, 1,
                                        RARE_USES, BASE_XP * master, RARE_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.GUNPOWDER.getDefaultInstance(),
                                        1, 1,
                                        RARE_USES, BASE_XP * master, RARE_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.PODZOL.getDefaultInstance(),
                                        3, 3,
                                        RARE_USES, BASE_XP * master, RARE_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.TROPICAL_FISH_BUCKET.getDefaultInstance(),
                                        5, 1,
                                        RARE_USES, BASE_XP * master, RARE_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.PUFFERFISH_BUCKET.getDefaultInstance(),
                                        5, 1,
                                        RARE_USES, BASE_XP * master, RARE_MULTIPLIER
                                ),
                                new VillagerTrades.ItemsForEmeralds(
                                        Items.PACKED_ICE.getDefaultInstance(),
                                        3, 1,
                                        RARE_USES, BASE_XP * master, RARE_MULTIPLIER
                                )
                        )
                );
            }
            if (event.getType() == ModVillagers.POTTER.get()) {
                trades.get(novice).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.CLAY_BALL.getDefaultInstance(), 4,
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * novice, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.CLAY.getDefaultInstance(), 1,
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * novice, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        Items.BRICK.getDefaultInstance(), 4,
                                        COMMON_USES, BASE_XP * novice, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(apprentice).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        Items.FLOWER_POT.getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        Items.BRICKS.getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        Items.TERRACOTTA.getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * apprentice, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(journeyman).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(TERRACOTTA_LIST).getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * journeyman, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(TERRACOTTA_LIST).getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * journeyman, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(expert).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLAZED_TERRACOTTA_LIST).getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLAZED_TERRACOTTA_LIST).getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * expert, COMMON_MULTIPLIER
                                )
                        )
                );
                trades.get(master).addAll(List.of(
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(TERRACOTTA_LIST).getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * master, COMMON_MULTIPLIER
                                ),
                                new ItemForItemTrade(
                                        Items.EMERALD.getDefaultInstance(), 1,
                                        getRandomItemFromList(GLAZED_TERRACOTTA_LIST).getDefaultInstance(), 1,
                                        COMMON_USES, BASE_XP * master, COMMON_MULTIPLIER
                                )
                        )
                );
            }
        }
    }
}