package com.github.warrentode.todevillagers;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.block.ModBlockEntities;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.recipes.glassblowing.recipebook.GlassblowingRecipeCategories;
import com.github.warrentode.todevillagers.block.custom.glasskiln.screens.GlassKilnScreen;
import com.github.warrentode.todevillagers.utils.ModCreativeModeTab;
import com.github.warrentode.todevillagers.utils.ModMenuTypes;
import com.github.warrentode.todevillagers.sounds.ModSounds;
import com.github.warrentode.todevillagers.villagers.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(TodeVillagers.MODID)
public class TodeVillagers {
    public static final String MODID = "todevillagers";
    public static final Logger LOGGER = LogManager.getLogger();

    public TodeVillagers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModCreativeModeTab.CREATIVE_TABS.register(modEventBus);
    }

    private void commonSetup(final @NotNull FMLCommonSetupEvent event) {
        event.enqueueWork(ModVillagers::init);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.GLASS_KILN_MENU.get(), GlassKilnScreen::new);
        }

        @SubscribeEvent
        public static void onRegisterRecipeBookCategories(RegisterRecipeBookCategoriesEvent event) {
            GlassblowingRecipeCategories.init(event);
        }
    }
}