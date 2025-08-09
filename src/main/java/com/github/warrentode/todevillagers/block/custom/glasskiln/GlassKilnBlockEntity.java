package com.github.warrentode.todevillagers.block.custom.glasskiln;

import com.github.warrentode.todevillagers.block.ModBlockEntities;
import com.github.warrentode.todevillagers.block.custom.glasskiln.screens.GlassKilnMenu;
import com.github.warrentode.todevillagers.block.custom.glasskiln.slots.GlassKilnItemHandler;
import com.github.warrentode.todevillagers.mixins.RecipeManagerAccessor;
import com.github.warrentode.todevillagers.recipes.ModRecipes;
import com.github.warrentode.todevillagers.recipes.glassblowing.GlassblowingRecipe;
import com.github.warrentode.todevillagers.utils.ModTags;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GlassKilnBlockEntity extends BlockEntity implements MenuProvider, Nameable, RecipeHolder {
    public static final int FUEL_SLOT = 4;
    public static final int RESULT_SLOT = 5;
    public static final int INVENTORY_SIZE = RESULT_SLOT + 1;
    protected final ContainerData kilnBlockData;
    private final ItemStackHandler inventory;
    public LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Object2IntOpenHashMap<ResourceLocation> usedRecipes;
    private int glassblowingTime;
    private int totalGlassblowingTime;
    private int fuelTime = 0;
    private int fuelDuration = 0;
    private ResourceLocation lastRecipeID;
    private ItemStack lastItemCrafted;
    private boolean checkNewRecipe;

    private Component customName;

    public GlassKilnBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GLASS_KILN_ENTITY.get(), pos, state);
        this.inventory = createHandler();
        this.lastItemCrafted = ItemStack.EMPTY;
        this.kilnBlockData = createIntArray();
        this.usedRecipes = new Object2IntOpenHashMap<>();
        this.checkNewRecipe = true;
    }

    private final Map<Direction, LazyOptional<GlassKilnItemHandler>> directionWrappedHandlerMap =
            Map.of(
                    Direction.DOWN, LazyOptional.of(() -> new GlassKilnItemHandler(getInventory(),
                            (index, stack) -> false, (index) -> index == RESULT_SLOT, Direction.DOWN)),

                    Direction.UP, LazyOptional.of(() -> new GlassKilnItemHandler(getInventory(),
                            (index, stack) -> index == 0 || index == 1 || index == 2 || index == 3,
                            (index) -> false, Direction.UP)),
                    Direction.EAST, LazyOptional.of(() -> new GlassKilnItemHandler(getInventory(),
                            (index, stack) -> index == 0 || index == 1 || index == 2 || index == 3,
                            (index) -> false, Direction.EAST)),

                    Direction.NORTH, LazyOptional.of(() -> new GlassKilnItemHandler(getInventory(),
                            (index, stack) -> index == FUEL_SLOT, (index) -> false, Direction.NORTH)),
                    Direction.WEST, LazyOptional.of(() -> new GlassKilnItemHandler(getInventory(),
                            (index, stack) -> index == FUEL_SLOT, (index) -> false, Direction.WEST)),

                    Direction.SOUTH, LazyOptional.of(() -> new GlassKilnItemHandler(getInventory(),
                            (index, stack) -> false, (index) -> false, Direction.SOUTH))
            );

    public static void tick(@NotNull Level level, BlockPos pos, BlockState state, GlassKilnBlockEntity kilnBlock) {
        if (level.isClientSide()) {
            return;
        }

        boolean didInventoryChange = false;

        Optional<GlassblowingRecipe> recipe = kilnBlock.getMatchingRecipe(new RecipeWrapper(kilnBlock.inventory));

        if (isBurningFuel(kilnBlock)) {
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, true), 3);
            kilnBlock.fuelTime--;
            didInventoryChange = true;
        }
        else if (!isBurningFuel(kilnBlock) && kilnBlock.inventory.getStackInSlot(FUEL_SLOT).isEmpty() && kilnBlock.glassblowingTime > 0) {
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, false), 3);
            kilnBlock.glassblowingTime--;
            didInventoryChange = true;
        }
        else if (kilnBlock.glassblowingTime == 0) {
            level.setBlock(pos, state.setValue(GlassKilnBlock.LIT, false), 3);
            didInventoryChange = true;
        }

        if (kilnBlock.hasInput()) {
            if (recipe.isPresent()) {
                if (isBurningFuel(kilnBlock)) {
                    if (kilnBlock.canProcess(recipe.get())) {
                        kilnBlock.processGlass(recipe.get(), kilnBlock);
                    }
                    didInventoryChange = true;
                }
                else if (hasFuelInFuelSlot(kilnBlock) && !isBurningFuel(kilnBlock)) {
                    didInventoryChange = true;
                }
            }
            else {
                kilnBlock.resetProgress();
                didInventoryChange = true;
            }
        }

        if (didInventoryChange) {
            setChanged(level, pos, state);
        }
    }

    private static boolean hasFuelInFuelSlot(@NotNull GlassKilnBlockEntity kilnBlock) {
        if (!kilnBlock.inventory.getStackInSlot(4).isEmpty() && kilnBlock.fuelTime == 0) {
            burnFuel(kilnBlock);
        }
        else {
            return kilnBlock.fuelTime > 0;
        }
        return false;
    }

    private static boolean isBurningFuel(@NotNull GlassKilnBlockEntity kilnBlock) {
        return kilnBlock.fuelTime > 0;
    }

    private static void burnFuel(@NotNull GlassKilnBlockEntity kilnBlock) {
        ItemStack pFuel = kilnBlock.inventory.getStackInSlot(4).getItem().getDefaultInstance();
        int burnTimeForItem = getItemBurnTime(pFuel);

        Optional<GlassblowingRecipe> recipe = kilnBlock.getMatchingRecipe(new RecipeWrapper(kilnBlock.inventory));

        if (kilnBlock.fuelTime == 0 && recipe.isPresent()) {
            if (!pFuel.isEmpty() && (getItemBurnTime(pFuel) > 0) && kilnBlock.canProcess(recipe.get())) {
                kilnBlock.fuelDuration = burnTimeForItem;
                kilnBlock.fuelTime = kilnBlock.fuelDuration;
                if (kilnBlock.inventory.getStackInSlot(4).hasCraftingRemainingItem()) {
                    ItemStack remainingItem = kilnBlock.inventory.getStackInSlot(4).getCraftingRemainingItem();
                    kilnBlock.inventory.setStackInSlot(4, remainingItem);
                }
                else {
                    kilnBlock.inventory.extractItem(4, 1, false);
                }
            }
        }
    }

    public static int getItemBurnTime(ItemStack pFuel) {
        return ForgeHooks.getBurnTime(pFuel, null);
    }

    private static void splitAndSpawnExperience(ServerLevel level, Vec3 pos, int craftedAmount, float experience) {
        int expTotal = Mth.floor((float) craftedAmount * experience);
        float expFraction = Mth.frac((float) craftedAmount * experience);
        if (expFraction != 0.0F && Math.random() < (double) expFraction) {
            ++expTotal;
        }

        ExperienceOrb.award(level, pos, expTotal);
    }

    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        if (customName != null) {
            nbt.putString("CustomName", Component.Serializer.toJson(customName));
        }
        inventory.deserializeNBT(nbt.getCompound("inventory"));
        glassblowingTime = nbt.getInt("glassblowingTime");
        totalGlassblowingTime = nbt.getInt("totalGlassblowingTime");
        fuelTime = nbt.getInt("fuelTime");
        fuelDuration = nbt.getInt("fuelDuration");
        nbt.put("lastRecipeUsed", lastItemCrafted.serializeNBT());
        CompoundTag compoundRecipes = nbt.getCompound("usedRecipes");
        for (String key : compoundRecipes.getAllKeys()) {
            usedRecipes.put(new ResourceLocation(key), compoundRecipes.getInt(key));
        }
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        if (customName != null) {
            nbt.putString("CustomName", Component.Serializer.toJson(customName));
        }
        nbt.put("inventory", inventory.serializeNBT());
        nbt.putInt("glassblowingTime", this.glassblowingTime);
        nbt.putInt("totalGlassblowingTime", totalGlassblowingTime);
        nbt.putInt("fuelTime", this.fuelTime);
        nbt.putInt("fuelDuration", this.fuelDuration);
        lastItemCrafted = ItemStack.of(nbt.getCompound("lastItemCrafted"));
        CompoundTag compoundRecipes = new CompoundTag();
        usedRecipes.forEach((recipeId, craftedAmount) -> compoundRecipes.putInt(recipeId.toString(), craftedAmount));
        nbt.put("usedRecipes", compoundRecipes);
    }

    private CompoundTag writeItems(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.put("inventory", inventory.serializeNBT());
        nbt.put("lastItemCrafted", lastItemCrafted.serializeNBT());
        return nbt;
    }

    private Optional<GlassblowingRecipe> getMatchingRecipe(RecipeWrapper inventory) {
        if (level == null) {
            return Optional.empty();
        }

        if (lastRecipeID != null) {
            Recipe<RecipeWrapper> recipe = ((RecipeManagerAccessor) level.getRecipeManager())
                    .getRecipeMap(ModRecipes.RECIPE_TYPE_GLASSBLOWING.get())
                    .get(lastRecipeID);
            if (recipe instanceof GlassblowingRecipe) {
                if (recipe.matches(inventory, level)) {
                    return Optional.of((GlassblowingRecipe) recipe);
                }
                if (recipe.getResultItem(this.level.registryAccess()).is(lastItemCrafted.getItem())) {
                    return Optional.empty();
                }
            }
        }

        if (checkNewRecipe) {
            Optional<GlassblowingRecipe> recipe = level.getRecipeManager().getRecipeFor(ModRecipes.RECIPE_TYPE_GLASSBLOWING.get(), inventory, level);
            if (recipe.isPresent()) {
                ResourceLocation newRecipeID = recipe.get().getId();
                if (lastRecipeID != null && !lastRecipeID.equals(newRecipeID)) {
                    glassblowingTime = 0;
                }
                lastRecipeID = newRecipeID;
                return recipe;
            }
        }

        checkNewRecipe = false;
        return Optional.empty();
    }

    private boolean hasInput() {
        for (int i = 0; i < RESULT_SLOT; ++i) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    protected boolean canProcess(GlassblowingRecipe recipe) {
        if (this.level == null) {
            return false;
        }

        if (hasInput()) {
            ItemStack resultStack = recipe.getResultItem(this.level.registryAccess());
            if (resultStack.isEmpty()) {
                return false;
            }
            else {
                ItemStack stackInSlot = inventory.getStackInSlot(RESULT_SLOT);
                if (stackInSlot.isEmpty()) {
                    return true;
                }
                else if (!stackInSlot.is(resultStack.getItem())) {
                    return false;
                }
                else if (stackInSlot.getCount() + resultStack.getCount() <= inventory.getSlotLimit(RESULT_SLOT)) {
                    return true;
                }
                else {
                    return stackInSlot.getCount() + resultStack.getCount() <= resultStack.getMaxStackSize();
                }
            }
        }
        else {
            return false;
        }
    }

    private void processGlass(GlassblowingRecipe recipe, GlassKilnBlockEntity kilnBlock) {
        if (level == null) {
            return;
        }

        ++glassblowingTime;
        totalGlassblowingTime = recipe.getGlassblowingTime();
        if (glassblowingTime >= totalGlassblowingTime) {
            kilnBlock.craftItem(recipe, kilnBlock);
        }
    }

    private void craftItem(GlassblowingRecipe recipe, GlassKilnBlockEntity kilnBlock) {
        if (this.level == null) {
            return;
        }
        for (int i = 0; i < inventory.getSlots(); i++) {
            inventory.setStackInSlot(i, inventory.getStackInSlot(i));
        }

        // check input slots for tools, remove if at max dmg, if not, dmg it
        // SLOT 0 TOOL CHECK
        if (inventory.getStackInSlot(0).getDamageValue() == (inventory.getStackInSlot(0).getMaxDamage() - 1)
                && inventory.getStackInSlot(0).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.extractItem(0, 1, false);
        }
        else if (inventory.getStackInSlot(0).getDamageValue() != inventory.getStackInSlot(0).getMaxDamage()
                && inventory.getStackInSlot(0).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.getStackInSlot(0).hurt(1, new SingleThreadedRandomSource(1), null);
        }
        else {
            inventory.extractItem(0, 1, false);
        }
        // SLOT 1 TOOL CHECK
        if (inventory.getStackInSlot(1).getDamageValue() == (inventory.getStackInSlot(1).getMaxDamage() - 1)
                && inventory.getStackInSlot(1).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.extractItem(1, 1, false);
        }
        else if (inventory.getStackInSlot(1).getDamageValue() != inventory.getStackInSlot(1).getMaxDamage()
                && inventory.getStackInSlot(1).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.getStackInSlot(1).hurt(1, new SingleThreadedRandomSource(1), null);
        }
        else {
            inventory.extractItem(1, 1, false);
        }
        // SLOT 2 TOOL CHECK
        if (inventory.getStackInSlot(2).getDamageValue() == (inventory.getStackInSlot(2).getMaxDamage() - 1)
                && inventory.getStackInSlot(2).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.extractItem(2, 1, false);
        }
        else if (inventory.getStackInSlot(2).getDamageValue() != inventory.getStackInSlot(2).getMaxDamage()
                && inventory.getStackInSlot(2).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.getStackInSlot(2).hurt(1, new SingleThreadedRandomSource(1), null);
        }
        else {
            inventory.extractItem(2, 1, false);
        }
        // SLOT 3 TOOL CHECK
        if (inventory.getStackInSlot(3).getDamageValue() == (inventory.getStackInSlot(3).getMaxDamage() - 1)
                && inventory.getStackInSlot(3).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.extractItem(3, 1, false);
        }
        else if (inventory.getStackInSlot(3).getDamageValue() != inventory.getStackInSlot(3).getMaxDamage()
                && inventory.getStackInSlot(3).is(ModTags.Items.GLASSBLOWER_TOOLS)) {
            inventory.getStackInSlot(3).hurt(1, new SingleThreadedRandomSource(1), null);
        }
        else {
            inventory.extractItem(3, 1, false);
        }

        inventory.setStackInSlot(RESULT_SLOT, new ItemStack(recipe.getResultItem(this.level.registryAccess()).getItem(),
                inventory.getStackInSlot(RESULT_SLOT).getCount() + (recipe.getResultItem(this.level.registryAccess()).getCount())));

        lastItemCrafted = recipe.getResultItem(this.level.registryAccess());
        kilnBlock.setRecipeUsed(recipe);
        kilnBlock.resetProgress();
        setChanged();
    }

    private void resetProgress() {
        this.glassblowingTime = 0;
    }

    @Nullable
    @Override
    public Recipe<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void setRecipeUsed(@Nullable Recipe<?> recipe) {
        if (recipe != null) {
            ResourceLocation recipeID = recipe.getId();
            usedRecipes.addTo(recipeID, 1);
        }
    }

    @Override
    public void awardUsedRecipes(@NotNull Player player, @NotNull List<ItemStack> items) {
        List<Recipe<?>> usedRecipes = getUsedRecipesAndPopExperience(player.level(), player.position());
        player.awardRecipes(usedRecipes);
        this.usedRecipes.clear();
    }

    public List<Recipe<?>> getUsedRecipesAndPopExperience(Level level, Vec3 pos) {
        List<Recipe<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceLocation> entry : usedRecipes.object2IntEntrySet()) {
            level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                splitAndSpawnExperience((ServerLevel) level, pos, entry.getIntValue(), ((GlassblowingRecipe) recipe).getExperience());
            });
        }

        return list;
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    public void drops() {
        NonNullList<ItemStack> drops = NonNullList.create();
        for (int i = 0; i < INVENTORY_SIZE; ++i) {
            if (i != RESULT_SLOT) {
                drops.add(inventory.getStackInSlot(i));
            }
        }
    }

    @Override
    public @NotNull Component getName() {
        return customName != null ? customName : Component.translatable("container.todevillagers.glass_kiln");
    }

    @Override
    public @NotNull Component getDisplayName() {
        return getName();
    }

    @Override
    @Nullable
    public Component getCustomName() {
        return customName;
    }

    public void setCustomName(Component name) {
        customName = name;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory player, @NotNull Player entity) {
        return new GlassKilnMenu(id, player, this, kilnBlockData);
    }

    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
        if (capability.equals(ForgeCapabilities.ITEM_HANDLER)) {
            if (side == null) {
                return lazyItemHandler.cast();
            }

            if (directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(GlassKilnBlock.FACING);

                if (side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }
        return super.getCapability(capability, side);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        lazyItemHandler.invalidate();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler.invalidate();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(INVENTORY_SIZE) {
            @Override
            protected void onContentsChanged(int slot) {
                if (slot >= 0 && slot < RESULT_SLOT) {
                    checkNewRecipe = true;
                }
                inventoryChanged();
            }
        };
    }

    private ContainerData createIntArray() {
        return new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GlassKilnBlockEntity.this.glassblowingTime;
                    case 1 -> GlassKilnBlockEntity.this.totalGlassblowingTime;
                    case 2 -> GlassKilnBlockEntity.this.fuelTime;
                    case 3 -> GlassKilnBlockEntity.this.fuelDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GlassKilnBlockEntity.this.glassblowingTime = value;
                    case 1 -> GlassKilnBlockEntity.this.totalGlassblowingTime = value;
                    case 2 -> GlassKilnBlockEntity.this.fuelTime = value;
                    case 3 -> GlassKilnBlockEntity.this.fuelDuration = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    protected void inventoryChanged() {
        super.setChanged();
        if (level != null) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }
}