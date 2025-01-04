package com.logic_thinkering.itens;

import net.minecraft.item.*;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ConcreteRegisterTool implements StrategyRegister {

    @Override
    public Item register(String id) {
        throw new UnsupportedOperationException("Use register with material and type for armor.");
    }

    @Override
    public Item register(String id, String material, String type) {
        Function<Item.Settings, Item> factory = (settings) -> {
            ToolMaterial materialtool = ModToolMaterial.valueOf(material);

            return switch (type) {
                case "SWORD" -> new SwordItem(materialtool, 3, -1.9F, settings);
                case "AXE" -> new AxeItem(materialtool, 6, -2.7F, settings);
                case "PICKAXE" -> new PickaxeItem(materialtool, 1, -2.8F, settings);
                case "SHOVEL" -> new ShovelItem(materialtool, 1.5F, -3.0F, settings);
                case "HOE" -> new HoeItem(materialtool, -3, 0.0F, settings);
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };

        };

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, id));
        Item.Settings settings = new Item.Settings();
        Item item = factory.apply(settings.registryKey(key));
        Item result = Registry.register(Registries.ITEM, key, item);
        insertOnGroup(result);
        return(result);
    }


}