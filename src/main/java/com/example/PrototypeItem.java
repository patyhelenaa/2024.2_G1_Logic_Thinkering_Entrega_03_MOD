package com.example;
import net.minecraft.item.Item;

public interface PrototypeItem {
    default void insertOnGroup(Item item) {
        GuiaInventario.adicionarItem(item);
    }
    PrototypeItem clone();
    void updateItem(String id);
}
