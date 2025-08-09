package com.github.warrentode.todevillagers.datagen.recipes;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class CraftingRecipesGen extends RecipeProvider implements IConditionBuilder {
    public CraftingRecipesGen(@NotNull DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        register(consumer);
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        jobBlockRecipes(consumer);
        glassblowingTools(consumer);
        craftingGlass(consumer);
    }

    @SuppressWarnings("CommentedOutCode") // recipes I need to fix or change
    private static void craftingGlass(Consumer<FinishedRecipe> consumer) {
        // redstone infused glass

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REDSTONE_INFUSED_GLASS.get(), 2)
                .pattern(" I ")
                .pattern("IGI")
                .pattern(" I ")
                .define('I', Items.REDSTONE)
                .define('G', Items.GLASS)
                .unlockedBy("has_redstone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.REDSTONE))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/infused/redstone"));
        // glowing glass

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS.get(), 2)
                .pattern(" I ")
                .pattern("IGI")
                .pattern(" I ")
                .define('I', Items.GLOW_INK_SAC)
                .define('G', Items.GLASS)
                .unlockedBy("has_glow_ink", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOW_INK_SAC))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/glow_ink"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS.get(), 2)
                .pattern(" I ")
                .pattern("IGI")
                .pattern(" I ")
                .define('I', Items.GLOWSTONE_DUST)
                .define('G', Items.GLASS)
                .unlockedBy("has_glowstone_dust", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLOWSTONE_DUST))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/glowstone_dust"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_BUTTON.get(), 1)
                .requires(ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/button"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_DOOR.get(), 3)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/door"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_FENCE.get(), 3)
                .pattern("#S#")
                .pattern("#S#")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_FENCE_GATE.get(), 1)
                .pattern("S#S")
                .pattern("S#S")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/fence_gate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_PANE.get(), 16)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/pane"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_PRESSURE_PLATE.get(), 1)
                .pattern("## ")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/pressure_plate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS_TRAPDOOR.get(), 2)
                .pattern("## ")
                .pattern("## ")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/trapdoor"));

        /*
        ShapedRecipeBuilder.shaped(ModBlocks.GLOWING_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define('#', ModBlocks.GLOWING_GLASS.get())
                .define('X', ModItems.MARVER.get())
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/wall"));
         */

        // reinforced glass

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS.get(), 2)
                .pattern(" I ")
                .pattern("IGI")
                .pattern(" I ")
                .define('I', Items.QUARTZ)
                .define('G', Items.GLASS)
                .unlockedBy("has_quartz", InventoryChangeTrigger.TriggerInstance.hasItems(Items.QUARTZ))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/quartz"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_BUTTON.get(), 1)
                .requires(ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/button"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_DOOR.get(), 3)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/door"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_FENCE.get(), 3)
                .pattern("#S#")
                .pattern("#S#")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_FENCE_GATE.get(), 1)
                .pattern("S#S")
                .pattern("S#S")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/fence_gate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_PANE.get(), 16)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/pane"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_PRESSURE_PLATE.get(), 1)
                .pattern("## ")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/pressure_plate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_GLASS_TRAPDOOR.get(), 2)
                .pattern("## ")
                .pattern("## ")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/trapdoor"));

        /*
        ShapedRecipeBuilder.shaped(ModBlocks.REINFORCED_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define('#', ModBlocks.REINFORCED_GLASS.get())
                .define('X', ModItems.MARVER.get())
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.REINFORCED_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/wall"));
        */

        // shifting glass

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS.get(), 2)
                .pattern(" I ")
                .pattern("IGI")
                .pattern(" I ")
                .define('I', Items.PRISMARINE_CRYSTALS)
                .define('G', Items.GLASS)
                .unlockedBy("has_prismarine_crystals", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PRISMARINE_CRYSTALS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/prismarine_crystals"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_BUTTON.get(), 1)
                .requires(ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/button"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_DOOR.get(), 3)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/door"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_FENCE.get(), 3)
                .pattern("#S#")
                .pattern("#S#")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_FENCE_GATE.get(), 1)
                .pattern("S#S")
                .pattern("S#S")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .define('S', Items.STICK)
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/fence_gate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_PANE.get(), 16)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/pane"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_PRESSURE_PLATE.get(), 1)
                .pattern("## ")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/pressure_plate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SHIFTING_GLASS_TRAPDOOR.get(), 2)
                .pattern("## ")
                .pattern("## ")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/trapdoor"));

        /*
        ShapedRecipeBuilder.shaped(ModBlocks.SHIFTING_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define('#', ModBlocks.SHIFTING_GLASS.get())
                .define('X', ModItems.MARVER.get())
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.SHIFTING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/wall"));
        */

        // tinted glass

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_BUTTON.get(), 1)
                .requires(Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/button"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_DOOR.get(), 3)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .define('#', Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/door"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_FENCE.get(), 3)
                .pattern("#S#")
                .pattern("#S#")
                .define('#', Blocks.TINTED_GLASS)
                .define('S', Items.STICK)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/fence"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_FENCE_GATE.get(), 1)
                .pattern("S#S")
                .pattern("S#S")
                .define('#', Blocks.TINTED_GLASS)
                .define('S', Items.STICK)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/fence_gate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_PANE.get(), 16)
                .pattern("###")
                .pattern("###")
                .define('#', Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/pane"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_PRESSURE_PLATE.get(), 1)
                .pattern("## ")
                .define('#', Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/pressure_plate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_SLAB.get(), 6)
                .pattern("###")
                .define('#', Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/stairs"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TINTED_GLASS_TRAPDOOR.get(), 2)
                .pattern("## ")
                .pattern("## ")
                .define('#', Blocks.TINTED_GLASS)
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/trapdoor"));

        /*
        ShapedRecipeBuilder.shaped(ModBlocks.TINTED_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define('#', Blocks.TINTED_GLASS)
                .define('X', ModItems.MARVER.get())
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/wall"));
         */
    }

    private static void glassblowingTools(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MARVER.get(), 1)
                .pattern("I")
                .pattern("B")
                .pattern("S")
                .define('I', Items.IRON_INGOT)
                .define('B', Items.IRON_BARS)
                .define('S', Items.STICK)
                .unlockedBy("has_iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer, new ResourceLocation(MODID, "crafting/glassblower_tools/marver"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GLASSBLOWER_SHEARS.get(), 1)
                .pattern("S")
                .pattern("I")
                .pattern("I")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.SHEARS)
                .unlockedBy("has_shears", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SHEARS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glassblower_tools/glassblower_shears"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GLASSBLOWING_PIPE.get(), 1)
                .pattern("B")
                .pattern("I")
                .define('B', Items.IRON_BARS)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_bars", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_BARS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glassblower_tools/glassblowing_pipe"));
    }

    private static void jobBlockRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GLASS_KILN_BLOCK.get(), 1)
                .pattern("III")
                .pattern("DFD")
                .pattern("DDD")
                .define('I', Items.IRON_INGOT)
                .define('F', Items.FURNACE)
                .define('D', Items.DEEPSLATE_BRICKS)
                .unlockedBy("has_deepslate_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DEEPSLATE_BRICKS))
                .save(consumer, new ResourceLocation(MODID, "crafting/job_blocks/glass_kiln"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WHEEL_CART.get(), 1)
                .pattern("F F")
                .pattern("LLL")
                .pattern("W W")
                .define('F', ItemTags.WOODEN_FENCES)
                .define('L', ItemTags.LOGS)
                .define('W', ItemTags.WOODEN_TRAPDOORS)
                .unlockedBy("has_logs", has(ItemTags.LOGS))
                .save(consumer, new ResourceLocation(MODID, "crafting/job_blocks/wheel_cart"));
    }
}