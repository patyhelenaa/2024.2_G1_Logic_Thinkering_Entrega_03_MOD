package com.example;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ConcreteTool implements PrototypeItem {
    private enum ToolType {
        AXE, HOE, PICKAXE, SHOVEL, SWORD
    }
    private enum Material {
        REINFORCED_COPPER, REINFORCED_EMERALD, REINFORCED_AMETHYST
    }

    public static Item ITEM;
    private String id;
    private ToolType type;
    private Material material;

    public ConcreteTool(String id, String type, String material) {
        this.id = id;
        this.type = ToolType.valueOf(type.toUpperCase());
        this.material = Material.valueOf(material.toUpperCase());
    }

    @Override
    public ConcreteTool clone() {
        return new ConcreteTool(this.id, this.type.name(), this.material.name());
    }

    @Override
    public void updateItem(String id) {
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
        ConcreteTool.ITEM = Registry.register(Registries.ITEM, key, item);

        insertOnGroup(ConcreteTool.ITEM);
    }

    public void setType(String type) {
        this.type = ToolType.valueOf(type.toUpperCase());
    }

    public void setMaterial(String material) {
        this.material = Material.valueOf(material.toUpperCase());
    }

    public void setId(String id) {
        this.id = id;
        updateItem(id);
    }

}