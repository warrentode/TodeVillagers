package com.github.warrentode.todevillagers.villagers.trades.trade_types;

// MIT License Copyright (c) 2023 Warren Tode

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemForItemTrade implements VillagerTrades.ItemListing {
    private final ItemStack requestItem;
    private final int requestItemCount;
    private final ItemStack offerItem;
    private final int offerItemCount;
    private final int maxUses;
    private final int xpValue;
    private final float priceMultiplier;

    public ItemForItemTrade(ItemStack requestItem, int requestItemCount, ItemStack offerItem, int offerItemCount, int maxUses, int xpValue, float priceMultiplier) {
        this.requestItem = requestItem;
        this.requestItemCount = requestItemCount;
        this.offerItem = offerItem;
        this.offerItemCount = offerItemCount;
        this.maxUses = maxUses;
        this.xpValue = xpValue;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource source) {
        ItemStack requestStack = new ItemStack(this.requestItem.getItem(), this.requestItemCount);
        ItemStack offerStack = new ItemStack(this.offerItem.getItem(), this.offerItemCount);
        return new MerchantOffer(requestStack, offerStack, this.maxUses, this.xpValue, this.priceMultiplier);
    }
}