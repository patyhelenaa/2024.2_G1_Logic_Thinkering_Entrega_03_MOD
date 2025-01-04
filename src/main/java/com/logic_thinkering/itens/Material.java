package com.logic_thinkering.itens;

import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public interface Material {
    void updateSettings(Integer[] values);
    void updateItemTag(TagKey<Item> repairIngredient);
}
