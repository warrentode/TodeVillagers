package net.warrentode.todevillagers.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<SoundEvent> CHAKRA_DREAM = REGISTRY.register("chakra_dream",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "chakra_dream")));

    public static final RegistryObject<SoundEvent> VILLAGER_WORK_DISC_JOCKEY = REGISTRY.register("work_dj",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "work_dj")));
    public static final RegistryObject<SoundEvent> VILLAGER_WORK_GLASSBLOWER = REGISTRY.register("work_glassblower",
            () -> new SoundEvent(new ResourceLocation("todevillagers", "work_glassblower")));
}