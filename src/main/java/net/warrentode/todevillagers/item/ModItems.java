package net.warrentode.todevillagers.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.TodeVillagers;
import net.warrentode.todevillagers.sound.ModSounds;
import net.warrentode.todevillagers.util.ModCreativeModeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TodeVillagers.MODID);

    public static final RegistryObject<Item> CHAKRA_DREAM_MUSIC_DISC = ITEMS.register("chakra_dream_music_disc",
            () -> new RecordItem(4, ModSounds.CHAKRA_DREAM,
                    new Item.Properties().tab(ModCreativeModeTab.TODEVILLAGERS_TAB).stacksTo(1), 1360));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}