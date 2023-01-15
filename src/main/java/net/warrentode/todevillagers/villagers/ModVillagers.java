package net.warrentode.todevillagers.villagers;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.sounds.ModSounds;

import java.lang.reflect.InvocationTargetException;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MODID);

    public static final RegistryObject<PoiType> DJ_POI = POI_TYPES.register("dj_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.JUKEBOX.getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<VillagerProfession> DISC_JOCKEY = VILLAGER_PROFESSIONS.register("disc_jockey", () ->
            new VillagerProfession("disc_jockey",
                    x -> x.get() == DJ_POI.get(),
                    x -> x.get() == DJ_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(Blocks.NOTE_BLOCK),
                    ModSounds.VILLAGER_WORK_DISC_JOCKEY.get()
            ));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, DJ_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
