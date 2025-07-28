package com.github.warrentode.todevillagers.item;

import com.github.warrentode.todevillagers.item.custom.CrushedGlassItem;
import com.github.warrentode.todevillagers.item.custom.GlassblowerShearsItem;
import com.github.warrentode.todevillagers.item.custom.GlassblowingPipeItem;
import com.github.warrentode.todevillagers.item.custom.MarverItem;
import com.github.warrentode.todevillagers.sounds.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.github.warrentode.todevillagers.TodeVillagers.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> CHAKRA_DREAM_MUSIC_DISC = ITEMS.register("chakra_dream_music_disc",
            () -> new RecordItem(4, ModSounds.CHAKRA_DREAM,
                    new Item.Properties().stacksTo(1), 1360));

    public static final RegistryObject<Item> MARVER = ITEMS.register("marver",
            () -> new MarverItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> GLASSBLOWING_PIPE = ITEMS.register("glassblowing_pipe",
            () -> new GlassblowingPipeItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> GLASSBLOWER_SHEARS = ITEMS.register("glassblower_shears",
            () -> new GlassblowerShearsItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> CRUSHED_GLASS = ITEMS.register("crushed_glass",
            () -> new CrushedGlassItem(new Item.Properties().stacksTo(64)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}