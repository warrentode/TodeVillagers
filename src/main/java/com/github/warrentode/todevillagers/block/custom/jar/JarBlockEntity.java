package com.github.warrentode.todevillagers.block.custom.jar;

import com.github.warrentode.todevillagers.block.ModBlockEntities;
import com.github.warrentode.todevillagers.utils.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class JarBlockEntity extends BlockEntity {
    public final ItemStackHandler inventory;
    public static final int INVENTORY_SIZE = 64;

    private final ItemStackHandler tipJarHandler = new ItemStackHandler(INVENTORY_SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            if (level != null) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
            }
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return stack.is(ModTags.Items.JAR_ITEMS);
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public JarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.JAR_BLOCK_ENTITY.get(), pos, state);
        this.inventory = tipJarHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> tipJarHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    public void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", tipJarHandler.serializeNBT());
    }

    @NotNull
    public CompoundTag writeItems(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", inventory.serializeNBT());
        return tag;
    }

    public @NotNull CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound("inventory"));
    }

    public void saveToItem(@NotNull ItemStack stack) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        if (!tag.isEmpty()) {
            stack.addTagElement("BlockEntityTag", tag);
        }
    }

    public void loadFromItem(@NotNull ItemStack stack) {
        CompoundTag tag = stack.getTag();
        // 10 is the NBT type ID for CompoundTag
        if (tag != null && tag.contains("BlockEntityTag", 10)) {
            this.load(tag.getCompound("BlockEntityTag"));
        }
    }

    public ItemStackHandler getItems() {
        return inventory;
    }

    public boolean placeItems(@Nullable Player player, ItemStack itemStack) {
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            ItemStack tipJarStack = inventory.getStackInSlot(i);
            if (tipJarStack.isEmpty()) {
                this.inventory.setStackInSlot(i, itemStack.split(1));
                assert this.level != null;
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(),
                        GameEvent.Context.of(player, this.getBlockState()));
                markUpdated();
                assert player != null;
                player.playSound(SoundEvents.ITEM_FRAME_ADD_ITEM);
                return true;
            }
        }

        return false;
    }

    public ItemStack removeItems() {
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            ItemStack tipJarStack = inventory.getStackInSlot(i);
            if (!tipJarStack.isEmpty()) {
                ItemStack item = tipJarStack.split(1);
                markUpdated();
                return item;
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.inventory.getSlots(); ++i) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, @NotNull ClientboundBlockEntityDataPacket pkt) {
        load(Objects.requireNonNull(pkt.getTag()));
    }

    private void markUpdated() {
        this.setChanged();
        assert this.level != null;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 2);
    }
}