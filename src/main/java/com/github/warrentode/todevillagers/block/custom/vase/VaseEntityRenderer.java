package com.github.warrentode.todevillagers.block.custom.vase;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;

public class VaseEntityRenderer implements BlockEntityRenderer<VaseBlockEntity> {
    private final BlockRenderDispatcher blockRenderer;

    public VaseEntityRenderer(@NotNull BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    @Override
    public void render(@NotNull VaseBlockEntity vaseBlockEntity, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay) {
        NonNullList<ItemStack> inventory = vaseBlockEntity.getItems();
        Level level = vaseBlockEntity.getLevel();

        for (ItemStack itemStack : inventory) {
            if (!itemStack.isEmpty() && itemStack.getItem() instanceof BlockItem blockItem) {
                BlockState plantState = blockItem.getBlock().defaultBlockState();

                if (level != null) {
                    if (plantState.getBlock() instanceof DoublePlantBlock) {
                        BlockState lowerHalf = plantState.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
                        BlockState upperHalf = plantState.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                        poseStack.pushPose();
                        // Center on top of the vase
                        poseStack.translate(0.25D, 0.4D, 0.25D);
                        poseStack.scale(0.5F, 0.5F, 0.5F);

                        //noinspection deprecation
                        blockRenderer.renderSingleBlock(lowerHalf, poseStack, buffer, packedLight, packedOverlay);
                        // Center on top of the lower half
                        poseStack.translate(0.0D, 1.0D, 0.0D);
                        //noinspection deprecation
                        blockRenderer.renderSingleBlock(upperHalf, poseStack, buffer, packedLight, packedOverlay);

                        poseStack.popPose();
                    }
                    else {
                        poseStack.pushPose();
                        // Center on top of the vase
                        poseStack.translate(0.25D, 0.4D, 0.25D);
                        poseStack.scale(0.5F, 0.5F, 0.5F);
                        //noinspection deprecation
                        blockRenderer.renderSingleBlock(plantState, poseStack, buffer, packedLight, packedOverlay);

                        poseStack.popPose();
                    }
                }
            }
        }
    }
}