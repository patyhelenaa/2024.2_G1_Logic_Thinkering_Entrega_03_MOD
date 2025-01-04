package com.logic_thinkering.itens;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ConcreteRegisterArmor implements StrategyRegister {

    @Override
    public Item register(String id) {
        throw new UnsupportedOperationException("Use register with material and type for armor.");
    }

    @Override
    public Item register(String id,  material, String type) {
        Function<Item.Settings, Item> factory = (settings) -> new ArmorItem(
                material.getMaterial(),
                EquipmentType.valueOf(type),
                settings);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, id));
        Item.Settings settings = new Item.Settings();
        Item item = factory.apply(settings.registryKey(key));
        Item result = Registry.register(Registries.ITEM, key, item);
        insertOnGroup(result);
        return(result);
    }
}
