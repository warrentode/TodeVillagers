package net.warrentode.todevillagers;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.warrentode.todevillagers.blocks.ModBlocks;
import net.warrentode.todevillagers.blocks.entity.ModBlockEntities;
import net.warrentode.todevillagers.items.ModItems;
import net.warrentode.todevillagers.recipes.ModRecipes;
import net.warrentode.todevillagers.screens.GlassKilnScreen;
import net.warrentode.todevillagers.screens.ModMenuTypes;
import net.warrentode.todevillagers.sounds.ModSounds;
import net.warrentode.todevillagers.villagers.ModVillagers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TodeVillagers.MODID)
public class TodeVillagers {
    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogManager.getLogger(TodeVillagers.class);
    public static final String MODID = "todevillagers";
    private static boolean annabethsextravillagersLoaded = false;

    public TodeVillagers() {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModSounds.REGISTRY.register(modEventBus);
        ModItems.REGISTRY.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModVillagers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        annabethsextravillagersLoaded = ModList.get().isLoaded("annabethsextravillagers");
    }
    public static boolean isAnnabethsExtraVillagersLoaded() {
        return annabethsextravillagersLoaded;
    }

    @SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.GLASS_KILN_MENU.get(), GlassKilnScreen::new);
        }
    }
}