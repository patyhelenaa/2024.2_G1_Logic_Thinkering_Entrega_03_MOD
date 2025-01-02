package com.example;
import net.minecraft.item.Item;

public interface PrototypeItem {
    default void insertOnGroup(Item item) {
        ModItemGroup.addItem(item);
    }
    PrototypeItem clone();
    void updateItem(String id);
    void updateMaterial(String material);
}
