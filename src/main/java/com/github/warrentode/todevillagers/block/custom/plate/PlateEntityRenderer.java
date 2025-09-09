package com.github.warrentode.todevillagers.block.custom.plate;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PlateEntityRenderer implements BlockEntityRenderer<PlateBlockEntity> {
    private final ItemRenderer itemRenderer;

    public PlateEntityRenderer(@NotNull BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(@NotNull PlateBlockEntity plateBlockEntity, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Direction direction = plateBlockEntity.getBlockState().getValue(PlateBlock.FACING);
        NonNullList<ItemStack> inventory = plateBlockEntity.getItems();
        Level level = plateBlockEntity.getLevel();
        int i = (int) plateBlockEntity.getBlockPos().asLong();

        for (ItemStack plateStack : inventory) {
            if (!plateStack.isEmpty()) {
                poseStack.pushPose();
                poseStack.translate(0.5D, 0.06F, 0.5D);
                float f = direction.getClockWise().getClockWise().toYRot();
                poseStack.mulPose(Axis.YP.rotationDegrees(-f));
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
                poseStack.translate(0.0D, 0.0D, 0.0D);
                poseStack.scale(0.5F, 0.5F, 0.5F);

                if (plateBlockEntity.getLevel() != null) {
                    itemRenderer.renderStatic(plateStack,
                            ItemDisplayContext.FIXED,
                            packedLight,
                            packedOverlay,
                            poseStack, buffer, level, i);
                }
                poseStack.popPose();
            }
        }
    }
}