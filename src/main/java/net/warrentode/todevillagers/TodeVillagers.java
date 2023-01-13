package net.warrentode.todevillagers;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.warrentode.todevillagers.item.ModItems;
import net.warrentode.todevillagers.sound.ModSounds;
import net.warrentode.todevillagers.villager.ModVillagers;
import org.slf4j.Logger;

@Mod(TodeVillagers.MODID)
public class TodeVillagers {
    public static final String MODID = "todevillagers";
    private static final Logger LOGGER = LogUtils.getLogger();
    public TodeVillagers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
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
