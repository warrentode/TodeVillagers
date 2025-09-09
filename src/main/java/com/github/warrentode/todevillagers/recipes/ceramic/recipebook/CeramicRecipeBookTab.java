package com.github.warrentode.todevillagers.recipes.ceramic.recipebook;

import org.jetbrains.annotations.Nullable;

public enum CeramicRecipeBookTab {
    CERAMICS("ceramics"),
    GLAZING("glazing"),
    FIRING("firing");

    public final String name;

    CeramicRecipeBookTab(String name) {
        this.name = name;
    }

    public static @Nullable CeramicRecipeBookTab findByName(String name) {
        for (CeramicRecipeBookTab value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}