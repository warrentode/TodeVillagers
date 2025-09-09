package com.github.warrentode.todevillagers.block.custom.ceramics_table.screens;

import com.github.warrentode.todevillagers.block.ModBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import org.jetbrains.annotations.NotNull;

public class CeramicCraftMenu extends CraftingMenu {
    private ContainerLevelAccess access;

    public CeramicCraftMenu(int id, Inventory playerInventory, ContainerLevelAccess access) {
        super(id, playerInventory, access);
        this.access = access;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        // Validate against your custom block instead of vanilla crafting table
        return stillValid(this.access, player, ModBlocks.CERAMICS_TABLE.get());
    }
}