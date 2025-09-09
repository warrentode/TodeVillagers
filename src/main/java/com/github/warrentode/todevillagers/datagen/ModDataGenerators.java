package com.github.warrentode.todevillagers.datagen;

import com.github.warrentode.todevillagers.datagen.models.BlockStateGen;
import com.github.warrentode.todevillagers.datagen.tags.BlockTagsGen;
import com.github.warrentode.todevillagers.datagen.tags.ItemTagsGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        BlockTagsGen blockTagsGen = new BlockTagsGen(packOutput, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTagsGen);

        ItemTagsGen itemTagsGen = new ItemTagsGen(packOutput, lookupProvider, blockTagsGen.contentsGetter(), helper);
        generator.addProvider(event.includeServer(), itemTagsGen);

        generator.addProvider(event.includeServer(), new BlockStateGen(packOutput, MODID, helper));

        generator.addProvider(event.includeClient(), new LanguageFileGen(packOutput, MODID, "en_us"));

        generator.addProvider(event.includeServer(), new RecipesGen(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableGenProvider.create(packOutput));
    }
}