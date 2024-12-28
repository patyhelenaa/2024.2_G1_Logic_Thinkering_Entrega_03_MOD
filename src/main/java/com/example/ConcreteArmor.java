package com.example;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;


public class ConcreteArmor implements PrototypeItem {

    private enum ArmorType {
        HELMET, CHESTPLATE, LEGGINGS, BOOTS
    }
    private enum Material {
        REINFORCED_COPPER, REINFORCED_EMERALD, REINFORCED_AMETHYST
    }

    public static Item ITEM;
    private String id;
    private ArmorType type;
    private Material material;

    public ConcreteArmor(String id, String type, String material) {
        this.type = ArmorType.valueOf(type.toUpperCase());
        this.material = Material.valueOf(material.toUpperCase());
        if(id != null) setId(id);
    }

    @Override
    public ConcreteArmor clone() {
        return new ConcreteArmor(null, this.type.name(), this.material.name());
    }

    @Override
    public void updateItem(String id) {
        Function<Item.Settings, Item> factory = (settings) -> new ArmorItem(
                MateriaisArmadura.valueOf(this.material.name()),
                EquipmentType.valueOf(this.type.name()),
                settings);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, id));
        Item.Settings settings = new Item.Settings();
        Item item = factory.apply(settings.registryKey(key));
        ConcreteArmor.ITEM = Registry.register(Registries.ITEM, key, item);

        insertOnGroup(ConcreteArmor.ITEM);
    }


    public void setId(String id) {
        this.id = id;
        updateItem(this.id);
    }

    public void setType(String type){
        this.type = ArmorType.valueOf(type.toUpperCase());
    }

    public void setMaterial(String material){
        this.material = Material.valueOf(material.toUpperCase());
    }
}

