package com.github.warrentode.todevillagers.block.custom.plate;

import com.github.warrentode.todevillagers.utils.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class PlateBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public final static VoxelShape SHAPE = Stream.of(
            Block.box(3, 0, 3, 13, 0.5, 13),
            Block.box(2, 0.5, 4, 4, 1, 12),
            Block.box(12, 0.5, 4, 14, 1, 12),
            Block.box(4, 0.5, 2, 12, 1, 4),
            Block.box(4, 0.5, 12, 12, 1, 14),
            Block.box(2, 0.5, 12, 4, 1, 14),
            Block.box(12, 0.5, 12, 14, 1, 14),
            Block.box(12, 0.5, 2, 14, 1, 4),
            Block.box(2, 0.5, 2, 4, 1, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public PlateBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
        ShapeUtil.runCalculation(SHAPES, SHAPE);
    }

    @Override
    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(InteractionHand.MAIN_HAND);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        int slot = 0;
        if (blockEntity instanceof PlateBlockEntity plateBlockEntity) {
            ItemStack existing = plateBlockEntity.getStoredItem(slot);

            if (existing.isEmpty() && !heldStack.isEdible()) {
                return InteractionResult.FAIL;
            }
            if (existing.isEmpty() && !heldStack.isEmpty() && heldStack.isEdible()) {
                if (plateBlockEntity.addFood(player, heldStack)) {
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
            if (heldStack.isEmpty() && !existing.isEmpty()) {
                ItemStack stack = plateBlockEntity.removeFood();
                ItemStack received = new ItemStack(stack.copy().getItem());
                player.playSound(SoundEvents.ITEM_FRAME_REMOVE_ITEM);

                if (!player.addItem(received)) {
                    player.drop(received, false);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof PlateBlockEntity) {
                Containers.dropContents(level, pos, ((PlateBlockEntity) blockentity).getItems());
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING,
                context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new PlateBlockEntity(pos, state);
    }
}