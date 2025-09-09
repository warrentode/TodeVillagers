package com.github.warrentode.todevillagers.item.custom;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;

public class CeramicArmorItem extends ArmorItem implements DyeableLeatherItem {
    public CeramicArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
}