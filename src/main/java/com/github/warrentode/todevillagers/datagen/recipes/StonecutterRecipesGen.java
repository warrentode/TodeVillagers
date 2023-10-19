package com.github.warrentode.todevillagers.datagen.recipes;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.utils.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class StonecutterRecipesGen extends RecipeProvider implements IConditionBuilder {
    public StonecutterRecipesGen(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        createRecycleGlassRecipes(consumer);
        createGlassCuttingRecipes(consumer);
    }

    private static void createGlassCuttingRecipes(Consumer<FinishedRecipe> consumer) {
        // glowing glass
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_BUTTON.get(), 6)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/button"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_DOOR.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/door"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_FENCE.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/fence"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_FENCE_GATE.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/fence_gate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_PANE.get(), 3)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/pane"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/pressure_plate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_SLAB.get(), 2)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/slab"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_STAIRS.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/stairs"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_TRAPDOOR.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/trapdoor"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.GLOWING_GLASS.get()), ModBlocks.GLOWING_GLASS_WALL.get(), 1)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/glowing/wall"));
        // reinforced glass
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_BUTTON.get(), 6)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/button"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_DOOR.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/door"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_FENCE.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/fence"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_FENCE_GATE.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/fence_gate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_PANE.get(), 3)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/pane"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/pressure_plate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_SLAB.get(), 2)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/slab"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_STAIRS.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/stairs"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_TRAPDOOR.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/trapdoor"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.REINFORCED_GLASS.get()), ModBlocks.REINFORCED_GLASS_WALL.get(), 1)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/reinforced/wall"));
        // shifting glass
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_BUTTON.get(), 6)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/button"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_DOOR.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/door"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_FENCE.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/fence"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_FENCE_GATE.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/fence_gate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_PANE.get(), 3)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/pane"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/pressure_plate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_SLAB.get(), 2)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/slab"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_STAIRS.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/stairs"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_TRAPDOOR.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/trapdoor"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SHIFTING_GLASS.get()), ModBlocks.SHIFTING_GLASS_WALL.get(), 1)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/shifting/wall"));
        // tinted glass
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_BUTTON.get(), 6)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/button"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_DOOR.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/door"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_FENCE.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/fence"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_FENCE_GATE.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/fence_gate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_PANE.get(), 3)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/pane"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/pressure_plate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_SLAB.get(), 2)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/slab"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_STAIRS.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/stairs"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_TRAPDOOR.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/trapdoor"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TINTED_GLASS), ModBlocks.TINTED_GLASS_WALL.get(), 1)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/glass_cutting/tinted/wall"));
    }

    private static void createRecycleGlassRecipes(Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GLASS_BOTTLE), ModItems.CRUSHED_GLASS.get(), 1)
                .unlockedBy("has_glass_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS_BOTTLE))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_bottle"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS), ModItems.CRUSHED_GLASS.get(), 1)
                .unlockedBy("has_glass", has(ModTags.Items.GLASS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_blocks"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_PANES), ModItems.CRUSHED_GLASS.get(), 1)
                .unlockedBy("has_glass_pane", has(ModTags.Items.GLASS_PANES))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_panes"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_BUTTONS), ModItems.CRUSHED_GLASS.get(), 1)
                .unlockedBy("has_glass_button", has(ModTags.Items.GLASS_BUTTONS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_buttons"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_STAIRS), ModItems.CRUSHED_GLASS.get(), 1)
                .unlockedBy("has_glass_stairs", has(ModTags.Items.GLASS_STAIRS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_stairs"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_WALLS), ModItems.CRUSHED_GLASS.get(), 1)
                .unlockedBy("has_glass_walls", has(ModTags.Items.GLASS_WALLS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_walls"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_DOORS), ModItems.CRUSHED_GLASS.get(), 2)
                .unlockedBy("has_glass_doors", has(ModTags.Items.GLASS_DOORS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_doors"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_FENCES), ModItems.CRUSHED_GLASS.get(), 2)
                .unlockedBy("has_glass_fences", has(ModTags.Items.GLASS_FENCES))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_fences"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_FENCES), ModItems.CRUSHED_GLASS.get(), 2)
                .unlockedBy("has_glass_fence_gates", has(ModTags.Items.GLASS_FENCE_GATES))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_fence_gates"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_PRESSURE_PLATES), ModItems.CRUSHED_GLASS.get(), 2)
                .unlockedBy("has_glass_pressure_plates", has(ModTags.Items.GLASS_PRESSURE_PLATES))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_pressure_plates"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_SLABS), ModItems.CRUSHED_GLASS.get(), 2)
                .unlockedBy("has_glass_slabs", has(ModTags.Items.GLASS_SLABS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_slabs"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModTags.Items.GLASS_TRAPDOORS), ModItems.CRUSHED_GLASS.get(), 3)
                .unlockedBy("has_glass_trapdoors", has(ModTags.Items.GLASS_TRAPDOORS))
                .save(consumer, new ResourceLocation(MODID, "stonecutter/recycle_glass/glass_trapdoors"));
    }
}