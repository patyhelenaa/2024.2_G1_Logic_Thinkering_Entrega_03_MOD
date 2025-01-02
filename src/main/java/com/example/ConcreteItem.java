package com.example;

import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ConcreteItem implements PrototypeItem {
    private String id;
    public static Item ITEM;

    public ConcreteItem(String id) {
        if(id != null) setId(id);
    }

    @Override
    public ConcreteItem clone() {
        return new ConcreteItem(null);
    }

    @Override
    public void updateItem(String id) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, id));
        Function<Item.Settings, Item> factory = Item::new;
        Item item = factory.apply(new Item.Settings().registryKey(key));
        if (item instanceof BlockItem blockItem) blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        ConcreteItem.ITEM = Registry.register(Registries.ITEM, key, item);
        insertOnGroup(ConcreteItem.ITEM);
    }

    public void updateMaterial(String material) {}

    public void setId(String id) {
        this.id = id;
        updateItem(id);
    }


}
