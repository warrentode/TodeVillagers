package com.github.warrentode.todevillagers.datagen;

import com.github.warrentode.todevillagers.datagen.tags.BlockTagsGen;
import com.github.warrentode.todevillagers.datagen.tags.ItemTagsGen;
import com.github.warrentode.todevillagers.datagen.tags.PoiTypeTagsGen;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        BlockTagsGen blockTagsGen = new BlockTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), blockTagsGen);

        ItemTagsGen itemTagsGen = new ItemTagsGen(generator, blockTagsGen, MODID, helper);
        generator.addProvider(event.includeServer(), itemTagsGen);

        PoiTypeTagsGen poiTypeTagsGen = new PoiTypeTagsGen(generator, MODID, helper);
        generator.addProvider(event.includeServer(), poiTypeTagsGen);

        generator.addProvider(event.includeClient(), new LanguageFileGen(generator, MODID, "en_us"));

        generator.addProvider(event.includeServer(), new RecipesGen(generator));
        generator.addProvider(event.includeServer(), new ModLootTableGenProvider(generator));
    }
}