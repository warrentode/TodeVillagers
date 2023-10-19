package com.github.warrentode.todevillagers.datagen.tags;

import com.github.warrentode.todevillagers.villagers.ModVillagers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PoiTypeTagsGen extends PoiTypeTagsProvider {
    public PoiTypeTagsGen(DataGenerator pGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(net.minecraft.tags.PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .add(ModVillagers.DJ_POI.get())
                .add(ModVillagers.TRADER_POI.get())
                .add(ModVillagers.GLASSBLOWING_POI.get());
    }
}