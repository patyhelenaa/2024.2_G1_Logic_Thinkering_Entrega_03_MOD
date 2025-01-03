package com.logic_thinkering;

import net.minecraft.item.Item;

public class ConcreteItem extends PrototypeItem {
    private String id;
    public static Item ITEM;

    public ConcreteItem(String id) {
        strategy = new ConcreteRegisterItem();
        if(id != null) setId(id);
    }

    @Override
    public ConcreteItem clone() {
        return new ConcreteItem(null);
    }

    @Override
    public void register(String id) {
        ITEM = strategy.register(id);
    }

    public void updateMaterial(String material) {}

    public void setId(String id) {
        this.id = id;
        register(id);
    }

}
