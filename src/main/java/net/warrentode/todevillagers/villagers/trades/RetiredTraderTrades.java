package net.warrentode.todevillagers.villagers.trades;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todevillagers.villagers.ModVillagers;

import java.util.List;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class RetiredTraderTrades {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        // level 1 trades
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.SEA_PICKLE, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.KELP, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BROWN_MUSHROOM, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.RED_MUSHROOM, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.LILY_PAD, 2);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.SMALL_DRIPLEAF, 2);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.FERN, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.VINE, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        // level 2 trades
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.WHEAT_SEEDS, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BEETROOT_SEEDS, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PUMPKIN_SEEDS, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MELON_SEEDS, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.SUGAR_CANE, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PUMPKIN, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,4,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.CACTUS, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.ACACIA_SAPLING, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BIRCH_SAPLING, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.DARK_OAK_SAPLING, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.JUNGLE_SAPLING, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.OAK_SAPLING, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.SPRUCE_SAPLING, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MANGROVE_PROPAGULE, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,8,1,0.02F));
        }
        // level 3 trades
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BRAIN_CORAL_BLOCK, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BUBBLE_CORAL_BLOCK, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.FIRE_CORAL_BLOCK, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.HORN_CORAL_BLOCK, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.TUBE_CORAL_BLOCK, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.SAND, 8);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.RED_SAND, 4);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,6,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.POINTED_DRIPSTONE, 2);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.ROOTED_DIRT, 2);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MOSS_BLOCK, 2);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,5,1,0.02F));
        }
        // level 4 trades
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.DANDELION, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.POPPY, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.ALLIUM, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.AZURE_BLUET, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.RED_TULIP, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.ORANGE_TULIP, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.WHITE_TULIP, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PINK_TULIP, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.OXEYE_DAISY, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.CORNFLOWER, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BLUE_ORCHID, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,8,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.LILY_OF_THE_VALLEY, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,7,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.RED_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.WHITE_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BLUE_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PINK_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BLACK_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GREEN_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.LIGHT_GRAY_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MAGENTA_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.YELLOW_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GRAY_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PURPLE_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.LIGHT_BLUE_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.LIME_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.ORANGE_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BROWN_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.CYAN_DYE, 3);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,1,0.02F));
        }
        // level 5 trades
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GUNPOWDER, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.NAUTILUS_SHELL, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.SLIME_BALL, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,5,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PODZOL, 3);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,6,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.TROPICAL_FISH_BUCKET, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,4,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PUFFERFISH_BUCKET, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,4,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.PACKED_ICE, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    stack,6,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.BLUE_ICE, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    stack,6,1,0.02F));
        }
        if(event.getType() == ModVillagers.RETIRED_TRADER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GUNPOWDER, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,8,1,0.02F));
        }
    }
}
