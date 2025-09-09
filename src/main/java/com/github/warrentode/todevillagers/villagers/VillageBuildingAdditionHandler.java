package com.github.warrentode.todevillagers.villagers;

import com.github.warrentode.todevillagers.Config;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

/**
 * used the chef's delight VillageAdditions class as a template for this one
 */

@Mod.EventBusSubscriber(modid = MODID)
public class VillageBuildingAdditionHandler {
    private static final ResourceKey<StructureProcessorList> PLAINS_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft:mossify_10_percent"));
    private static final ResourceKey<StructureProcessorList> DESERT_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":desert_house_processor"));
    private static final ResourceKey<StructureProcessorList> SAVANNA_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":savanna_house_processor"));
    private static final ResourceKey<StructureProcessorList> SPRUCE_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":spruce_house_processor"));

    private static final ResourceKey<StructureProcessorList> ZOMBIE_PLAINS_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation("minecraft:zombie_plains"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_DESERT_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":zombie_desert_processor"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_SAVANNA_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":zombie_savanna_processor"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_SNOWY_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":zombie_spruce_processor"));
    private static final ResourceKey<StructureProcessorList> ZOMBIE_TAIGA_PROCESSOR_KEY = ResourceKey.create(Registries.PROCESSOR_LIST, new ResourceLocation(MODID + ":zombie_spruce_processor"));

    VillageBuildingAdditionHandler() {
    }

    private static void addBuildingToPool(@NotNull Registry<StructureTemplatePool> templatePoolRegistry, @NotNull Registry<StructureProcessorList> processorListRegistry, @NotNull ResourceKey<StructureProcessorList> processorKey, ResourceLocation templatePoolLocation, String pieceLocation, int spawnWeight) {
        Holder<StructureProcessorList> processorList = processorListRegistry.getHolderOrThrow(processorKey);
        StructureTemplatePool pool = templatePoolRegistry.get(templatePoolLocation);
        if (pool == null) return;

        SinglePoolElement piece = SinglePoolElement.legacy(pieceLocation, processorList)
                .apply(StructureTemplatePool.Projection.RIGID);

        // Check if the pool already contains a piece with the same toString() representation
        boolean alreadyAdded = pool.templates.stream().anyMatch(poolElement -> poolElement.toString().equals(piece.toString()));
        if (alreadyAdded) return;

        for (int i = 0; i < spawnWeight; ++i) {
            pool.templates.add(piece);
        }

        boolean inRawTemplates = pool.rawTemplates.stream().anyMatch(entry -> entry.getFirst().toString().equals(piece.toString()));
        if (!inRawTemplates) {
            List<Pair<StructurePoolElement, Integer>> updatedRawTemplates = new ArrayList<>(pool.rawTemplates);
            updatedRawTemplates.add(new Pair<>(piece, spawnWeight));
            pool.rawTemplates = updatedRawTemplates;
        }
    }

    @SubscribeEvent
    public static void addNewVillageBuilding(@NotNull ServerAboutToStartEvent event) {
        Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();
        // normal villages - baker
        addBuildingToPool(templatePoolRegistry, processorListRegistry, DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        // zombie villages - baker
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/zombie/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/zombie/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/zombie/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SNOWY_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/zombie/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_TAIGA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/zombie/houses"), MODID + ":baker_house", Config.getBakerSpawnWeight());
        // normal villages - disc jockey
        addBuildingToPool(templatePoolRegistry, processorListRegistry, DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        // zombie villages - disc jockey
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/zombie/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/zombie/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/zombie/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SNOWY_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/zombie/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_TAIGA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/zombie/houses"), MODID + ":disc_jockey_house", Config.getDiscJockeySpawnWeight());
        // normal villages - glassblower
        addBuildingToPool(templatePoolRegistry, processorListRegistry, DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        // zombie villages - glassblower
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/zombie/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/zombie/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/zombie/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SNOWY_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/zombie/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_TAIGA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/zombie/houses"), MODID + ":glassblower_house", Config.getGlassblowerSpawnWeight());
        // normal villages - potter
        addBuildingToPool(templatePoolRegistry, processorListRegistry, DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        // zombie villages - potter
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/zombie/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/zombie/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/zombie/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SNOWY_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/zombie/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_TAIGA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/zombie/houses"), MODID + ":potter_house", Config.getPotterSpawnWeight());
        // normal villages - retired trader
        addBuildingToPool(templatePoolRegistry, processorListRegistry, DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, SPRUCE_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        // zombie villages - retired trader
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_DESERT_PROCESSOR_KEY, new ResourceLocation("minecraft:village/desert/zombie/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_PLAINS_PROCESSOR_KEY, new ResourceLocation("minecraft:village/plains/zombie/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SAVANNA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/savanna/zombie/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_SNOWY_PROCESSOR_KEY, new ResourceLocation("minecraft:village/snowy/zombie/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
        addBuildingToPool(templatePoolRegistry, processorListRegistry, ZOMBIE_TAIGA_PROCESSOR_KEY, new ResourceLocation("minecraft:village/taiga/zombie/houses"), MODID + ":retired_trader_stall", Config.getRetiredTraderSpawnWeight());
    }
}