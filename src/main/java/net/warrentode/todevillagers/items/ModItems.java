package net.warrentode.todevillagers.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.warrentode.todevillagers.items.records.ChakraDreamRecordItem;
import net.warrentode.todevillagers.sounds.ModSounds;
import net.warrentode.todevillagers.util.ModCreativeModeTab;
import static net.warrentode.todevillagers.TodeVillagers.MODID;

public class ModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> CHAKRA_DREAM_MUSIC_DISC = REGISTRY.register("chakra_dream_music_disc", () ->
            new ChakraDreamRecordItem(4, ModSounds.CHAKRA_DREAM,
                    new Item.Properties().tab(ModCreativeModeTab.TODEVILLAGERS_TAB).stacksTo(1).rarity(Rarity.RARE), 1360));
}
