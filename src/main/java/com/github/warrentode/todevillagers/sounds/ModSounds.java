package com.github.warrentode.todevillagers.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> CHAKRA_DREAM = registerSoundEvents("chakra_dream");
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_DISC_JOCKEY = registerSoundEvents("work_dj");
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_GLASSBLOWER = registerSoundEvents("work_glassblower");
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_RETIRED_TRADER = registerSoundEvents("work_retired_trader");
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_POTTER = registerSoundEvents("work_potter");
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_BAKER = registerSoundEvents("work_baker");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}