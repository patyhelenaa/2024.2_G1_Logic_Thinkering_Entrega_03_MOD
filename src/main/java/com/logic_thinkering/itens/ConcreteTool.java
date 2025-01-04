package com.logic_thinkering.itens;

import net.minecraft.item.Item;

public class ConcreteTool extends PrototypeItem {
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
        strategy = new ConcreteRegisterTool();
        this.type = ToolType.valueOf(type.toUpperCase());
        this.material = Material.valueOf(material.toUpperCase());
        if(id != null) setId(id);
    }

    @Override
    public ConcreteTool clone() {
        return new ConcreteTool(null, this.type.name(), this.material.name());
    }

    @Override
    public void register(String id) {
        ITEM = strategy.register(id, this.material.name(), this.type.name());
    }

    public void setType(String type) {
        this.type = ToolType.valueOf(type.toUpperCase());
    }

    public void updateMaterial(String material) {
        this.material = Material.valueOf(material.toUpperCase());
    }

    public void setId(String id) {
        this.id = id;
        register(id);
    }

}