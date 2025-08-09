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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MODID);

    public static final RegistryObject<PoiType> DJ_POI = POI_TYPES.register("dj_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.NOTE_BLOCK
                    .getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<PoiType> GLASSBLOWING_POI = POI_TYPES.register("glassblowing_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GLASS_KILN_BLOCK.get()
                    .getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<PoiType> TRADER_POI = POI_TYPES.register("trader_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.WHEEL_CART.get()
                    .getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<PoiType> POTTER_POI = POI_TYPES.register("potter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CERAMICS_TABLE.get()
                    .getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> DISC_JOCKEY =
            VILLAGER_PROFESSIONS.register("disc_jockey",
                    () -> new VillagerProfession("disc_jockey",
                            heldJobSite -> heldJobSite.get() == DJ_POI.get(),
                            acquirableJobSite -> acquirableJobSite.get() == DJ_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(Blocks.JUKEBOX),
                            ModSounds.VILLAGER_WORK_DISC_JOCKEY.get()
                    ));
    public static final RegistryObject<VillagerProfession> GLASSBLOWER =
            VILLAGER_PROFESSIONS.register("glassblower",
                    () -> new VillagerProfession("glassblower",
                            heldJobSite -> heldJobSite.get() == GLASSBLOWING_POI.get(),
                            acquirableJobSite -> acquirableJobSite.get() == GLASSBLOWING_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(),
                            ModSounds.VILLAGER_WORK_GLASSBLOWER.get()
                    ));
    public static final RegistryObject<VillagerProfession> RETIRED_TRADER =
            VILLAGER_PROFESSIONS.register("retired_trader",
                    () -> new VillagerProfession("retired_trader",
                            heldJobSite -> heldJobSite.get() == TRADER_POI.get(),
                            acquirableJobSite -> acquirableJobSite.get() == TRADER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(),
                            ModSounds.VILLAGER_WORK_RETIRED_TRADER.get()
                    ));
    public static final RegistryObject<VillagerProfession> POTTER =
            VILLAGER_PROFESSIONS.register("potter",
                    () -> new VillagerProfession("potter",
                            heldJobSite -> heldJobSite.get() == POTTER_POI.get(),
                            acquirableJobSite -> acquirableJobSite.get() == POTTER_POI.get(),
                            ImmutableSet.of(), ImmutableSet.of(),
                            ModSounds.VILLAGER_WORK_POTTER.get()
                    ));

    public static void init() {
        setHeroGifts(ModGiftLootTables.RETIRED_TRADER_GIFT, RETIRED_TRADER.get());
        setHeroGifts(ModGiftLootTables.GLASSBLOWER_GIFT, GLASSBLOWER.get());
        setHeroGifts(ModGiftLootTables.DISC_JOCKEY_GIFT, DISC_JOCKEY.get());
        setHeroGifts(ModGiftLootTables.POTTER_GIFT, POTTER.get());
    }

    public static void setHeroGifts(@NotNull ResourceLocation name, VillagerProfession profession) {
        GiveGiftToHero.GIFTS.put(profession, new ResourceLocation(name.getNamespace(), "gameplay/hero_of_the_village/" + name.getPath()));
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}