package com.example;

import net.minecraft.item.Item;

public class ConcreteItem extends PrototypeItem {
    private String id;
    public static Item ITEM;

    public ConcreteItem(String id) {
        this.id = id;
    }

    @Override
    public PrototypeItem clone() {
        return new ConcreteItem(this.id);
    }

    public void setId(String id) {
        this.id = id;
        updateItem(id);
    }

}
