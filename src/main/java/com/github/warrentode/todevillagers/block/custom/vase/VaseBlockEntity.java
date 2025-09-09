package com.github.warrentode.todevillagers.block.custom.vase;

import com.github.warrentode.todevillagers.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VaseBlockEntity extends BlockEntity implements Clearable {
    protected final NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);

    public VaseBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.VASE_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.items.clear();
        ContainerHelper.loadAllItems(tag, this.items);
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items, true);
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public boolean addPlant(@Nullable Player player, ItemStack itemStack) {
        for (int i = 0; i < this.items.size(); ++i) {
            ItemStack vaseStack = this.items.get(i);
            if (vaseStack.isEmpty()) {
                this.items.set(i, itemStack.split(1));
                assert this.level != null;
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(),
                        GameEvent.Context.of(player, this.getBlockState()));
                setChanged();
                assert player != null;
                player.playSound(SoundEvents.ITEM_FRAME_ADD_ITEM);
                return true;
            }
        }

        return false;
    }

    public ItemStack removePlant() {
        for (int i = 0; i < this.items.size(); i++) {
            if (!getStoredItem(i).isEmpty()) {
                ItemStack item = getStoredItem(i).split(1);
                setChanged();
                return item;
            }
        }
        return ItemStack.EMPTY;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    public ItemStack getStoredItem(int slot) {
        return items.get(slot);
    }

    public void clearContent() {
        this.items.clear();
    }
}