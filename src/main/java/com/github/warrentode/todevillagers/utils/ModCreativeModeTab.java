package com.github.warrentode.todevillagers.utils;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> TODEVILLAGERS_TAB = CREATIVE_TABS.register("todevillagers_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.todevillagers_tab"))
                    .icon(() -> new ItemStack(ModBlocks.WHEEL_CART.get()))
                    .displayItems((parameters, output) -> ModItems.ITEMS.getEntries().forEach((item) -> output.accept(item.get())))
                    .build());

    public static final RegistryObject<CreativeModeTab> TODEVILLAGERS_GLASS_TAB = CREATIVE_TABS.register("todevillagers_glass_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.todevillagers_glass_tab"))
                    .icon(() -> new ItemStack(ModBlocks.REINFORCED_GLASS.get()))
                    .displayItems((parameters, output) -> {
                        output.accept((ModBlocks.GLASS_KILN_BLOCK.get().asItem().getDefaultInstance()));
                        output.accept(ModItems.GLASSBLOWER_SHEARS.get().getDefaultInstance());
                        output.accept(ModItems.GLASSBLOWING_PIPE.get().getDefaultInstance());
                        output.accept(ModItems.MARVER.get().getDefaultInstance());
                        output.accept(ModItems.CRUSHED_GLASS.get().getDefaultInstance());

                        output.accept(Items.GLASS_BOTTLE.getDefaultInstance());

                        output.accept((ModBlocks.REDSTONE_INFUSED_GLASS.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.REINFORCED_GLASS.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS.get().asItem().getDefaultInstance()));
                        output.accept((Blocks.TINTED_GLASS.asItem().getDefaultInstance()));

                        output.accept((Blocks.GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.WHITE_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.ORANGE_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.MAGENTA_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.LIGHT_BLUE_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.YELLOW_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.LIME_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.PINK_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.GRAY_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.LIGHT_GRAY_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.CYAN_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.PURPLE_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.BLUE_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.BROWN_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.GREEN_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.RED_STAINED_GLASS.asItem().getDefaultInstance()));
                        output.accept((Blocks.BLACK_STAINED_GLASS.asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_PANE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_PANE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_PANE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_PANE.get().asItem().getDefaultInstance()));

                        output.accept((Blocks.GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.WHITE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.ORANGE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.MAGENTA_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.LIGHT_BLUE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.YELLOW_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.LIME_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.PINK_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.GRAY_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.LIGHT_GRAY_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.CYAN_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.PURPLE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.BLUE_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.BROWN_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.GREEN_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.RED_STAINED_GLASS_PANE.asItem().getDefaultInstance()));
                        output.accept((Blocks.BLACK_STAINED_GLASS_PANE.asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_STAIRS.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_STAIRS.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_STAIRS.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_STAIRS.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_SLAB.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_SLAB.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_SLAB.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_SLAB.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_WALL.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_WALL.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_WALL.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_WALL.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_FENCE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_FENCE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_FENCE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_FENCE.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_FENCE_GATE.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_BUTTON.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_BUTTON.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_BUTTON.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_BUTTON.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_DOOR.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_DOOR.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_DOOR.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_DOOR.get().asItem().getDefaultInstance()));

                        output.accept((ModBlocks.REINFORCED_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.GLOWING_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.SHIFTING_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
                        output.accept((ModBlocks.TINTED_GLASS_TRAPDOOR.get().asItem().getDefaultInstance()));
                    })
                    .build());
}