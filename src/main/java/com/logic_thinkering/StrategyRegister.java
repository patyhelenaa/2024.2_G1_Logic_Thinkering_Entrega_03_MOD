package com.logic_thinkering;

import net.minecraft.item.Item;

public interface StrategyRegister {
    default void insertOnGroup(Item item) {
        LogicThinkeringItemGroup.addItem(item);
    }
    Item register(String id);
    Item register(String id, String material, String type);
}
