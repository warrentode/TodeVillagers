package com.github.warrentode.todevillagers.datagen.tags;

import com.github.warrentode.todevillagers.villagers.ModVillagers;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class PoiTypeTagsGen extends PoiTypeTagsProvider {
    public PoiTypeTagsGen(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(ModVillagers.DJ_POI.getId())
                .addOptional(ModVillagers.TRADER_POI.getId())
                .addOptional(ModVillagers.GLASSBLOWING_POI.getId());
    }
}