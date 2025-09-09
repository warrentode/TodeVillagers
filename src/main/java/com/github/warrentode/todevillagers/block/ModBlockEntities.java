package com.github.warrentode.todevillagers.block;

import com.github.warrentode.todevillagers.block.custom.ceramics_table.CeramicTableBlockEntity;
import com.github.warrentode.todevillagers.block.custom.glasskiln.GlassKilnBlockEntity;
import com.github.warrentode.todevillagers.block.custom.jar.JarBlockEntity;
import com.github.warrentode.todevillagers.block.custom.plate.PlateBlockEntity;
import com.github.warrentode.todevillagers.block.custom.vase.VaseBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<GlassKilnBlockEntity>> GLASS_KILN_ENTITY =
            BLOCK_ENTITIES.register("glass_kiln", () -> BlockEntityType.Builder.of(GlassKilnBlockEntity::new,
                    ModBlocks.GLASS_KILN_BLOCK.get()).build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<CeramicTableBlockEntity>> CERAMICS_TABLE_ENTITY =
            BLOCK_ENTITIES.register("ceramic_kiln", () -> BlockEntityType.Builder.of(CeramicTableBlockEntity::new,
                    ModBlocks.CERAMICS_TABLE.get()).build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("plate_block_entity",
                    () -> BlockEntityType.Builder.of(PlateBlockEntity::new,
                                    ModBlocks.PLATE_TERRACOTTA.get(),
                                    ModBlocks.PLATE_WHITE.get(),
                                    ModBlocks.PLATE_ORANGE.get(),
                                    ModBlocks.PLATE_MAGENTA.get(),
                                    ModBlocks.PLATE_LIGHT_BLUE.get(),
                                    ModBlocks.PLATE_YELLOW.get(),
                                    ModBlocks.PLATE_LIME.get(),
                                    ModBlocks.PLATE_PINK.get(),
                                    ModBlocks.PLATE_GRAY.get(),
                                    ModBlocks.PLATE_LIGHT_GRAY.get(),
                                    ModBlocks.PLATE_CYAN.get(),
                                    ModBlocks.PLATE_PURPLE.get(),
                                    ModBlocks.PLATE_BLUE.get(),
                                    ModBlocks.PLATE_BROWN.get(),
                                    ModBlocks.PLATE_GREEN.get(),
                                    ModBlocks.PLATE_RED.get(),
                                    ModBlocks.PLATE_BLACK.get(),
                                    ModBlocks.PLATE_GLAZED_WHITE.get(),
                                    ModBlocks.PLATE_GLAZED_ORANGE.get(),
                                    ModBlocks.PLATE_GLAZED_MAGENTA.get(),
                                    ModBlocks.PLATE_GLAZED_LIGHT_BLUE.get(),
                                    ModBlocks.PLATE_GLAZED_YELLOW.get(),
                                    ModBlocks.PLATE_GLAZED_LIME.get(),
                                    ModBlocks.PLATE_GLAZED_PINK.get(),
                                    ModBlocks.PLATE_GLAZED_GRAY.get(),
                                    ModBlocks.PLATE_GLAZED_LIGHT_GRAY.get(),
                                    ModBlocks.PLATE_GLAZED_CYAN.get(),
                                    ModBlocks.PLATE_GLAZED_PURPLE.get(),
                                    ModBlocks.PLATE_GLAZED_BLUE.get(),
                                    ModBlocks.PLATE_GLAZED_BROWN.get(),
                                    ModBlocks.PLATE_GLAZED_GREEN.get(),
                                    ModBlocks.PLATE_GLAZED_RED.get(),
                                    ModBlocks.PLATE_GLAZED_BLACK.get()
                            )
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<VaseBlockEntity>> VASE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("vase_block_entity",
                    () -> BlockEntityType.Builder.of(VaseBlockEntity::new,
                                    ModBlocks.VASE_RAW.get(),
                                    ModBlocks.VASE_TERRACOTTA.get(),
                                    ModBlocks.VASE_WHITE.get(),
                                    ModBlocks.VASE_ORANGE.get(),
                                    ModBlocks.VASE_MAGENTA.get(),
                                    ModBlocks.VASE_LIGHT_BLUE.get(),
                                    ModBlocks.VASE_YELLOW.get(),
                                    ModBlocks.VASE_LIME.get(),
                                    ModBlocks.VASE_PINK.get(),
                                    ModBlocks.VASE_GRAY.get(),
                                    ModBlocks.VASE_LIGHT_GRAY.get(),
                                    ModBlocks.VASE_CYAN.get(),
                                    ModBlocks.VASE_PURPLE.get(),
                                    ModBlocks.VASE_BLUE.get(),
                                    ModBlocks.VASE_BROWN.get(),
                                    ModBlocks.VASE_GREEN.get(),
                                    ModBlocks.VASE_RED.get(),
                                    ModBlocks.VASE_BLACK.get(),
                                    ModBlocks.VASE_GLAZED_WHITE.get(),
                                    ModBlocks.VASE_GLAZED_ORANGE.get(),
                                    ModBlocks.VASE_GLAZED_MAGENTA.get(),
                                    ModBlocks.VASE_GLAZED_LIGHT_BLUE.get(),
                                    ModBlocks.VASE_GLAZED_YELLOW.get(),
                                    ModBlocks.VASE_GLAZED_LIME.get(),
                                    ModBlocks.VASE_GLAZED_PINK.get(),
                                    ModBlocks.VASE_GLAZED_GRAY.get(),
                                    ModBlocks.VASE_GLAZED_LIGHT_GRAY.get(),
                                    ModBlocks.VASE_GLAZED_CYAN.get(),
                                    ModBlocks.VASE_GLAZED_PURPLE.get(),
                                    ModBlocks.VASE_GLAZED_BLUE.get(),
                                    ModBlocks.VASE_GLAZED_BROWN.get(),
                                    ModBlocks.VASE_GLAZED_GREEN.get(),
                                    ModBlocks.VASE_GLAZED_RED.get(),
                                    ModBlocks.VASE_GLAZED_BLACK.get()
                            )
                            .build(null));

    @SuppressWarnings("DataFlowIssue")
    public static final RegistryObject<BlockEntityType<JarBlockEntity>> JAR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("jar_block_entity",
                    () -> BlockEntityType.Builder.of(JarBlockEntity::new,
                                    ModBlocks.JAR_GLASS.get(),
                                    ModBlocks.JAR_GLASS_WHITE.get(),
                                    ModBlocks.JAR_GLASS_ORANGE.get(),
                                    ModBlocks.JAR_GLASS_MAGENTA.get(),
                                    ModBlocks.JAR_GLASS_LIGHT_BLUE.get(),
                                    ModBlocks.JAR_GLASS_YELLOW.get(),
                                    ModBlocks.JAR_GLASS_LIME.get(),
                                    ModBlocks.JAR_GLASS_PINK.get(),
                                    ModBlocks.JAR_GLASS_GRAY.get(),
                                    ModBlocks.JAR_GLASS_LIGHT_GRAY.get(),
                                    ModBlocks.JAR_GLASS_CYAN.get(),
                                    ModBlocks.JAR_GLASS_PURPLE.get(),
                                    ModBlocks.JAR_GLASS_BLUE.get(),
                                    ModBlocks.JAR_GLASS_BROWN.get(),
                                    ModBlocks.JAR_GLASS_GREEN.get(),
                                    ModBlocks.JAR_GLASS_RED.get(),
                                    ModBlocks.JAR_GLASS_BLACK.get(),
                                    ModBlocks.JAR_GLASS_TINTED.get(),
                                    ModBlocks.JAR_GLASS_REDSTONE_INFUSED.get(),
                                    ModBlocks.JAR_GLASS_REINFORCED.get(),
                                    ModBlocks.JAR_GLASS_GLOWING.get(),
                                    ModBlocks.JAR_GLASS_SHIFTING.get(),
                                    ModBlocks.JAR_RAW.get(),
                                    ModBlocks.JAR_TERRACOTTA.get(),
                                    ModBlocks.JAR_WHITE.get(),
                                    ModBlocks.JAR_ORANGE.get(),
                                    ModBlocks.JAR_MAGENTA.get(),
                                    ModBlocks.JAR_LIGHT_BLUE.get(),
                                    ModBlocks.JAR_YELLOW.get(),
                                    ModBlocks.JAR_LIME.get(),
                                    ModBlocks.JAR_PINK.get(),
                                    ModBlocks.JAR_GRAY.get(),
                                    ModBlocks.JAR_LIGHT_GRAY.get(),
                                    ModBlocks.JAR_CYAN.get(),
                                    ModBlocks.JAR_PURPLE.get(),
                                    ModBlocks.JAR_BLUE.get(),
                                    ModBlocks.JAR_BROWN.get(),
                                    ModBlocks.JAR_GREEN.get(),
                                    ModBlocks.JAR_RED.get(),
                                    ModBlocks.JAR_BLACK.get(),
                                    ModBlocks.JAR_GLAZED_WHITE.get(),
                                    ModBlocks.JAR_GLAZED_ORANGE.get(),
                                    ModBlocks.JAR_GLAZED_MAGENTA.get(),
                                    ModBlocks.JAR_GLAZED_LIGHT_BLUE.get(),
                                    ModBlocks.JAR_GLAZED_YELLOW.get(),
                                    ModBlocks.JAR_GLAZED_LIME.get(),
                                    ModBlocks.JAR_GLAZED_PINK.get(),
                                    ModBlocks.JAR_GLAZED_GRAY.get(),
                                    ModBlocks.JAR_GLAZED_LIGHT_GRAY.get(),
                                    ModBlocks.JAR_GLAZED_CYAN.get(),
                                    ModBlocks.JAR_GLAZED_PURPLE.get(),
                                    ModBlocks.JAR_GLAZED_BLUE.get(),
                                    ModBlocks.JAR_GLAZED_BROWN.get(),
                                    ModBlocks.JAR_GLAZED_GREEN.get(),
                                    ModBlocks.JAR_GLAZED_RED.get(),
                                    ModBlocks.JAR_GLAZED_BLACK.get()
                            )
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}