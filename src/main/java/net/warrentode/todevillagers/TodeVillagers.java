package net.warrentode.todevillagers;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.warrentode.todevillagers.items.ModItems;
import net.warrentode.todevillagers.sounds.ModSounds;
import net.warrentode.todevillagers.villagers.ModVillagers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TodeVillagers.MODID)
public class TodeVillagers {
    public static final Logger LOGGER = LogManager.getLogger(TodeVillagers.class);
    public static final String MODID = "todevillagers";

    public TodeVillagers() {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModSounds.REGISTRY.register(bus);

        ModItems.REGISTRY.register(bus);

        ModVillagers.register(bus);
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
