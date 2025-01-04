package com.logic_thinkering.itens;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import java.util.EnumMap;


public class MaterialArmadura implements Material {

    private ArmorMaterial material;

    public MaterialArmadura(
        int durability,
        Integer[] defense,
        int enchantmentValue,
        RegistryEntry<SoundEvent> equipSound,
        float toughness,
        float knockbackResistance,
        TagKey<Item> repairIngredient,
        Identifier modelId
    ) {
        EnumMap<EquipmentType, Integer> map = new EnumMap<>(EquipmentType.class);
        map.put(EquipmentType.BOOTS, defense[0]);
        map.put(EquipmentType.LEGGINGS, defense[1]);
        map.put(EquipmentType.CHESTPLATE, defense[2]);
        map.put(EquipmentType.HELMET, defense[3]);
        map.put(EquipmentType.BODY, defense[4]);

        this.material = new ArmorMaterial(
                durability,
                map,
                enchantmentValue,
                equipSound,
                toughness,
                knockbackResistance,
                repairIngredient,
                modelId);
    }

    public ArmorMaterial getMaterial() {
        return material;
    }

    @Override
    public void updateSettings(int i, int j, int k, int l) {
        this.material = new ArmorMaterial()
    }

    @Override
    public void updateItemTag(TagKey<Item> repairIngredient) {

    }
}
