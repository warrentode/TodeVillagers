package com.github.warrentode.todevillagers.block;

import com.github.warrentode.todevillagers.block.custom.*;
import com.github.warrentode.todevillagers.block.custom.glasskiln.GlassKilnBlock;
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
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<Block> GLASS_KILN_BLOCK = registerBlock("glass_kiln",
            () -> new GlassKilnBlock(Block.Properties.copy(Blocks.STONE).sound(SoundType.DEEPSLATE_BRICKS).strength(6f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(GlassKilnBlock.LIT) ? 15 : 0).noOcclusion()));

    public static final RegistryObject<Block> WHEEL_CART = registerBlock("wheel_cart",
            () -> new WheelCartBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F).sound(SoundType.WOOD).noOcclusion()));

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