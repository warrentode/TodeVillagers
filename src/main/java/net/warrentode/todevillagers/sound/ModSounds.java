package net.warrentode.todevillagers.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.TodeVillagers;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TodeVillagers.MODID);

    public static final RegistryObject<SoundEvent> VILLAGER_WORK_DISC_JOCKEY = registerSoundEvent("work_dj");


    public static final RegistryObject<SoundEvent> CHAKRA_DREAM = registerSoundEvent("chakra_dream");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(TodeVillagers.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}