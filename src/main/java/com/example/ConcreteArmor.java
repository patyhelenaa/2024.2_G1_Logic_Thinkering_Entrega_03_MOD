package com.example;

import net.minecraft.item.Item;

public class ConcreteArmor extends PrototypeItem {

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
        strategy = new ConcreteRegisterArmor();
        this.type = ArmorType.valueOf(type.toUpperCase());
        this.material = Material.valueOf(material.toUpperCase());
        if(id != null) setId(id);
    }

    @Override
    public ConcreteArmor clone() {
        return new ConcreteArmor(null, this.type.name(), this.material.name());
    }

    @Override
    public void register(String id) {
        ITEM = strategy.register(id, this.material.name(), this.type.name());
    }

    public void setId(String id) {
        this.id = id;
        register(this.id);
    }

    public void setType(String type){
        this.type = ArmorType.valueOf(type.toUpperCase());
    }

    public void updateMaterial(String material){
        this.material = Material.valueOf(material.toUpperCase());
    }

}

