package com.example;

import net.minecraft.item.Item;

public interface StrategyRegister {
    default void insertOnGroup(Item item) {
        ModItemGroup.addItem(item);
    }
    Item register(String id);
    Item register(String id, String material, String type);
}
