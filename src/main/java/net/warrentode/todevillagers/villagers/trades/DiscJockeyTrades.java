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
public class DiscJockeyTrades {
    // I messed around quite a bit trying to figure out the best way to do this, but I guess I don't understand Java
    // well enough yet to make the trades work with an Array List to ensure a fixed pool the game is choosing from at each
    // trade level - what I'd like to have for example is a "sell list" and a "buy list" so there is one of each at every level
    // instead, I'm stuck with using this method since I can make it work, and it's just a grab bag of everything you put in there
    // I make some progress, but then I get stuck - perhaps I should get in the habit of saving those "stuck" files in "borked" branches
    // for other people to look at so that maybe someone can tell me where I am going wrong with them

    // I also decided to separate the villager trades into their own files from the main event file to prevent it from
    // becoming an ultra mess to read and keep track of
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        // level 1 trades
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.REDSTONE, 2),
                    stack,12,2,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 3);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.DISC_FRAGMENT_5, 1),
                    stack,12,2,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.AMETHYST_SHARD, 4);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,2,0.02F));
        }
        // level 2 trades
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_CHIRP, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,5,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_FAR, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,5,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_WAIT, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,5,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_MELLOHI, 1);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,5,0.02F));
        }
        // level 3 trades
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_MALL, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,10,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_STAL, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,10,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_13, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,10,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_WARD, 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,10,0.02F));
        }
        // level 4 trades
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_CAT, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,15,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_BLOCKS, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,15,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_PIGSTEP, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,15,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_OTHERSIDE, 1);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,15,0.02F));
        }
        // level 5 trades
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_STRAD, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,30,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_5, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,30,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.MUSIC_DISC_11, 1);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    stack,1,30,0.02F));
        }
    }
}
