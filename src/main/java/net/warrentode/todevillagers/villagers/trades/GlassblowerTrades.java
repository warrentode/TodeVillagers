package net.warrentode.todevillagers.villagers.trades;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.warrentode.todevillagers.blocks.ModBlocks;
import net.warrentode.todevillagers.items.ModItems;
import net.warrentode.todevillagers.villagers.ModVillagers;

import java.util.List;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class GlassblowerTrades {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        // level 1 trades
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CRUSHED_GLASS.get(), 4),
                    stack,12,2,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.SAND, 8),
                    stack,12,2,0.02F));
        }
        if(event.getType() == ModVillagers.DISC_JOCKEY.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.COAL, 10),
                    stack,12,2,0.02F));
        }
        // level 2 trades
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GLASS, 4);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,5,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GLASS_PANE, 11);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,5,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(Items.GLASS_BOTTLE, 9);
            int villagerLevel = 2;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,12,5,0.02F));
        }
        // level 3 trades
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModItems.MARVER.get(), 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    stack,12,10,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModItems.GLASSBLOWING_PIPE.get(), 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    stack,12,10,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModItems.GLASSBLOWER_SHEARS.get(), 1);
            int villagerLevel = 3;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    stack,12,10,0.02F));
        }
        // level 4 trades
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModBlocks.REINFORCED_GLASS.get(), 4);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    stack,12,15,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModBlocks.GLOWING_GLASS.get(), 4);
            int villagerLevel = 4;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    stack,12,15,0.02F));
        }
        // level 5 trades
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModBlocks.SHIFTING_GLASS.get(), 2);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    stack,12,30,0.02F));
        }
        if(event.getType() == ModVillagers.GLASSBLOWER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            //item for sale
            ItemStack stack = new ItemStack(ModBlocks.REDSTONE_INFUSED_GLASS.get(), 2);
            int villagerLevel = 5;
            //price - this is what is given to the villager
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    stack,12,30,0.02F));
        }
    }
}