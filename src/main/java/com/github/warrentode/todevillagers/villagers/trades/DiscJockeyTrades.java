package com.github.warrentode.todevillagers.villagers.trades;

import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.villagers.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class DiscJockeyTrades {
    @SubscribeEvent
    public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
        // level 1 trades
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.REDSTONE, 2),
                    stack, 12, 2, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 3);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DISC_FRAGMENT_5, 1),
                    stack, 12, 2, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.AMETHYST_SHARD, 4);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack, 12, 2, 0.02F));
        }
        // level 2 trades
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_CHIRP, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 5, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_FAR, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 5, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_WAIT, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 5, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_MELLOHI, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 5, 0.02F));
        }
        // level 3 trades
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_MALL, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 10, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_STAL, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 10, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_13, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 10, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_WARD, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 10, 0.02F));
        }
        // level 4 trades
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_CAT, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 15, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_BLOCKS, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 15, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_PIGSTEP, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 15, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_OTHERSIDE, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 15, 0.02F));
        }
        // level 5 trades
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_STRAD, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 30, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_5, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 30, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_11, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 30, 0.02F));
        }
        if (event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModItems.CHAKRA_DREAM_MUSIC_DISC.get(), 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack, 1, 30, 0.02F));
        }
    }
}