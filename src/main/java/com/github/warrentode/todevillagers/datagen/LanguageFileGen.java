package com.github.warrentode.todevillagers.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Map;
import java.util.TreeMap;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class LanguageFileGen extends LanguageProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().setLenient().create();
    private final Map<String, String> data = new TreeMap<>();
    private final DataGenerator generator;
    private final String modid;
    private final String locale;

    public LanguageFileGen(DataGenerator generator, String modid, String locale) {
        super(generator, MODID, locale);
        this.generator = generator;
        this.modid = modid;
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {

    }
}