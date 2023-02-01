package net.warrentode.todevillagers.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.blocks.custom.GlassKilnBlock;
import net.warrentode.todevillagers.blocks.custom.GlowingGlassBlock;
import net.warrentode.todevillagers.blocks.custom.ReinforcedGlassBlock;
import net.warrentode.todevillagers.blocks.custom.ShiftingGlassBlock;
import net.warrentode.todevillagers.items.ModItems;
import net.warrentode.todevillagers.util.customtabs.ModCreativeModeTab;
import net.warrentode.todevillagers.util.customtabs.ModGlassTab;

import java.util.function.Supplier;

import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> GLASS_KILN = registerBlock("glass_kiln",
            ()-> new GlassKilnBlock(Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_BRICKS).strength(6f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(GlassKilnBlock.LIT) ? 15 : 0).noOcclusion()),
            ModCreativeModeTab.TODEVILLAGERS_TAB);

    public static final RegistryObject<Block> REINFORCED_GLASS = registerBlock("reinforced_glass",
            ()-> new ReinforcedGlassBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_PANE = registerBlock("reinforced_glass_pane",
            ()-> new IronBarsBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_STAIRS = registerBlock("reinforced_glass_stairs",
            ()-> new StairBlock(()-> ModBlocks.REINFORCED_GLASS.get().defaultBlockState(),
                    Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_SLAB = registerBlock("reinforced_glass_slab",
            ()-> new SlabBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_WALL = registerBlock("reinforced_glass_wall",
            ()-> new WallBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_FENCE = registerBlock("reinforced_glass_fence",
            ()-> new FenceBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_FENCE_GATE = registerBlock("reinforced_glass_fence_gate",
            ()-> new FenceGateBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_BUTTON = registerBlock("reinforced_glass_button",
            ()-> new StoneButtonBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_PRESSURE_PLATE = registerBlock("reinforced_glass_pressure_plate",
            ()-> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.GLASS)
                    .strength(0.3f).noCollission()), ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_DOOR = registerBlock("reinforced_glass_door",
            ()-> new DoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> REINFORCED_GLASS_TRAPDOOR = registerBlock("reinforced_glass_trapdoor",
            ()-> new TrapDoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);

    public static final RegistryObject<Block> GLOWING_GLASS = registerBlock("glowing_glass",
            ()-> new GlowingGlassBlock(Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_PANE = registerBlock("glowing_glass_pane",
            ()-> new IronBarsBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_STAIRS = registerBlock("glowing_glass_stairs",
            ()-> new StairBlock(()-> ModBlocks.GLOWING_GLASS.get().defaultBlockState(),
                    Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_SLAB = registerBlock("glowing_glass_slab",
            ()-> new SlabBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_WALL = registerBlock("glowing_glass_wall",
            ()-> new WallBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_FENCE = registerBlock("glowing_glass_fence",
            ()-> new FenceBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_FENCE_GATE = registerBlock("glowing_glass_fence_gate",
            ()-> new FenceGateBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_BUTTON = registerBlock("glowing_glass_button",
            ()-> new StoneButtonBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_PRESSURE_PLATE = registerBlock("glowing_glass_pressure_plate",
            ()-> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.GLASS)
                    .strength(0.3f).noCollission()), ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_DOOR = registerBlock("glowing_glass_door",
            ()-> new DoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> GLOWING_GLASS_TRAPDOOR = registerBlock("glowing_glass_trapdoor",
            ()-> new TrapDoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);

    public static final RegistryObject<Block> SHIFTING_GLASS = registerBlock("shifting_glass",
            ()-> new ShiftingGlassBlock(Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((blockState) -> 15)),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_PANE = registerBlock("shifting_glass_pane",
            ()-> new IronBarsBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_STAIRS = registerBlock("shifting_glass_stairs",
            ()-> new StairBlock(()-> ModBlocks.SHIFTING_GLASS.get().defaultBlockState(),
                    Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_SLAB = registerBlock("shifting_glass_slab",
            ()-> new SlabBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_WALL = registerBlock("shifting_glass_wall",
            ()-> new WallBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_FENCE = registerBlock("shifting_glass_fence",
            ()-> new FenceBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_FENCE_GATE = registerBlock("shifting_glass_fence_gate",
            ()-> new FenceGateBlock(Properties.copy(Blocks.GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_BUTTON = registerBlock("shifting_glass_button",
            ()-> new StoneButtonBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_PRESSURE_PLATE = registerBlock("shifting_glass_pressure_plate",
            ()-> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.GLASS)
                    .strength(0.3f).noCollission()), ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_DOOR = registerBlock("shifting_glass_door",
            ()-> new DoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> SHIFTING_GLASS_TRAPDOOR = registerBlock("shifting_glass_trapdoor",
            ()-> new TrapDoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);

    public static final RegistryObject<Block> TINTED_GLASS_PANE = registerBlock("tinted_glass_pane",
            ()-> new IronBarsBlock(Properties.copy(Blocks.TINTED_GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_STAIRS = registerBlock("tinted_glass_stairs",
            ()-> new StairBlock(Blocks.TINTED_GLASS::defaultBlockState, Properties.copy(Blocks.TINTED_GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_SLAB = registerBlock("tinted_glass_slab",
            ()-> new SlabBlock(Properties.copy(Blocks.TINTED_GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_WALL = registerBlock("tinted_glass_wall",
            ()-> new WallBlock(Properties.copy(Blocks.TINTED_GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_FENCE = registerBlock("tinted_glass_fence",
            ()-> new FenceBlock(Properties.copy(Blocks.TINTED_GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_FENCE_GATE = registerBlock("tinted_glass_fence_gate",
            ()-> new FenceGateBlock(Properties.copy(Blocks.TINTED_GLASS).noOcclusion()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_BUTTON = registerBlock("tinted_glass_button",
            ()-> new StoneButtonBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_PRESSURE_PLATE = registerBlock("tinted_glass_pressure_plate",
            ()-> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Properties.of(Material.GLASS)
                    .strength(0.3f).noCollission()), ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_DOOR = registerBlock("tinted_glass_door",
            ()-> new DoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);
    public static final RegistryObject<Block> TINTED_GLASS_TRAPDOOR = registerBlock("tinted_glass_trapdoor",
            ()-> new TrapDoorBlock(Properties.of(Material.GLASS).strength(0.3f).noCollission()),
            ModGlassTab.TODEVILLAGERS_GLASS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock( String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
