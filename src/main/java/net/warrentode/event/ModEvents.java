package net.warrentode.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todevillagers.TodeVillagers;
import net.warrentode.todevillagers.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = TodeVillagers.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        // vanilla supply of trade goods are:
        // common items at 16 max
        // uncommon items at 3 max
        // and the standard default is 12 max

        // default XP given at level 1 for selling an item is 1
        // default XP given at level 1 for buying an item is 2
        // default XP given at level 2 for selling an item is 5
        // default XP given at level 2 for buying an item is 10
        // default XP given at level 3 for selling an item is 10
        // default XP given at level 3 for buying an item is 20
        // default XP given at level 4 for selling an item is 15
        // default XP given at level 4 for selling an item is 30
        // default XP given at level 5 for selling/buying an item is 30

        // this is what is given to the villager at time of sale

        // villagers restock twice a day by working at their poi_type block
        // Farmers have a secondary poi_type, the farmland block the also work at in both Java and Bedrock
        // open the library source code for VillagerProfession.java and read the registry line for the Farmer to see what I'm saying
        // Librarians have the bookshelves as a secondary poi_type they work at in Bedrock only
        // you can assign your custom villagers to work at secondary poi_types to give them variety
        // visit https://minecraft.fandom.com/wiki/Villager#Schedules to learn more about their work schedule and the AI behavior pattern around this

        // and honestly, while knowing all this does help me to run and manage a homechool world map for my boys,
        // it doesn't seem to help me much with making a mod just yet.
        // I just hope that by sharing this information it will help someone else plan out their mod

        // Why am I giving a DJ this specific pair of trades to offer at level one?
        // my reasoning is that typically a player will only want to buy one copy of a music disc from the villager
        // and I also feel that by default all of these discs should be uncommon level stock
        // this means that this profession is going to level up very slowly at best
        // so other than music discs, what else would a DJ buy and sell?
        // redstone for noteblocks makes sense to me
        // amethyst shards for breeding Allays that like to dance at Jukeboxes also make sense to me.
        // I could have him offer both a buy and sell of each but this could be easily exploited in a trade swap loop to level him up
        // part of me doesn't really care about that, but I want to make sure this profession is functional and balanced for servers if I intend to share it
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            //price - so this is what you give to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.REDSTONE, 2),
                    stack,12,2,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.AMETHYST_SHARD, 4);
            int villagerLevel = 1;
            //price - so this is what you give to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,2,0.02F));
        }

    }

}
