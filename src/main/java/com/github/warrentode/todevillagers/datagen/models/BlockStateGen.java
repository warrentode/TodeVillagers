package com.github.warrentode.todevillagers.datagen.models;

import com.github.warrentode.todevillagers.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(PackOutput output, String modid, ExistingFileHelper helper) {
        super(output, modid, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        // plates
        processPlateVariants(ModBlocks.PLATE_TERRACOTTA.get(), "minecraft", "block/terracotta");
        processPlateVariants(ModBlocks.PLATE_WHITE.get(), "minecraft", "block/white_terracotta");
        processPlateVariants(ModBlocks.PLATE_ORANGE.get(), "minecraft", "block/orange_terracotta");
        processPlateVariants(ModBlocks.PLATE_MAGENTA.get(), "minecraft", "block/magenta_terracotta");
        processPlateVariants(ModBlocks.PLATE_LIGHT_BLUE.get(), "minecraft", "block/light_blue_terracotta");
        processPlateVariants(ModBlocks.PLATE_YELLOW.get(), "minecraft", "block/yellow_terracotta");
        processPlateVariants(ModBlocks.PLATE_LIME.get(), "minecraft", "block/lime_terracotta");
        processPlateVariants(ModBlocks.PLATE_PINK.get(), "minecraft", "block/pink_terracotta");
        processPlateVariants(ModBlocks.PLATE_GRAY.get(), "minecraft", "block/gray_terracotta");
        processPlateVariants(ModBlocks.PLATE_LIGHT_GRAY.get(), "minecraft", "block/light_gray_terracotta");
        processPlateVariants(ModBlocks.PLATE_CYAN.get(), "minecraft", "block/cyan_terracotta");
        processPlateVariants(ModBlocks.PLATE_PURPLE.get(), "minecraft", "block/purple_terracotta");
        processPlateVariants(ModBlocks.PLATE_BLUE.get(), "minecraft", "block/blue_terracotta");
        processPlateVariants(ModBlocks.PLATE_BROWN.get(), "minecraft", "block/brown_terracotta");
        processPlateVariants(ModBlocks.PLATE_GREEN.get(), "minecraft", "block/green_terracotta");
        processPlateVariants(ModBlocks.PLATE_RED.get(), "minecraft", "block/red_terracotta");
        processPlateVariants(ModBlocks.PLATE_BLACK.get(), "minecraft", "block/black_terracotta");
        // glazed plates
        processPlateVariants(ModBlocks.PLATE_GLAZED_WHITE.get(), MODID, "block/plate_glazed_white");
        processPlateVariants(ModBlocks.PLATE_GLAZED_ORANGE.get(), MODID, "block/plate_glazed_orange");
        processPlateVariants(ModBlocks.PLATE_GLAZED_MAGENTA.get(), MODID, "block/plate_glazed_magenta");
        processPlateVariants(ModBlocks.PLATE_GLAZED_LIGHT_BLUE.get(), MODID, "block/plate_glazed_light_blue");
        processPlateVariants(ModBlocks.PLATE_GLAZED_YELLOW.get(), MODID, "block/plate_glazed_yellow");
        processPlateVariants(ModBlocks.PLATE_GLAZED_LIME.get(), MODID, "block/plate_glazed_lime");
        processPlateVariants(ModBlocks.PLATE_GLAZED_PINK.get(), MODID, "block/plate_glazed_pink");
        processPlateVariants(ModBlocks.PLATE_GLAZED_GRAY.get(), MODID, "block/plate_glazed_gray");
        processPlateVariants(ModBlocks.PLATE_GLAZED_LIGHT_GRAY.get(), MODID, "block/plate_glazed_light_gray");
        processPlateVariants(ModBlocks.PLATE_GLAZED_CYAN.get(), MODID, "block/plate_glazed_cyan");
        processPlateVariants(ModBlocks.PLATE_GLAZED_PURPLE.get(), MODID, "block/plate_glazed_purple");
        processPlateVariants(ModBlocks.PLATE_GLAZED_BLUE.get(), MODID, "block/plate_glazed_blue");
        processPlateVariants(ModBlocks.PLATE_GLAZED_BROWN.get(), MODID, "block/plate_glazed_brown");
        processPlateVariants(ModBlocks.PLATE_GLAZED_GREEN.get(), MODID, "block/plate_glazed_green");
        processPlateVariants(ModBlocks.PLATE_GLAZED_RED.get(), MODID, "block/plate_glazed_red");
        processPlateVariants(ModBlocks.PLATE_GLAZED_BLACK.get(), MODID, "block/plate_glazed_black");
        // vases
        processVaseVariants(ModBlocks.VASE_RAW.get(), "minecraft", "block/clay");
        processVaseVariants(ModBlocks.VASE_TERRACOTTA.get(), "minecraft", "block/terracotta");
        processVaseVariants(ModBlocks.VASE_WHITE.get(), "minecraft", "block/white_terracotta");
        processVaseVariants(ModBlocks.VASE_ORANGE.get(), "minecraft", "block/orange_terracotta");
        processVaseVariants(ModBlocks.VASE_MAGENTA.get(), "minecraft", "block/magenta_terracotta");
        processVaseVariants(ModBlocks.VASE_LIGHT_BLUE.get(), "minecraft", "block/light_blue_terracotta");
        processVaseVariants(ModBlocks.VASE_YELLOW.get(), "minecraft", "block/yellow_terracotta");
        processVaseVariants(ModBlocks.VASE_LIME.get(), "minecraft", "block/lime_terracotta");
        processVaseVariants(ModBlocks.VASE_PINK.get(), "minecraft", "block/pink_terracotta");
        processVaseVariants(ModBlocks.VASE_GRAY.get(), "minecraft", "block/gray_terracotta");
        processVaseVariants(ModBlocks.VASE_LIGHT_GRAY.get(), "minecraft", "block/light_gray_terracotta");
        processVaseVariants(ModBlocks.VASE_CYAN.get(), "minecraft", "block/cyan_terracotta");
        processVaseVariants(ModBlocks.VASE_PURPLE.get(), "minecraft", "block/purple_terracotta");
        processVaseVariants(ModBlocks.VASE_BLUE.get(), "minecraft", "block/blue_terracotta");
        processVaseVariants(ModBlocks.VASE_BROWN.get(), "minecraft", "block/brown_terracotta");
        processVaseVariants(ModBlocks.VASE_GREEN.get(), "minecraft", "block/green_terracotta");
        processVaseVariants(ModBlocks.VASE_RED.get(), "minecraft", "block/red_terracotta");
        processVaseVariants(ModBlocks.VASE_BLACK.get(), "minecraft", "block/black_terracotta");
        // glazed vases
        processVaseVariants(ModBlocks.VASE_GLAZED_WHITE.get(), MODID, "block/plate_glazed_white");
        processVaseVariants(ModBlocks.VASE_GLAZED_ORANGE.get(), MODID, "block/plate_glazed_orange");
        processVaseVariants(ModBlocks.VASE_GLAZED_MAGENTA.get(), MODID, "block/plate_glazed_magenta");
        processVaseVariants(ModBlocks.VASE_GLAZED_LIGHT_BLUE.get(), MODID, "block/plate_glazed_light_blue");
        processVaseVariants(ModBlocks.VASE_GLAZED_YELLOW.get(), MODID, "block/plate_glazed_yellow");
        processVaseVariants(ModBlocks.VASE_GLAZED_LIME.get(), MODID, "block/plate_glazed_lime");
        processVaseVariants(ModBlocks.VASE_GLAZED_PINK.get(), MODID, "block/plate_glazed_pink");
        processVaseVariants(ModBlocks.VASE_GLAZED_GRAY.get(), MODID, "block/plate_glazed_gray");
        processVaseVariants(ModBlocks.VASE_GLAZED_LIGHT_GRAY.get(), MODID, "block/plate_glazed_light_gray");
        processVaseVariants(ModBlocks.VASE_GLAZED_CYAN.get(), MODID, "block/plate_glazed_cyan");
        processVaseVariants(ModBlocks.VASE_GLAZED_PURPLE.get(), MODID, "block/plate_glazed_purple");
        processVaseVariants(ModBlocks.VASE_GLAZED_BLUE.get(), MODID, "block/plate_glazed_blue");
        processVaseVariants(ModBlocks.VASE_GLAZED_BROWN.get(), MODID, "block/plate_glazed_brown");
        processVaseVariants(ModBlocks.VASE_GLAZED_GREEN.get(), MODID, "block/plate_glazed_green");
        processVaseVariants(ModBlocks.VASE_GLAZED_RED.get(), MODID, "block/plate_glazed_red");
        processVaseVariants(ModBlocks.VASE_GLAZED_BLACK.get(), MODID, "block/plate_glazed_black");
        // jars
        processJarVariants(ModBlocks.JAR_RAW.get(), "minecraft", "block/clay");
        processJarVariants(ModBlocks.JAR_TERRACOTTA.get(), "minecraft", "block/terracotta");
        processJarVariants(ModBlocks.JAR_WHITE.get(), "minecraft", "block/white_terracotta");
        processJarVariants(ModBlocks.JAR_ORANGE.get(), "minecraft", "block/orange_terracotta");
        processJarVariants(ModBlocks.JAR_MAGENTA.get(), "minecraft", "block/magenta_terracotta");
        processJarVariants(ModBlocks.JAR_LIGHT_BLUE.get(), "minecraft", "block/light_blue_terracotta");
        processJarVariants(ModBlocks.JAR_YELLOW.get(), "minecraft", "block/yellow_terracotta");
        processJarVariants(ModBlocks.JAR_LIME.get(), "minecraft", "block/lime_terracotta");
        processJarVariants(ModBlocks.JAR_PINK.get(), "minecraft", "block/pink_terracotta");
        processJarVariants(ModBlocks.JAR_GRAY.get(), "minecraft", "block/gray_terracotta");
        processJarVariants(ModBlocks.JAR_LIGHT_GRAY.get(), "minecraft", "block/light_gray_terracotta");
        processJarVariants(ModBlocks.JAR_CYAN.get(), "minecraft", "block/cyan_terracotta");
        processJarVariants(ModBlocks.JAR_PURPLE.get(), "minecraft", "block/purple_terracotta");
        processJarVariants(ModBlocks.JAR_BLUE.get(), "minecraft", "block/blue_terracotta");
        processJarVariants(ModBlocks.JAR_BROWN.get(), "minecraft", "block/brown_terracotta");
        processJarVariants(ModBlocks.JAR_GREEN.get(), "minecraft", "block/green_terracotta");
        processJarVariants(ModBlocks.JAR_RED.get(), "minecraft", "block/red_terracotta");
        processJarVariants(ModBlocks.JAR_BLACK.get(), "minecraft", "block/black_terracotta");
        // glazed jars
        processJarVariants(ModBlocks.JAR_GLAZED_WHITE.get(), MODID, "block/plate_glazed_white");
        processJarVariants(ModBlocks.JAR_GLAZED_ORANGE.get(), MODID, "block/plate_glazed_orange");
        processJarVariants(ModBlocks.JAR_GLAZED_MAGENTA.get(), MODID, "block/plate_glazed_magenta");
        processJarVariants(ModBlocks.JAR_GLAZED_LIGHT_BLUE.get(), MODID, "block/plate_glazed_light_blue");
        processJarVariants(ModBlocks.JAR_GLAZED_YELLOW.get(), MODID, "block/plate_glazed_yellow");
        processJarVariants(ModBlocks.JAR_GLAZED_LIME.get(), MODID, "block/plate_glazed_lime");
        processJarVariants(ModBlocks.JAR_GLAZED_PINK.get(), MODID, "block/plate_glazed_pink");
        processJarVariants(ModBlocks.JAR_GLAZED_GRAY.get(), MODID, "block/plate_glazed_gray");
        processJarVariants(ModBlocks.JAR_GLAZED_LIGHT_GRAY.get(), MODID, "block/plate_glazed_light_gray");
        processJarVariants(ModBlocks.JAR_GLAZED_CYAN.get(), MODID, "block/plate_glazed_cyan");
        processJarVariants(ModBlocks.JAR_GLAZED_PURPLE.get(), MODID, "block/plate_glazed_purple");
        processJarVariants(ModBlocks.JAR_GLAZED_BLUE.get(), MODID, "block/plate_glazed_blue");
        processJarVariants(ModBlocks.JAR_GLAZED_BROWN.get(), MODID, "block/plate_glazed_brown");
        processJarVariants(ModBlocks.JAR_GLAZED_GREEN.get(), MODID, "block/plate_glazed_green");
        processJarVariants(ModBlocks.JAR_GLAZED_RED.get(), MODID, "block/plate_glazed_red");
        processJarVariants(ModBlocks.JAR_GLAZED_BLACK.get(), MODID, "block/plate_glazed_black");
        // glass jars
        processJarVariants(ModBlocks.JAR_GLASS.get(), "minecraft", "block/glass");
        // stained glass jars
        processJarVariants(ModBlocks.JAR_GLASS_WHITE.get(), "minecraft", "block/white_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_ORANGE.get(), "minecraft", "block/orange_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_MAGENTA.get(), "minecraft", "block/magenta_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_LIGHT_BLUE.get(), "minecraft", "block/light_blue_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_YELLOW.get(), "minecraft", "block/yellow_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_LIME.get(), "minecraft", "block/lime_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_PINK.get(), "minecraft", "block/pink_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_GRAY.get(), "minecraft", "block/gray_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_LIGHT_GRAY.get(), "minecraft", "block/light_gray_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_CYAN.get(), "minecraft", "block/cyan_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_PURPLE.get(), "minecraft", "block/purple_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_BLUE.get(), "minecraft", "block/blue_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_BROWN.get(), "minecraft", "block/brown_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_GREEN.get(), "minecraft", "block/green_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_RED.get(), "minecraft", "block/red_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_BLACK.get(), "minecraft", "block/black_stained_glass");
        processJarVariants(ModBlocks.JAR_GLASS_TINTED.get(), "minecraft", "block/tinted_glass");
        // modded glass jars
        processJarVariants(ModBlocks.JAR_GLASS_REINFORCED.get(), MODID, "block/reinforced_glass");
        processJarVariants(ModBlocks.JAR_GLASS_REDSTONE_INFUSED.get(), MODID, "block/redstone_infused_glass");
        processJarVariants(ModBlocks.JAR_GLASS_GLOWING.get(), MODID, "block/glowing_glass");
        processJarVariants(ModBlocks.JAR_GLASS_SHIFTING.get(), MODID, "block/shifting_glass");
    }

    private @NotNull String blockName(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    // process variants
    @SuppressWarnings("SameParameterValue")
    protected void processJarVariants(Block result, String modid, String path) {
        oneTextureVariant(result, MODID + ":" + "block/jar_block", modid, path);
    }

    @SuppressWarnings("SameParameterValue")
    protected void processVaseVariants(Block result, String modid1, String path1) {
        twoTextureVariant(result, MODID + ":" + "block/vase_block", modid1, path1, "minecraft", "block/rooted_dirt");
    }

    @SuppressWarnings("SameParameterValue")
    protected void processPlateVariants(Block result, String modid, String path) {
        oneTextureVariant(result, MODID + ":" + "block/plate_block", modid, path);
    }

    // texture variants
    @SuppressWarnings("SameParameterValue")
    protected void twoTextureVariant(Block result, String parent, String modid1, String path1, String modid2, String path2) {

        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", new ResourceLocation(modid1, path1))
                .texture("2", new ResourceLocation(modid2, path2))
                .texture("particle", new ResourceLocation(modid1, path1));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }

    @SuppressWarnings("SameParameterValue")
    protected void oneTextureVariant(Block result, String parent, String modid, String path) {

        ModelFile parentModel = new ModelFile.UncheckedModelFile(parent);

        final var model = models()
                .getBuilder(blockName(result)).parent(parentModel)
                .texture("1", new ResourceLocation(modid, path))
                .texture("particle", new ResourceLocation(modid, path));

        horizontalBlock(result, model);
        simpleBlockItem(result, model);
    }
}