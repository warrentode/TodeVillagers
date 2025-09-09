package com.github.warrentode.todevillagers.block.custom.vase;

import com.github.warrentode.todevillagers.utils.ModTags;
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

public class VaseBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    public final static VoxelShape SHAPE = Stream.of(
            Block.box(6, 0, 6, 10, 6, 10),
            Block.box(6.5, 6, 7, 7, 7, 9),
            Block.box(9, 6, 7, 9.5, 7, 9),
            Block.box(6.5, 6, 6.5, 9.5, 7, 7),
            Block.box(6.5, 6, 9, 9.5, 7, 9.5),
            Block.box(7, 6, 7, 9, 6.5, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public VaseBlock(Properties properties) {
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
        if (blockEntity instanceof VaseBlockEntity vaseBlockEntity) {
            ItemStack existing = vaseBlockEntity.getStoredItem(slot);

            if (existing.isEmpty() && !heldStack.is(ModTags.Items.VASE_PLANTS)) {
                return InteractionResult.FAIL;
            }
            if (existing.isEmpty() && !heldStack.isEmpty() && heldStack.is(ModTags.Items.VASE_PLANTS)) {
                if (vaseBlockEntity.addPlant(player, heldStack)) {
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
            if (heldStack.isEmpty() && !existing.isEmpty()) {
                ItemStack stack = vaseBlockEntity.removePlant();
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
            if (blockentity instanceof VaseBlockEntity) {
                Containers.dropContents(level, pos, ((VaseBlockEntity) blockentity).getItems());
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
        return new VaseBlockEntity(pos, state);
    }
}