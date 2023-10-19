package com.github.warrentode.todevillagers.recipes;

import com.github.warrentode.todevillagers.recipes.glassblowing.GlassblowingRecipe;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);

    public static final RegistryObject<RecipeSerializer<GlassblowingRecipe>> GLASSBLOWING_SERIALIZER = SERIALIZERS.register("glassblowing", () -> GlassblowingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeType<GlassblowingRecipe>> RECIPE_TYPE_GLASSBLOWING = RECIPE_TYPE.register("glassblowing", () -> GlassblowingRecipe.Type.INSTANCE);

    public static final RecipeBookType GLASSBLOWING_BOOK = RecipeBookType.create("GLASSBLOWING_BOOK");

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPE.register(eventBus);
    }
}