package com.github.warrentode.todevillagers.recipes.glassblowing.recipebook;

public enum GlassblowingRecipeBookTab {
    GLASS_WORK("glass_work"),
    RECYCLING("recycling");

    public final String name;

    GlassblowingRecipeBookTab(String name) {
        this.name = name;
    }

    public static GlassblowingRecipeBookTab findByName(String name) {
        for (GlassblowingRecipeBookTab value : values()) {
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