package com.example;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ConcreteRegisterTool implements StrategyRegister {

    @Override
    public Item register(String id) {
        Function<Item.Settings, Item> factory = (settings) -> {
            ToolMaterial material = MateriaisFerramenta.valueOf(this.material.name());
            return switch (this.type) {
                case SWORD -> new SwordItem(material, 3, -1.9F, settings);
                case AXE -> new AxeItem(material, 6, -2.7F, settings);
                case PICKAXE -> new PickaxeItem(material, 1, -2.8F, settings);
                case SHOVEL -> new ShovelItem(material, 1.5F, -3.0F, settings);
                case HOE -> new HoeItem(material, -3, 0.0F, settings);
            };
        };

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, id));
        Item.Settings settings = new Item.Settings();
        Item item = factory.apply(settings.registryKey(key));
        return(Registry.register(Registries.ITEM, key, item));
    }

}