package com.github.warrentode.todevillagers.utils;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> TODEVILLAGERS_TAB = CREATIVE_TABS.register("todevillagers_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.todevillagers_tab"))
                    .icon(() -> new ItemStack(ModBlocks.WHEEL_CART.get()))
                    .displayItems((parameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))
                    .build());
}