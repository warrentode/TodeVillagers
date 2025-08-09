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

    public static final RegistryObject<SoundEvent> CHAKRA_DREAM = SOUNDS.register("chakra_dream",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "chakra_dream")));

    public static final RegistryObject<SoundEvent> VILLAGER_WORK_DISC_JOCKEY = SOUNDS.register("work_dj",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "work_dj")));
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_GLASSBLOWER = SOUNDS.register("work_glassblower",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "work_glassblower")));
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_RETIRED_TRADER = SOUNDS.register("work_retired_trader",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "work_retired_trader")));
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_POTTER = SOUNDS.register("work_retired_potter",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "work_retired_potter")));


    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}