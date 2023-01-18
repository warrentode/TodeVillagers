package net.warrentode.todevillagers.items.records;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChakraDreamRecordItem extends RecordItem {
    public ChakraDreamRecordItem(int comparatorValue, RegistryObject<SoundEvent> soundSupplier, Properties builder, int lengthInTicks) {
        super(comparatorValue, soundSupplier, builder, lengthInTicks);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("tooltips.todevillagers.chakra_dream_music_disc"));
    }
}
