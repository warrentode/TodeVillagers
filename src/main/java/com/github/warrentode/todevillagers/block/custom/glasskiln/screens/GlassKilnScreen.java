package com.github.warrentode.todevillagers.block.custom.glasskiln.screens;

import com.github.warrentode.todevillagers.recipes.glassblowing.recipebook.GlassblowingRecipeBookComponent;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeUpdateListener;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;


public class GlassKilnScreen extends AbstractContainerScreen<GlassKilnMenu> implements RecipeUpdateListener {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/gui/glass_kiln_gui.png");
    private static final ResourceLocation RECIPE_BUTTON_TEXTURE = new ResourceLocation("textures/gui/recipe_button.png");
    private final GlassblowingRecipeBookComponent recipeBookComponent = new GlassblowingRecipeBookComponent();
    private boolean widthTooNarrow;

    public GlassKilnScreen(GlassKilnMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    public void init() {
        super.init();
        this.widthTooNarrow = this.width < 379;
        this.titleLabelX = 8;
        assert this.minecraft != null;
        this.recipeBookComponent.init(this.width, this.height, this.minecraft, this.widthTooNarrow, this.menu);
        this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
        this.addRenderableWidget(new ImageButton(this.leftPos + 5, this.height / 2 - 49, 20, 18, 0, 0, 19, RECIPE_BUTTON_TEXTURE, (button) ->
        {
            this.recipeBookComponent.toggleVisibility();
            this.leftPos = this.recipeBookComponent.updateScreenPosition(this.width, this.imageWidth);
            ((ImageButton) button).setPosition(this.leftPos + 5, this.height / 2 - 49);
        }));
        this.addWidget(this.recipeBookComponent);
        this.setInitialFocus(this.recipeBookComponent);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        this.recipeBookComponent.tick();
    }

    @Override
    protected void renderBg(@NotNull PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = this.leftPos;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pPoseStack, x, y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if (menu.isCrafting()) {
            blit(pPoseStack, x + 86, y + 45, 177, 14, menu.getScaledProgress(), 16);
        }

        if (menu.hasFuel()) {
            blit(pPoseStack, x + 85, y + 77, 177, 4, menu.getScaledFuelProgress(), 3);
        }
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float delta) {
        this.renderBackground(poseStack);

        if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
            this.renderBg(poseStack, delta, mouseX, mouseY);
            this.recipeBookComponent.render(poseStack, mouseX, mouseY, delta);
        }
        else {
            this.recipeBookComponent.render(poseStack, mouseX, mouseY, delta);
            super.render(poseStack, mouseX, mouseY, delta);
            this.recipeBookComponent.renderGhostRecipe(poseStack, this.leftPos, this.topPos, true, delta);
        }

        this.renderTooltip(poseStack, mouseX, mouseY);
        this.recipeBookComponent.renderTooltip(poseStack, this.leftPos, this.topPos, mouseX, mouseY);
    }

    @Override
    protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
        return (!this.widthTooNarrow || !this.recipeBookComponent.isVisible()) && super.isHovering(x, y, width, height, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int buttonId) {
        if (this.recipeBookComponent.mouseClicked(mouseX, mouseY, buttonId)) {
            this.setFocused(this.recipeBookComponent);
            return true;
        }
        return this.widthTooNarrow && this.recipeBookComponent.isVisible() || super.mouseClicked(mouseX, mouseY, buttonId);
    }

    @Override
    protected boolean hasClickedOutside(double mouseX, double mouseY, int x, int y, int buttonIdx) {
        boolean flag = mouseX < (double) x || mouseY < (double) y || mouseX >= (double) (x + this.imageWidth) || mouseY >= (double) (y + this.imageHeight);
        return flag && this.recipeBookComponent.hasClickedOutside(mouseX, mouseY, this.leftPos, this.topPos, this.imageWidth, this.imageHeight, buttonIdx);
    }

    @Override
    protected void slotClicked(@NotNull Slot slot, int mouseX, int mouseY, @NotNull ClickType clickType) {
        super.slotClicked(slot, mouseX, mouseY, clickType);
        this.recipeBookComponent.slotClicked(slot);
    }

    @Override
    public void recipesUpdated() {
        this.recipeBookComponent.recipesUpdated();
    }

    @Override
    public void removed() {
        this.recipeBookComponent.removed();
        super.removed();
    }

    @Override
    @Nonnull
    public RecipeBookComponent getRecipeBookComponent() {
        return this.recipeBookComponent;
    }
}