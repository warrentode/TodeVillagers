package com.github.warrentode.todevillagers.block.custom.jar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.List;

public class JarEntityRenderer implements BlockEntityRenderer<JarBlockEntity> {
    private static final float ITEM_SIZE = 0.28F;
    private static final float JAR_BOTTOM = 0.10F;
    private static final double X_CENTER = 0.5D;
    private static final double Z_CENTER = 0.5D;
    /**
     * Paint Brush analogy: How wide your brush spreads each stroke.
     */
    private static final double SCATTER_RADIUS = 0.08D;
    /**
     * Paint Brush analogy: Tiny lifts in paint texture so layers don’t visually merge.
     */
    private static final double ITEM_Z_FIGHT_OFFSET = 0.01D;
    // Maximum random tilt applied to flat coins above the first layer
    private static final float MAX_TILT_X_DEGREES = 10F;
    private static final float MAX_TILT_Z_DEGREES = 10F;
    // Push toward the wall for vertical coins
    private static final double WALL_LEAN_OFFSET = 0.16D;

    private final ItemRenderer itemRenderer;

    public JarEntityRenderer(@NotNull BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(@NotNull JarBlockEntity tipJarBlockEntity, float partialTicks,
                       @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer,
                       int packedLight, int packedOverlay) {

        Level level = tipJarBlockEntity.getLevel();
        if (level == null) return;

        RandomSource random = RandomSource.create(tipJarBlockEntity.getBlockPos().asLong());
        ItemStackHandler inventory = tipJarBlockEntity.getItems();

        int itemsPerLayer = 4; // ~2x2 per layer
        /** Paint Brush analogy: How tall each stroke is relative to the last. */
        double layerHeight = 0.03;

        // Collect all non-empty items to render dynamically
        List<ItemStack> coinsToRender = new ArrayList<>();
        for (int i = 0; i < inventory.getSlots(); i++) {
            ItemStack stack = inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                coinsToRender.add(stack);
            }
        }

        int totalCoins = coinsToRender.size();

        // Get jar blockstate and facing
        BlockState state = tipJarBlockEntity.getBlockState();
        Direction facing = state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)
                ? state.getValue(BlockStateProperties.HORIZONTAL_FACING)
                : Direction.NORTH;

        // Resolve the order of walls based on block facing
        List<Integer> wallOrder = getWallOrderForFacing(facing);

        for (int renderIndex = 0; renderIndex < totalCoins; renderIndex++) {
            ItemStack stack = coinsToRender.get(renderIndex);
            poseStack.pushPose();

            int layer = renderIndex / itemsPerLayer;

            /** Paint Brush analogy: Light pressure variation for texture for your stroke. */
            double verticalJitter = (random.nextDouble() - 0.5) * 0.04; // ±0.02 blocks
            double offsetY = JAR_BOTTOM + layer * layerHeight + (renderIndex % itemsPerLayer) * ITEM_Z_FIGHT_OFFSET + verticalJitter;

            /** Paint Brush analogy: The first anchor stroke you place, followed by the rest. */
            // Default: center for first coin, random scatter for others
            double offsetX = (renderIndex == 0) ? X_CENTER : X_CENTER + (random.nextDouble() - 0.5) * SCATTER_RADIUS * 2;
            double offsetZ = (renderIndex == 0) ? Z_CENTER : Z_CENTER + (random.nextDouble() - 0.5) * SCATTER_RADIUS * 2;

            /** Paint Brush analogy: Direction of the stroke based on the layer. */
            // Determine if the current coin is vertical
            boolean isLeanLayer = layer % 2 == 1;

            // Assign wall for vertical coins regardless of whether we apply offsets
            int wall;
            if (isLeanLayer) {
                int coinIndexInLayer = renderIndex % itemsPerLayer; // always 0..3
                wall = wallOrder.get(coinIndexInLayer % wallOrder.size());

                // tiny random variation to avoid z-fighting along the wall
                double wallJitter = (random.nextDouble() - 0.5) * ITEM_Z_FIGHT_OFFSET * 5;

                // Apply push toward wall with jitter
                switch (wall) {
                    case 0 -> offsetZ = Z_CENTER - WALL_LEAN_OFFSET + wallJitter; // north wall
                    case 1 -> offsetX = X_CENTER + WALL_LEAN_OFFSET + wallJitter; // east wall
                    case 2 -> offsetZ = Z_CENTER + WALL_LEAN_OFFSET + wallJitter; // south wall
                    case 3 -> offsetX = X_CENTER - WALL_LEAN_OFFSET + wallJitter; // west wall
                }

                // Vertical coins: stand them facing along the wall
                float yRotWall = switch (wall) {
                    case 0 -> 0F;   // north wall
                    case 1 -> 90F;  // east wall
                    case 2 -> 0F;  // south wall
                    case 3 -> 90F;  // west wall
                    default -> 0F;
                };
                // positioning of wall coins
                poseStack.translate(offsetX, offsetY, offsetZ);
                // rotation of wall coins
                poseStack.mulPose(Axis.YP.rotationDegrees(yRotWall));
                poseStack.mulPose(Axis.XP.rotationDegrees(0));
                poseStack.mulPose(Axis.ZP.rotationDegrees(0));
            }

            if (!isLeanLayer) {
                // positioning of flat coins
                poseStack.translate(offsetX, offsetY, offsetZ);

                // Random Y rotation for visual scatter for flat coins
                float yRot = (float) (random.nextDouble() * 360.0);
                poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
                // Lay flat X rotation for regular coins
                poseStack.mulPose(Axis.XP.rotationDegrees(90F));

                // Apply tilt only to coins not in bottom layer or in leanLayer
                if (renderIndex != 0) {
                    float tiltX = (float) ((random.nextDouble() - 0.5) * MAX_TILT_X_DEGREES);
                    float tiltZ = (float) ((random.nextDouble() - 0.5) * MAX_TILT_Z_DEGREES);
                    poseStack.mulPose(Axis.XP.rotationDegrees(tiltX));
                    poseStack.mulPose(Axis.ZP.rotationDegrees(tiltZ));
                }
            }

            // Scale
            poseStack.scale(ITEM_SIZE, ITEM_SIZE, ITEM_SIZE);

            int light = addLight(level, tipJarBlockEntity.getBlockPos());
            itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, light, packedOverlay,
                    poseStack, buffer, level, random.nextInt());

            poseStack.popPose();
        }
    }

    private static int addLight(@NotNull Level level, BlockPos pos) {
        int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
        int skyLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(blockLight, skyLight);
    }

    // Deterministic wall order based on jar facing
    private static @Unmodifiable List<Integer> getWallOrderForFacing(@NotNull Direction facing) {
        // 0=north,1=east,2=south,3=west
        return switch (facing) {
            case NORTH -> List.of(0, 1, 2, 3);
            case EAST -> List.of(1, 2, 3, 0);
            case SOUTH -> List.of(2, 3, 0, 1);
            case WEST -> List.of(3, 0, 1, 2);
            // still north
            default -> List.of(0, 1, 2, 3);
        };
    }
}