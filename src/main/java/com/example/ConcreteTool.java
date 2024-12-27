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

public class ConcreteTool extends PrototypeItem {
    private enum ToolType { AXE, HOE, PICKAXE, SHOVEL, SWORD; }
    private enum Material {
        REINFORCED_COPPER, REINFORCED_EMERALD, REINFORCED_AMETHYST;
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
    public PrototypeItem clone() {
        return new ConcreteTool(this.id, this.type.name(), this.material.name());
    }

    public void setType(String type) { this.type = ToolType.valueOf(type.toUpperCase()); }
    public void setMaterial(String material) { this.material = Material.valueOf(material.toUpperCase()); }

    public void updateItem(String id, Function<Item.Settings, Item> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.nomeMod, id));
        Item.Settings settings = new Item.Settings();
        Item item = factory.apply(settings.registryKey(key));
        ConcreteTool.ITEM = Registry.register(Registries.ITEM, key, item);
        GuiaInventario.adicionarItem(ConcreteTool.ITEM);
    }

    public void setId(String id) {
        this.id = id;

        updateItem(id, (settings) -> {
            ToolMaterial material = MateriaisFerramenta.valueOf(this.material.name());
            switch (this.type) {
                case SWORD:
                    return new SwordItem(material, 3, -1.9F, settings);
                case AXE:
                    return new AxeItem(material, 6, -2.7F, settings);
                case PICKAXE:
                    return new PickaxeItem(material, 1, -2.8F, settings);
                case SHOVEL:
                    return new ShovelItem(material, 1.5F, -3.0F, settings);
                case HOE:
                    return new HoeItem(material, -3, 0.0F, settings);
                default:
                    throw new IllegalArgumentException("UNKNOWN TOOL TYPE: " + this.type);
            }
        });
    }


}