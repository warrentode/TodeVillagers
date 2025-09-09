package com.github.warrentode.todevillagers.block.custom.jar;

import com.github.warrentode.todevillagers.utils.ModTags;
import com.github.warrentode.todevillagers.utils.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JarBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public final static VoxelShape SHAPE = Stream.of(
            Block.box(4, 0, 4, 5, 10, 12),
            Block.box(11, 0, 4, 12, 10, 12),
            Block.box(5, 0, 4, 11, 10, 5),
            Block.box(5, 0, 11, 11, 10, 12),
            Block.box(5, 0, 5, 11, 1, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public JarBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
        ShapeUtil.runCalculation(SHAPES, SHAPE);
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (blockEntity instanceof JarBlockEntity jarBlockEntity) {
            ItemStackHandler inventory = jarBlockEntity.getItems();

            if (!heldStack.isEmpty()) {
                for (int i = 0; i < inventory.getSlots(); ++i) {
                    ItemStack jarSlot = inventory.getStackInSlot(i);
                    if (jarSlot.isEmpty() && heldStack.is(ModTags.Items.JAR_ITEMS)) {
                        if (jarBlockEntity.placeItems(player, heldStack)) {
                            return InteractionResult.sidedSuccess(level.isClientSide);
                        }
                    }
                    else if (jarSlot.isEmpty() && heldStack.isEdible()) {
                        if (jarBlockEntity.placeItems(player, heldStack)) {
                            return InteractionResult.sidedSuccess(level.isClientSide);
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < inventory.getSlots(); ++i) {
                    ItemStack tipJarSlot = inventory.getStackInSlot(i);
                    if (!tipJarSlot.isEmpty()) {
                        ItemStack tipJarStack = jarBlockEntity.removeItems();
                        ItemStack receivedStack = new ItemStack(tipJarStack.copy().getItem());
                        player.playSound(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
                        if (!player.addItem(receivedStack)) {
                            player.drop(receivedStack, false);
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }


    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        if (stack.hasTag()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof JarBlockEntity jarBlockEntity) {
                jarBlockEntity.loadFromItem(stack);
            }
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        ItemStack stack = super.getCloneItemStack(getter, pos, state);
        JarBlockEntity basketEntity = (JarBlockEntity) getter.getBlockEntity(pos);
        if (basketEntity != null) {
            CompoundTag tag = basketEntity.writeItems(new CompoundTag());
            if (!tag.isEmpty()) {
                stack.addTagElement("BlockEntityTag", tag);
            }
        }
        return stack;
    }

    @Override
    public void playerWillDestroy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof JarBlockEntity jarBlockEntity) {
            if (!level.isClientSide) {
                ItemStack itemstack = new ItemStack(this);
                jarBlockEntity.saveToItem(itemstack);

                ItemEntity itementity = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                level.addFreshEntity(itementity);
            }
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof JarBlockEntity) {
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState state, @NotNull LootParams.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);

        if (blockEntity instanceof JarBlockEntity jarBlockEntity) {
            ItemStack stack = new ItemStack(this);
            jarBlockEntity.saveToItem(stack);

            drops.add(stack);
            drops.removeIf(itemStack -> itemStack.getItem() == this.asItem());
        }

        return drops;
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING,
                context.getHorizontalDirection().getOpposite());
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull BlockState mirror(@NotNull BlockState state, @NotNull Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new JarBlockEntity(pos, state);
    }
}