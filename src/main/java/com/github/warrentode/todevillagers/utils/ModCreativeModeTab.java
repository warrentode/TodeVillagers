package com.github.warrentode.todevillagers.utils;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> TODEVILLAGERS_TAB = CREATIVE_TABS.register("todevillagers_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.todevillagers_tab"))
                    .icon(() -> new ItemStack(ModBlocks.WHEEL_CART.get()))
                    .displayItems((parameters, output) ->
                            ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))
                    .build());

    public static final RegistryObject<CreativeModeTab> TODEVILLAGERS_GLASS_TAB = CREATIVE_TABS.register("todevillagers_glass_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.todevillagers_glass_tab"))
                    .icon(() -> new ItemStack(ModBlocks.GLASS_KILN_BLOCK.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.GLASS_KILN_BLOCK.get().asItem().getDefaultInstance());
                        output.accept(ModItems.GLASSBLOWER_SHEARS.get().getDefaultInstance());
                        output.accept(ModItems.GLASSBLOWING_PIPE.get().getDefaultInstance());
                        output.accept(ModItems.MARVER.get().getDefaultInstance());
                        output.accept(ModItems.CRUSHED_GLASS.get().getDefaultInstance());
                        output.accept(Items.GLASS_BOTTLE.getDefaultInstance());
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> item.getDescriptionId().contains("glass"))
                                .filter(item -> !item.getDescriptionId().contains("spy"))
                                .forEach(output::accept);
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> TODEVILLAGERS_POTTERS_TAB = CREATIVE_TABS.register("todevillagers_potters_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.todevillagers_potters_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CERAMICS_TABLE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.CERAMICS_TABLE.get().asItem().getDefaultInstance());
                        output.accept(ModItems.KNIFE_CERAMIC.get().getDefaultInstance());
                        output.accept(ModItems.CHISEL_IRON.get().getDefaultInstance());
                        output.accept(ModItems.CERAMIC_CHIP.get().getDefaultInstance());
                        output.accept(Items.BRICK.getDefaultInstance());
                        output.accept(Items.BRICKS.getDefaultInstance());
                        output.accept(Items.BRICK_SLAB.getDefaultInstance());
                        output.accept(Items.BRICK_STAIRS.getDefaultInstance());
                        output.accept(Items.BRICK_WALL.getDefaultInstance());
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> item.getDescriptionId().contains("ceramic"))
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> item.getDescriptionId().contains("glazed"))
                                .forEach(output::accept);
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> item.getDescriptionId().contains("terracotta"))
                                .forEach(output::accept);
                    })
                    .build());
}