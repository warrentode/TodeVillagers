package com.github.warrentode.todevillagers.villagers;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.sounds.ModSounds;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.behavior.GiveGiftToHero;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MODID);

    public static final RegistryObject<PoiType> DJ_POI = POI_TYPES.register("dj_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.NOTE_BLOCK.getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> DISC_JOCKEY = VILLAGER_PROFESSIONS.register("disc_jockey", () ->
            new VillagerProfession("disc_jockey", x -> x.get() == DJ_POI.get(), x -> x.get() == DJ_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(Blocks.JUKEBOX), ModSounds.VILLAGER_WORK_DISC_JOCKEY.get()
            ));

    public static final RegistryObject<PoiType> GLASSBLOWING_POI = POI_TYPES.register("glassblowing_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GLASS_KILN_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<VillagerProfession> GLASSBLOWER = VILLAGER_PROFESSIONS.register("glassblower", () ->
            new VillagerProfession("glassblower", x -> x.get() == GLASSBLOWING_POI.get(), x -> x.get() == GLASSBLOWING_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), ModSounds.VILLAGER_WORK_GLASSBLOWER.get()
            ));

    public static final RegistryObject<PoiType> TRADER_POI = POI_TYPES.register("trader_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.WHEEL_CART.get().getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<VillagerProfession> RETIRED_TRADER = VILLAGER_PROFESSIONS.register("retired_trader", () ->
            new VillagerProfession("retired_trader", x -> x.get() == TRADER_POI.get(), x -> x.get() == TRADER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), ModSounds.VILLAGER_WORK_RETIRED_TRADER.get()
            ));

    public static void init() {
        setHeroGifts(new ResourceLocation(MODID, "retired_trader_gift"), RETIRED_TRADER.get());
        setHeroGifts(new ResourceLocation(MODID, "glassblower_gift"), GLASSBLOWER.get());
        setHeroGifts(new ResourceLocation(MODID, "disc_jockey_gift"), DISC_JOCKEY.get());
    }

    public static void setHeroGifts(@NotNull ResourceLocation name, VillagerProfession profession) {
        GiveGiftToHero.GIFTS.put(profession, new ResourceLocation(name.getNamespace(), "gameplay/hero_of_the_village/" + name.getPath()));
    }


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, DJ_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, GLASSBLOWING_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, TRADER_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception) {
            //noinspection CallToPrintStackTrace
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}