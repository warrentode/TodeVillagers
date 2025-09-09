package com.github.warrentode.todevillagers.block;

import com.github.warrentode.todevillagers.block.custom.*;
import com.github.warrentode.todevillagers.block.custom.ceramics_table.CeramicTableBlock;
import com.github.warrentode.todevillagers.block.custom.glasskiln.GlassKilnBlock;
import com.github.warrentode.todevillagers.block.custom.jar.JarBlock;
import com.github.warrentode.todevillagers.block.custom.plate.PlateBlock;
import com.github.warrentode.todevillagers.block.custom.vase.VaseBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;
import static com.github.warrentode.todevillagers.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> CERAMICS_TABLE = registerBlock("ceramics_table",
            () -> new CeramicTableBlock(Block.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().strength(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GLASS_KILN_BLOCK = registerBlock("glass_kiln",
            () -> new GlassKilnBlock(Block.Properties.copy(Blocks.STONE).noOcclusion().sound(SoundType.DEEPSLATE_BRICKS).strength(6f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(GlassKilnBlock.LIT) ? 15 : 0)));

    public static final RegistryObject<Block> WHEEL_CART = registerBlock("wheel_cart",
            () -> new WheelCartBlock(Block.Properties.copy(Blocks.OAK_PLANKS).noOcclusion().strength(2.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> REDSTONE_INFUSED_GLASS = registerBlock("redstone_infused_glass",
            () -> new RedstoneInfusedGlassBlock(Block.Properties.copy(Blocks.AMETHYST_BLOCK).sound(SoundType.GLASS).strength(0.3f)
                    .lightLevel(state -> state.getValue(RedstoneInfusedGlassBlock.LIT) ? 9 : 0).noOcclusion()));

    public static final RegistryObject<Block> REINFORCED_GLASS = registerBlock("reinforced_glass",
            () -> new ReinforcedGlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_GLASS_PANE = registerBlock("reinforced_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_GLASS_STAIRS = registerBlock("reinforced_glass_stairs",
            () -> new StairBlock(() -> ModBlocks.REINFORCED_GLASS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_GLASS_SLAB = registerBlock("reinforced_glass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_GLASS_WALL = registerBlock("reinforced_glass_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_GLASS_FENCE = registerBlock("reinforced_glass_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));
    public static final RegistryObject<Block> REINFORCED_GLASS_FENCE_GATE = registerBlock("reinforced_glass_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion(), WoodType.OAK));
    public static final RegistryObject<Block> REINFORCED_GLASS_BUTTON = registerBlock("reinforced_glass_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO, 30, true));
    public static final RegistryObject<Block> REINFORCED_GLASS_PRESSURE_PLATE = registerBlock("reinforced_glass_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> REINFORCED_GLASS_DOOR = registerBlock("reinforced_glass_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> REINFORCED_GLASS_TRAPDOOR = registerBlock("reinforced_glass_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO));

    public static final RegistryObject<Block> GLOWING_GLASS = registerBlock("glowing_glass",
            () -> new GlowingGlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> GLOWING_GLASS_PANE = registerBlock("glowing_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> GLOWING_GLASS_STAIRS = registerBlock("glowing_glass_stairs",
            () -> new StairBlock(() -> ModBlocks.GLOWING_GLASS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> GLOWING_GLASS_SLAB = registerBlock("glowing_glass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> GLOWING_GLASS_WALL = registerBlock("glowing_glass_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> GLOWING_GLASS_FENCE = registerBlock("glowing_glass_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> GLOWING_GLASS_FENCE_GATE = registerBlock("glowing_glass_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15), WoodType.OAK));
    public static final RegistryObject<Block> GLOWING_GLASS_BUTTON = registerBlock("glowing_glass_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO, 30, true));
    public static final RegistryObject<Block> GLOWING_GLASS_PRESSURE_PLATE = registerBlock("glowing_glass_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> GLOWING_GLASS_DOOR = registerBlock("glowing_glass_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> GLOWING_GLASS_TRAPDOOR = registerBlock("glowing_glass_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));

    public static final RegistryObject<Block> SHIFTING_GLASS = registerBlock("shifting_glass",
            () -> new ShiftingGlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> SHIFTING_GLASS_PANE = registerBlock("shifting_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> SHIFTING_GLASS_STAIRS = registerBlock("shifting_glass_stairs",
            () -> new StairBlock(() -> ModBlocks.SHIFTING_GLASS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> SHIFTING_GLASS_SLAB = registerBlock("shifting_glass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> SHIFTING_GLASS_WALL = registerBlock("shifting_glass_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> SHIFTING_GLASS_FENCE = registerBlock("shifting_glass_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> SHIFTING_GLASS_FENCE_GATE = registerBlock("shifting_glass_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15), WoodType.OAK));
    public static final RegistryObject<Block> SHIFTING_GLASS_BUTTON = registerBlock("shifting_glass_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO, 30, true));
    public static final RegistryObject<Block> SHIFTING_GLASS_PRESSURE_PLATE = registerBlock("shifting_glass_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> SHIFTING_GLASS_DOOR = registerBlock("shifting_glass_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> SHIFTING_GLASS_TRAPDOOR = registerBlock("shifting_glass_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));

    public static final RegistryObject<Block> TINTED_GLASS_PANE = registerBlock("tinted_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS).noOcclusion()));
    public static final RegistryObject<Block> TINTED_GLASS_STAIRS = registerBlock("tinted_glass_stairs",
            () -> new StairBlock(Blocks.TINTED_GLASS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS).noOcclusion()));
    public static final RegistryObject<Block> TINTED_GLASS_SLAB = registerBlock("tinted_glass_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS).noOcclusion()));
    public static final RegistryObject<Block> TINTED_GLASS_WALL = registerBlock("tinted_glass_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS).noOcclusion()));
    public static final RegistryObject<Block> TINTED_GLASS_FENCE = registerBlock("tinted_glass_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.TINTED_GLASS).noOcclusion()));
    public static final RegistryObject<Block> TINTED_GLASS_FENCE_GATE = registerBlock("tinted_glass_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion(), WoodType.OAK));
    public static final RegistryObject<Block> TINTED_GLASS_BUTTON = registerBlock("tinted_glass_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO, 30, true));
    public static final RegistryObject<Block> TINTED_GLASS_PRESSURE_PLATE = registerBlock("tinted_glass_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion().lightLevel((blockState) -> 15), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> TINTED_GLASS_DOOR = registerBlock("tinted_glass_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO));
    public static final RegistryObject<Block> TINTED_GLASS_TRAPDOOR = registerBlock("tinted_glass_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f).noOcclusion(), BlockSetType.BAMBOO));

    // terracotta plates
    public static final RegistryObject<Block> PLATE_TERRACOTTA = registerBlock("plate_terracotta",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_WHITE = registerBlock("plate_white",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_ORANGE = registerBlock("plate_orange",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_MAGENTA = registerBlock("plate_magenta",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_LIGHT_BLUE = registerBlock("plate_light_blue",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_YELLOW = registerBlock("plate_yellow",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_LIME = registerBlock("plate_lime",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_PINK = registerBlock("plate_pink",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GRAY = registerBlock("plate_gray",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_LIGHT_GRAY = registerBlock("plate_light_gray",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_CYAN = registerBlock("plate_cyan",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_PURPLE = registerBlock("plate_purple",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_BLUE = registerBlock("plate_blue",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_BROWN = registerBlock("plate_brown",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GREEN = registerBlock("plate_green",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_RED = registerBlock("plate_red",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_BLACK = registerBlock("plate_black",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    // glazed terracotta plates
    public static final RegistryObject<Block> PLATE_GLAZED_WHITE = registerBlock("plate_glazed_white",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_ORANGE = registerBlock("plate_glazed_orange",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_MAGENTA = registerBlock("plate_glazed_magenta",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_LIGHT_BLUE = registerBlock("plate_glazed_light_blue",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_YELLOW = registerBlock("plate_glazed_yellow",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_LIME = registerBlock("plate_glazed_lime",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_PINK = registerBlock("plate_glazed_pink",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_GRAY = registerBlock("plate_glazed_gray",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_LIGHT_GRAY = registerBlock("plate_glazed_light_gray",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_CYAN = registerBlock("plate_glazed_cyan",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_PURPLE = registerBlock("plate_glazed_purple",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_BLUE = registerBlock("plate_glazed_blue",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_BROWN = registerBlock("plate_glazed_brown",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_GREEN = registerBlock("plate_glazed_green",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_RED = registerBlock("plate_glazed_red",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> PLATE_GLAZED_BLACK = registerBlock("plate_glazed_black",
            () -> new PlateBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    // vases
    public static final RegistryObject<Block> VASE_RAW = registerBlock("vase_raw",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.CLAY)
                    .sound(SoundType.GRAVEL).strength(1)));
    // terracotta vases
    public static final RegistryObject<Block> VASE_TERRACOTTA = registerBlock("vase_terracotta",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_WHITE = registerBlock("vase_white",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_ORANGE = registerBlock("vase_orange",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_MAGENTA = registerBlock("vase_magenta",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_LIGHT_BLUE = registerBlock("vase_light_blue",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_YELLOW = registerBlock("vase_yellow",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_LIME = registerBlock("vase_lime",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_PINK = registerBlock("vase_pink",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GRAY = registerBlock("vase_gray",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_LIGHT_GRAY = registerBlock("vase_light_gray",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_CYAN = registerBlock("vase_cyan",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_PURPLE = registerBlock("vase_purple",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_BLUE = registerBlock("vase_blue",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_BROWN = registerBlock("vase_brown",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GREEN = registerBlock("vase_green",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_RED = registerBlock("vase_red",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_BLACK = registerBlock("vase_black",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    // glazed terracotta vases
    public static final RegistryObject<Block> VASE_GLAZED_WHITE = registerBlock("vase_glazed_white",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_ORANGE = registerBlock("vase_glazed_orange",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_MAGENTA = registerBlock("vase_glazed_magenta",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_LIGHT_BLUE = registerBlock("vase_glazed_light_blue",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_YELLOW = registerBlock("vase_glazed_yellow",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_LIME = registerBlock("vase_glazed_lime",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_PINK = registerBlock("vase_glazed_pink",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_GRAY = registerBlock("vase_glazed_gray",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_LIGHT_GRAY = registerBlock("vase_glazed_light_gray",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_CYAN = registerBlock("vase_glazed_cyan",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_PURPLE = registerBlock("vase_glazed_purple",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_BLUE = registerBlock("vase_glazed_blue",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_BROWN = registerBlock("vase_glazed_brown",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_GREEN = registerBlock("vase_glazed_green",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_RED = registerBlock("vase_glazed_red",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> VASE_GLAZED_BLACK = registerBlock("vase_glazed_black",
            () -> new VaseBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));

    // jars
    public static final RegistryObject<Block> JAR_RAW = registerBlock("jar_raw",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.CLAY)
                    .sound(SoundType.GRAVEL).strength(1)));
    // terracotta jars
    public static final RegistryObject<Block> JAR_TERRACOTTA = registerBlock("jar_terracotta",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_WHITE = registerBlock("jar_white",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_ORANGE = registerBlock("jar_orange",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_MAGENTA = registerBlock("jar_magenta",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_LIGHT_BLUE = registerBlock("jar_light_blue",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_YELLOW = registerBlock("jar_yellow",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_LIME = registerBlock("jar_lime",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_PINK = registerBlock("jar_pink",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GRAY = registerBlock("jar_gray",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_LIGHT_GRAY = registerBlock("jar_light_gray",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_CYAN = registerBlock("jar_cyan",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_PURPLE = registerBlock("jar_purple",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_BLUE = registerBlock("jar_blue",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_BROWN = registerBlock("jar_brown",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GREEN = registerBlock("jar_green",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_RED = registerBlock("jar_red",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_BLACK = registerBlock("jar_black",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    // glazed terracotta jars
    public static final RegistryObject<Block> JAR_GLAZED_WHITE = registerBlock("jar_glazed_white",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_ORANGE = registerBlock("jar_glazed_orange",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_MAGENTA = registerBlock("jar_glazed_magenta",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_LIGHT_BLUE = registerBlock("jar_glazed_light_blue",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_YELLOW = registerBlock("jar_glazed_yellow",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_LIME = registerBlock("jar_glazed_lime",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_PINK = registerBlock("jar_glazed_pink",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_GRAY = registerBlock("jar_glazed_gray",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_LIGHT_GRAY = registerBlock("jar_glazed_light_gray",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_CYAN = registerBlock("jar_glazed_cyan",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_PURPLE = registerBlock("jar_glazed_purple",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_BLUE = registerBlock("jar_glazed_blue",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_BROWN = registerBlock("jar_glazed_brown",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_GREEN = registerBlock("jar_glazed_green",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_RED = registerBlock("jar_glazed_red",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));
    public static final RegistryObject<Block> JAR_GLAZED_BLACK = registerBlock("jar_glazed_black",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)
                    .sound(SoundType.BONE_BLOCK).strength(1)));

    // glass jars
    public static final RegistryObject<Block> JAR_GLASS = registerBlock("jar_glass",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    // stained glass jars
    public static final RegistryObject<Block> JAR_GLASS_WHITE = registerBlock("jar_glass_white",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_ORANGE = registerBlock("jar_glass_orange",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_MAGENTA = registerBlock("jar_glass_magenta",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_LIGHT_BLUE = registerBlock("jar_glass_light_blue",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_YELLOW = registerBlock("jar_glass_yellow",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_LIME = registerBlock("jar_glass_lime",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_PINK = registerBlock("jar_glass_pink",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_GRAY = registerBlock("jar_glass_gray",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_LIGHT_GRAY = registerBlock("jar_glass_light_gray",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_CYAN = registerBlock("jar_glass_cyan",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_PURPLE = registerBlock("jar_glass_purple",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_BLUE = registerBlock("jar_glass_blue",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_BROWN = registerBlock("jar_glass_brown",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_GREEN = registerBlock("jar_glass_green",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_RED = registerBlock("jar_glass_red",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_BLACK = registerBlock("jar_glass_black",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_TINTED = registerBlock("jar_glass_tinted",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    // modded glass jars
    public static final RegistryObject<Block> JAR_GLASS_REINFORCED = registerBlock("jar_glass_reinforced",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1)));
    public static final RegistryObject<Block> JAR_GLASS_REDSTONE_INFUSED = registerBlock("jar_glass_redstone_infused",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).noOcclusion()
                    .sound(SoundType.GLASS).strength(1).lightLevel((blockState) -> 9)));
    public static final RegistryObject<Block> JAR_GLASS_GLOWING = registerBlock("jar_glass_glowing",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1).lightLevel((blockState) -> 15)));
    public static final RegistryObject<Block> JAR_GLASS_SHIFTING = registerBlock("jar_glass_shifting",
            () -> new JarBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()
                    .sound(SoundType.GLASS).strength(1).lightLevel((blockState) -> 15)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}