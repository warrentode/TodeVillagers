package com.github.warrentode.todevillagers.datagen;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.utils.ModCreativeModeTab;
import com.github.warrentode.todevillagers.villagers.ModVillagers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Map;
import java.util.TreeMap;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class LanguageFileGen extends LanguageProvider {
    @SuppressWarnings("unused")
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    @SuppressWarnings("unused")
    private final Map<String, String> data = new TreeMap<>();
    @SuppressWarnings("unused")
    private final PackOutput packOutput;
    @SuppressWarnings("unused")
    private final String modid;
    @SuppressWarnings("unused")
    private final String locale;

    @SuppressWarnings("unused")
    public LanguageFileGen(PackOutput packOutput, String modid, String locale) {
        super(packOutput, MODID, locale);
        this.packOutput = packOutput;
        this.modid = modid;
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        addEntities();
        addSubtitles();
        addItems();
        addDescriptions();
        addTooltips();
        addBlocks();
        addContainers();
        addItemGroups();
    }

    private void addItemGroups() {
        add("itemGroup." + ModCreativeModeTab.TODEVILLAGERS_TAB.getId().getPath(), "TodeVillagers Tab");
        add("itemGroup." + ModCreativeModeTab.TODEVILLAGERS_GLASS_TAB.getId().getPath(), "Glassblowing Tab");
    }

    private void addContainers() {
        add("container." + MODID + "." + ModBlocks.GLASS_KILN_BLOCK.getId().getPath(), "Glass Kiln");
        add("container.recipe_book.glassblowing", "Glassblowing Recipe Book");
        add("container.glass_kiln_block_gui", "Glass Kiln Menu");
    }

    private void addBlocks() {
        add("block." + MODID + "." + ModBlocks.CERAMICS_TABLE.getId().getPath(), "Ceramics Table");
        add("block." + MODID + "." + ModBlocks.GLASS_KILN_BLOCK.getId().getPath(), "Glass Kiln");
        add("block." + MODID + "." + ModBlocks.WHEEL_CART.getId().getPath(), "Wheel Cart");
        add("block." + MODID + "." + ModBlocks.REDSTONE_INFUSED_GLASS.getId().getPath(), "Redstone Infused Glass");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS.getId().getPath(), "Reinforced Glass");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_BUTTON.getId().getPath(), "Reinforced Glass Button");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_DOOR.getId().getPath(), "Reinforced Glass Door");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_FENCE.getId().getPath(), "Reinforced Glass Fence");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_FENCE_GATE.getId().getPath(), "Reinforced Glass Fence Gate");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_PANE.getId().getPath(), "Reinforced Glass Pane");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.getId().getPath(), "Reinforced Glass Pressure Plate");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_SLAB.getId().getPath(), "Reinforced Glass Slab");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_STAIRS.getId().getPath(), "Reinforced Glass Stairs");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_TRAPDOOR.getId().getPath(), "Reinforced Glass Trapdoor");
        add("block." + MODID + "." + ModBlocks.REINFORCED_GLASS_WALL.getId().getPath(), "Reinforced Glass Wall");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS.getId().getPath(), "Glowing Glass");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_BUTTON.getId().getPath(), "Glowing Glass Button");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_DOOR.getId().getPath(), "Glowing Glass Door");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_FENCE.getId().getPath(), "Glowing Glass Fence");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_FENCE_GATE.getId().getPath(), "Glowing Glass Fence Gate");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_PANE.getId().getPath(), "Glowing Glass Pane");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.getId().getPath(), "Glowing Glass Pressure Plate");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_SLAB.getId().getPath(), "Glowing Glass Slab");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_STAIRS.getId().getPath(), "Glowing Glass Stairs");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_TRAPDOOR.getId().getPath(), "Glowing Glass Trapdoor");
        add("block." + MODID + "." + ModBlocks.GLOWING_GLASS_WALL.getId().getPath(), "Glowing Glass Wall");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS.getId().getPath(), "Shifting Glass");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_BUTTON.getId().getPath(), "Shifting Glass Button");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_DOOR.getId().getPath(), "Shifting Glass Door");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_FENCE.getId().getPath(), "Shifting Glass Fence");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_FENCE_GATE.getId().getPath(), "Shifting Glass Fence Gate");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_PANE.getId().getPath(), "Shifting Glass Pane");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.getId().getPath(), "Shifting Glass Pressure Plate");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_SLAB.getId().getPath(), "Shifting Glass Slab");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_STAIRS.getId().getPath(), "Shifting Glass Stairs");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_TRAPDOOR.getId().getPath(), "Shifting Glass Trapdoor");
        add("block." + MODID + "." + ModBlocks.SHIFTING_GLASS_WALL.getId().getPath(), "Shifting Glass Wall");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_BUTTON.getId().getPath(), "Tinted Glass Button");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_DOOR.getId().getPath(), "Tinted Glass Door");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_FENCE.getId().getPath(), "Tinted Glass Fence");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_FENCE_GATE.getId().getPath(), "Tinted Glass Fence Gate");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_PANE.getId().getPath(), "Tinted Glass Pane");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_PRESSURE_PLATE.getId().getPath(), "Tinted Glass Pressure Plate");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_SLAB.getId().getPath(), "Tinted Glass Slab");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_STAIRS.getId().getPath(), "Tinted Glass Stairs");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_TRAPDOOR.getId().getPath(), "Tinted Glass Trapdoor");
        add("block." + MODID + "." + ModBlocks.TINTED_GLASS_WALL.getId().getPath(), "Tinted Glass Wall");
    }

    private void addTooltips() {
        add("tooltips." + MODID + "." + ModItems.CHAKRA_DREAM_MUSIC_DISC.getId().getPath(), "Composed with Muse Score");
        add("tooltips." + MODID + "." + ModItems.MARVER.getId().getPath(), "A glassblowing tool to shape hot glass");
        add("tooltips." + MODID + "." + ModItems.GLASSBLOWING_PIPE.getId().getPath(), "A glassblowing tool to blow hot glass");
        add("tooltips." + MODID + "." + ModItems.GLASSBLOWER_SHEARS.getId().getPath(), "A glassblowing tool to cut hot glass");
        add("tooltips." + MODID + "." + ModItems.CRUSHED_GLASS.getId().getPath(), "Ready for recycling.");
        add("tooltips." + MODID + "." + ModBlocks.WHEEL_CART.getId().getPath(), "Transports goods for someone.");
    }

    private void addDescriptions() {
        add("item." + MODID + "." + ModItems.CHAKRA_DREAM_MUSIC_DISC.getId().getPath() + ".desc", "Chakra Dream by Warren Tode © 2019 (CC BY-NC-ND 4.0)");
    }

    private void addItems() {
        add("item." + MODID + "." + ModItems.CHAKRA_DREAM_MUSIC_DISC.getId().getPath(), "Chakra Dream Music Disc");
        add("item." + MODID + "." + ModItems.MARVER.getId().getPath(), "Glassblowing Marver");
        add("item." + MODID + "." + ModItems.GLASSBLOWING_PIPE.getId().getPath(), "Glassblowing Pipe");
        add("item." + MODID + "." + ModItems.GLASSBLOWER_SHEARS.getId().getPath(), "Glassblowing Shears");
        add("item." + MODID + "." + ModItems.CRUSHED_GLASS.getId().getPath(), "Crushed Glass");
    }

    private void addSubtitles() {
        add("subtitles." + MODID + ".work_dj", "Disc Jockey Works");
        add("subtitles." + MODID + ".work_glassblower", "Glassblower Works");
        add("subtitles." + MODID + ".work_retired_trader", "Retired Trader Works");
        add("subtitles." + MODID + ".work_potter", "Potter Works");
    }

    private void addEntities() {
        add("entity.minecraft.villager." + MODID + "." + ModVillagers.DISC_JOCKEY.getId().getPath(), "Disc Jockey");
        add("entity.minecraft.villager." + MODID + "." + ModVillagers.GLASSBLOWER.getId().getPath(), "Glassblower");
        add("entity.minecraft.villager." + MODID + "." + ModVillagers.RETIRED_TRADER.getId().getPath(), "Retired Trader");
        add("entity.minecraft.villager." + MODID + "." + ModVillagers.POTTER.getId().getPath(), "Potter");
    }
}