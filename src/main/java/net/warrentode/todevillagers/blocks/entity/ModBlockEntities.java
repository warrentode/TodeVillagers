package net.warrentode.todevillagers.blocks.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.blocks.ModBlocks;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final RegistryObject<BlockEntityType<GlassKilnBlockEntity>> GLASS_KILN_ENTITY =
            BLOCK_ENTITIES.register("glass_kiln", ()->
                    BlockEntityType.Builder.of(GlassKilnBlockEntity::new,
                            ModBlocks.GLASS_KILN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}