package com.github.warrentode.todevillagers.item;

import com.github.warrentode.todevillagers.item.custom.*;
import com.github.warrentode.todevillagers.item.material.ModArmorMaterials;
import com.github.warrentode.todevillagers.item.material.ModTiers;
import com.github.warrentode.todevillagers.sounds.ModSounds;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> KNIFE_CERAMIC = ITEMS.register("knife_ceramic",
            () -> new SwordItem(ModTiers.CERAMIC, -1, -2.0F,
                    new Item.Properties()));
    public static final RegistryObject<Item> CHISEL_IRON = ITEMS.register("chisel_iron",
            () -> new Item(new Item.Properties().durability(250)));
    public static final RegistryObject<Item> CERAMIC_CHIP = ITEMS.register("ceramic_chip",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CERAMIC_HELMET = ITEMS.register("ceramic_helmet",
            () -> new CeramicArmorItem(ModArmorMaterials.CERAMIC, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC_CHESPLATE = ITEMS.register("ceramic_chestplate",
            () -> new CeramicArmorItem(ModArmorMaterials.CERAMIC, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC_LEGGINGS = ITEMS.register("ceramic_leggings",
            () -> new CeramicArmorItem(ModArmorMaterials.CERAMIC, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC_BOOTS = ITEMS.register("ceramic_boots",
            () -> new CeramicArmorItem(ModArmorMaterials.CERAMIC, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}