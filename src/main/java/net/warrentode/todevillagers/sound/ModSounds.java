package net.warrentode.todevillagers.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.TodeVillagers;

import javax.annotation.Nullable;

public class ModSounds {
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TodeVillagers.MODID);

    public static final RegistryObject<SoundEvent> VILLAGER_WORK_DISC_JOCKEY = registerSoundEvent("work_dj");

    // my god this one part took forever to figure out because I've been following Kaupenjoe's tutorials up to this point, but he's only got a tutorial
    // for up to 1.18.1 on Sound Events and stuff has changed, and it wasn't working for 1.19.3 at all - like errors everywhere
    // So, credit for Choonster on this one because I could not figure this out myself
    // https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/1.19.x/src/main/java/choonster/testmod3/init/ModSoundEvents.java  MIT License
    private static RegistryObject<SoundEvent> registerSoundEvent(final String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TodeVillagers.MODID, soundName)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}