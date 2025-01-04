package com.logic_thinkering.itens;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

public interface ModArmorMaterial {

    ArmorMaterial REINFORCED_COPPER = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.NETHERITE);

    ArmorMaterial REINFORCED_EMERALD = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.NETHERITE);

    ArmorMaterial REINFORCED_AMETHYST = new ArmorMaterial(37, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 11);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.NETHERITE);

    static ArmorMaterial valueOf(String name) {
        switch (name.toUpperCase()) {
            case "REINFORCED_COPPER":
                return REINFORCED_COPPER;
            case "REINFORCED_EMERALD":
                return REINFORCED_EMERALD;
            case "REINFORCED_AMETHYST":
                return REINFORCED_AMETHYST;
            default:
                throw new IllegalArgumentException("Unknown material: " + name);
        }
    }
}
