package com.github.warrentode.todevillagers.datagen.recipes;

import com.github.warrentode.todevillagers.block.ModBlocks;
import com.github.warrentode.todevillagers.datagen.recipes.builder.RemainderShapedRecipeBuilder;
import com.github.warrentode.todevillagers.datagen.recipes.builder.RemainderShapelessRecipeBuilder;
import com.github.warrentode.todevillagers.item.ModItems;
import com.github.warrentode.todevillagers.utils.ModTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
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
        potterRecipes(consumer);
    }

    private static void potterRecipes(Consumer<FinishedRecipe> consumer) {
        RemainderShapelessRecipeBuilder.shapelessRemainderRecipe(RecipeCategory.DECORATIONS, ModBlocks.VASE_RAW.get(), 1)
                .addIngredient(Items.CLAY)
                .addIngredient(ModTags.Items.TOOLS_KNIVES)
                .unlockedBy("has_knife", has(ModTags.Items.TOOLS_KNIVES))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/" + getItemName(ModBlocks.VASE_RAW.get())));
        RemainderShapedRecipeBuilder.shapedRemainderRecipe(ModBlocks.JAR_RAW.get(), 1)
                .pattern("X#X")
                .pattern(" X ")
                .define("#", Ingredient.of(ModTags.Items.TOOLS_KNIVES))
                .define("X", Ingredient.of(Items.CLAY))
                .define("X", Ingredient.of(Items.CLAY))
                .define("X", Ingredient.of(Items.CLAY))
                .unlockedBy("has_knife", has(ModTags.Items.TOOLS_KNIVES))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/" + getItemName(ModBlocks.JAR_RAW.get())));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CERAMIC_HELMET.get())
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('#', Items.LEATHER_HELMET)
                .define('X', ModItems.CERAMIC_CHIP.get())
                .unlockedBy("has_ceramic_chip", has(ModItems.CERAMIC_CHIP.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/ceramimc_helmet"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CERAMIC_CHESPLATE.get())
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('#', Items.LEATHER_CHESTPLATE)
                .define('X', ModItems.CERAMIC_CHIP.get())
                .unlockedBy("has_ceramic_chip", has(ModItems.CERAMIC_CHIP.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/ceramimc_chestplate"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CERAMIC_LEGGINGS.get())
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('#', Items.LEATHER_LEGGINGS)
                .define('X', ModItems.CERAMIC_CHIP.get())
                .unlockedBy("has_ceramic_chip", has(ModItems.CERAMIC_CHIP.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/ceramimc_leggings"));
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CERAMIC_BOOTS.get())
                .pattern(" X ")
                .pattern("X#X")
                .pattern(" X ")
                .define('#', Items.LEATHER_BOOTS)
                .define('X', ModItems.CERAMIC_CHIP.get())
                .unlockedBy("has_ceramic_chip", has(ModItems.CERAMIC_CHIP.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/ceramimc_boots"));
        RemainderShapelessRecipeBuilder.shapelessRemainderRecipe(RecipeCategory.MISC, ModItems.CERAMIC_CHIP.get(), 4)
                .addIngredient(Items.BRICK)
                .addIngredient(ModItems.CHISEL_IRON.get())
                .unlockedBy("has_brick", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BRICK))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/ceramic_chip"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL_IRON.get())
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('#', Items.STICK)
                .define('X', Tags.Items.NUGGETS_IRON)
                .unlockedBy("has_iron_nugget", has(Tags.Items.NUGGETS_IRON))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/chisel_iron"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KNIFE_CERAMIC.get())
                .pattern("X")
                .pattern("#")
                .define('#', Items.STICK)
                .define('X', ModItems.CERAMIC_CHIP.get())
                .unlockedBy("has_ceramic_chip", has(ModItems.CERAMIC_CHIP.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/knife_ceramic"));
        // plate recipes
        plateRecipes(consumer, Items.TERRACOTTA, ModBlocks.PLATE_TERRACOTTA.get().asItem());
        plateRecipes(consumer, Items.WHITE_TERRACOTTA, ModBlocks.PLATE_WHITE.get().asItem());
        plateRecipes(consumer, Items.ORANGE_TERRACOTTA, ModBlocks.PLATE_ORANGE.get().asItem());
        plateRecipes(consumer, Items.MAGENTA_TERRACOTTA, ModBlocks.PLATE_MAGENTA.get().asItem());
        plateRecipes(consumer, Items.LIGHT_BLUE_TERRACOTTA, ModBlocks.PLATE_LIGHT_BLUE.get().asItem());
        plateRecipes(consumer, Items.YELLOW_TERRACOTTA, ModBlocks.PLATE_YELLOW.get().asItem());
        plateRecipes(consumer, Items.LIME_TERRACOTTA, ModBlocks.PLATE_LIME.get().asItem());
        plateRecipes(consumer, Items.PINK_TERRACOTTA, ModBlocks.PLATE_PINK.get().asItem());
        plateRecipes(consumer, Items.GRAY_TERRACOTTA, ModBlocks.PLATE_GRAY.get().asItem());
        plateRecipes(consumer, Items.LIGHT_GRAY_TERRACOTTA, ModBlocks.PLATE_LIGHT_GRAY.get().asItem());
        plateRecipes(consumer, Items.CYAN_TERRACOTTA, ModBlocks.PLATE_CYAN.get().asItem());
        plateRecipes(consumer, Items.PURPLE_TERRACOTTA, ModBlocks.PLATE_PURPLE.get().asItem());
        plateRecipes(consumer, Items.BLUE_TERRACOTTA, ModBlocks.PLATE_BLUE.get().asItem());
        plateRecipes(consumer, Items.BROWN_TERRACOTTA, ModBlocks.PLATE_BROWN.get().asItem());
        plateRecipes(consumer, Items.GREEN_TERRACOTTA, ModBlocks.PLATE_GREEN.get().asItem());
        plateRecipes(consumer, Items.RED_TERRACOTTA, ModBlocks.PLATE_RED.get().asItem());
        plateRecipes(consumer, Items.BLACK_TERRACOTTA, ModBlocks.PLATE_BLACK.get().asItem());
        // glazed plate recipes
        plateRecipes(consumer, Items.WHITE_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_WHITE.get().asItem());
        plateRecipes(consumer, Items.ORANGE_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_ORANGE.get().asItem());
        plateRecipes(consumer, Items.MAGENTA_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_MAGENTA.get().asItem());
        plateRecipes(consumer, Items.LIGHT_BLUE_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_LIGHT_BLUE.get().asItem());
        plateRecipes(consumer, Items.YELLOW_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_YELLOW.get().asItem());
        plateRecipes(consumer, Items.LIME_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_LIME.get().asItem());
        plateRecipes(consumer, Items.PINK_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_PINK.get().asItem());
        plateRecipes(consumer, Items.GRAY_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_GRAY.get().asItem());
        plateRecipes(consumer, Items.LIGHT_GRAY_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_LIGHT_GRAY.get().asItem());
        plateRecipes(consumer, Items.CYAN_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_CYAN.get().asItem());
        plateRecipes(consumer, Items.PURPLE_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_PURPLE.get().asItem());
        plateRecipes(consumer, Items.BLUE_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_BLUE.get().asItem());
        plateRecipes(consumer, Items.BROWN_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_BROWN.get().asItem());
        plateRecipes(consumer, Items.GREEN_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_GREEN.get().asItem());
        plateRecipes(consumer, Items.RED_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_RED.get().asItem());
        plateRecipes(consumer, Items.BLACK_GLAZED_TERRACOTTA, ModBlocks.PLATE_GLAZED_BLACK.get().asItem());
        // colored vase recipes
        coloredVaseRecipes(consumer, Items.WHITE_DYE, ModBlocks.VASE_WHITE.get().asItem());
        coloredVaseRecipes(consumer, Items.ORANGE_DYE, ModBlocks.VASE_ORANGE.get().asItem());
        coloredVaseRecipes(consumer, Items.MAGENTA_DYE, ModBlocks.VASE_MAGENTA.get().asItem());
        coloredVaseRecipes(consumer, Items.LIGHT_BLUE_DYE, ModBlocks.VASE_LIGHT_BLUE.get().asItem());
        coloredVaseRecipes(consumer, Items.YELLOW_DYE, ModBlocks.VASE_YELLOW.get().asItem());
        coloredVaseRecipes(consumer, Items.LIME_DYE, ModBlocks.VASE_LIME.get().asItem());
        coloredVaseRecipes(consumer, Items.PINK_DYE, ModBlocks.VASE_PINK.get().asItem());
        coloredVaseRecipes(consumer, Items.GRAY_DYE, ModBlocks.VASE_GRAY.get().asItem());
        coloredVaseRecipes(consumer, Items.LIGHT_GRAY_DYE, ModBlocks.VASE_LIGHT_GRAY.get().asItem());
        coloredVaseRecipes(consumer, Items.CYAN_DYE, ModBlocks.VASE_CYAN.get().asItem());
        coloredVaseRecipes(consumer, Items.PURPLE_DYE, ModBlocks.VASE_PURPLE.get().asItem());
        coloredVaseRecipes(consumer, Items.BLUE_DYE, ModBlocks.VASE_BLUE.get().asItem());
        coloredVaseRecipes(consumer, Items.BROWN_DYE, ModBlocks.VASE_BROWN.get().asItem());
        coloredVaseRecipes(consumer, Items.GREEN_DYE, ModBlocks.VASE_GREEN.get().asItem());
        coloredVaseRecipes(consumer, Items.RED_DYE, ModBlocks.VASE_RED.get().asItem());
        coloredVaseRecipes(consumer, Items.BLACK_DYE, ModBlocks.VASE_BLACK.get().asItem());
        // colored jar recipes
        coloredJarRecipes(consumer, Items.WHITE_DYE, ModBlocks.JAR_WHITE.get().asItem());
        coloredJarRecipes(consumer, Items.ORANGE_DYE, ModBlocks.JAR_ORANGE.get().asItem());
        coloredJarRecipes(consumer, Items.MAGENTA_DYE, ModBlocks.JAR_MAGENTA.get().asItem());
        coloredJarRecipes(consumer, Items.LIGHT_BLUE_DYE, ModBlocks.JAR_LIGHT_BLUE.get().asItem());
        coloredJarRecipes(consumer, Items.YELLOW_DYE, ModBlocks.JAR_YELLOW.get().asItem());
        coloredJarRecipes(consumer, Items.LIME_DYE, ModBlocks.JAR_LIME.get().asItem());
        coloredJarRecipes(consumer, Items.PINK_DYE, ModBlocks.JAR_PINK.get().asItem());
        coloredJarRecipes(consumer, Items.GRAY_DYE, ModBlocks.JAR_GRAY.get().asItem());
        coloredJarRecipes(consumer, Items.LIGHT_GRAY_DYE, ModBlocks.JAR_LIGHT_GRAY.get().asItem());
        coloredJarRecipes(consumer, Items.CYAN_DYE, ModBlocks.JAR_CYAN.get().asItem());
        coloredJarRecipes(consumer, Items.PURPLE_DYE, ModBlocks.JAR_PURPLE.get().asItem());
        coloredJarRecipes(consumer, Items.BLUE_DYE, ModBlocks.JAR_BLUE.get().asItem());
        coloredJarRecipes(consumer, Items.BROWN_DYE, ModBlocks.JAR_BROWN.get().asItem());
        coloredJarRecipes(consumer, Items.GREEN_DYE, ModBlocks.JAR_GREEN.get().asItem());
        coloredJarRecipes(consumer, Items.RED_DYE, ModBlocks.JAR_RED.get().asItem());
        coloredJarRecipes(consumer, Items.BLACK_DYE, ModBlocks.JAR_BLACK.get().asItem());
    }

    private static void coloredJarRecipes(Consumer<FinishedRecipe> consumer, Item dye, @NotNull Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 8)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .define('#', dye)
                .define('X', ModBlocks.JAR_TERRACOTTA.get())
                .unlockedBy("has_jar", has(ModBlocks.JAR_TERRACOTTA.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/" + getItemName(result)));
    }

    private static void coloredVaseRecipes(Consumer<FinishedRecipe> consumer, Item dye, @NotNull Item result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, result, 8)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("XXX")
                .define('#', dye)
                .define('X', ModBlocks.VASE_TERRACOTTA.get())
                .unlockedBy("has_vase", has(ModBlocks.VASE_TERRACOTTA.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/" + getItemName(result)));
    }

    private static void plateRecipes(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
        RemainderShapelessRecipeBuilder.shapelessRemainderRecipe(RecipeCategory.DECORATIONS, result, 4)
                .addIngredient(ingredient)
                .addIngredient(ModItems.CHISEL_IRON.get())
                .unlockedBy("has_" + getItemName(ingredient),
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CHISEL_IRON.get(), ingredient))
                .save(consumer, new ResourceLocation(MODID, "crafting/ceramic/" + getItemName(result)));
    }

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

        RemainderShapedRecipeBuilder.shapedRemainderRecipe(ModBlocks.GLOWING_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define("#", Ingredient.of(ModBlocks.GLOWING_GLASS.get()))
                .define("X", Ingredient.of(ModItems.MARVER.get()))
                .unlockedBy("has_glowing_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/glowing/wall"));

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

        RemainderShapedRecipeBuilder.shapedRemainderRecipe(ModBlocks.REINFORCED_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define("#", Ingredient.of(ModBlocks.REINFORCED_GLASS.get()))
                .define("X", Ingredient.of(ModItems.MARVER.get()))
                .unlockedBy("has_reinforced_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/reinforced/wall"));

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

        RemainderShapedRecipeBuilder.shapedRemainderRecipe(ModBlocks.SHIFTING_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define("#", Ingredient.of(ModBlocks.SHIFTING_GLASS.get()))
                .define("X", Ingredient.of(ModItems.MARVER.get()))
                .unlockedBy("has_shifting_glass", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.GLOWING_GLASS.get()))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/shifting/wall"));

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

        RemainderShapedRecipeBuilder.shapedRemainderRecipe(ModBlocks.TINTED_GLASS_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .pattern("X  ")
                .define("#", Ingredient.of(Blocks.TINTED_GLASS))
                .define("X", Ingredient.of(ModItems.MARVER.get()))
                .unlockedBy("has_tinted_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.TINTED_GLASS))
                .save(consumer, new ResourceLocation(MODID, "crafting/glass/tinted/wall"));
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