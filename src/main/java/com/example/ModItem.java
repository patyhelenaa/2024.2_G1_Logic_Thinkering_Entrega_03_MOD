package com.example;

import java.util.HashMap;
import java.util.Map;

public class ModItem {
    public Map<String, ConcreteItem> items = new HashMap<>();
    public Map<String, ConcreteArmor> armors = new HashMap<>();
    public Map<String, ConcreteTool> tools = new HashMap<>();

    public ModItem() {
        String[] materials = {"EMERALD", "AMETHYST"};
        String[] armorTypes = {"HELMET", "CHESTPLATE", "LEGGINGS", "BOOTS"};
        String[] toolTypes = {"SWORD", "AXE", "PICKAXE", "SHOVEL", "HOE"};

        ConcreteItem prototypeItem = new ConcreteItem("reinforced_copper_ingot");
        insertItems("shard", prototypeItem, materials, items, "reinforced_copper_ingot");

        for(String armorType : armorTypes)
            insertItems(armorType.toLowerCase(), new ConcreteArmor("reinforced_copper_" + armorType.toLowerCase(), armorType, "REINFORCED_COPPER"), materials, armors, "reinforced_copper_" + armorType.toLowerCase());

        for(String tool : toolTypes)
            insertItems(tool.toLowerCase(), new ConcreteTool("reinforced_copper_" + tool.toLowerCase(), tool, "REINFORCED_COPPER"), materials, tools, "reinforced_copper_" + tool.toLowerCase());
    }

    private <T extends PrototypeItem> void insertItems(String typePrototype, T prototype, String[] types, Map<String, T> storage, String prototypeId) {
        storage.put(prototypeId, prototype);
        for (String type : types) {
            String id = "reinforced_" + type.toLowerCase() + "_" + typePrototype;
            T item = (T) prototype.clone();
            item.updateMaterial("REINFORCED_" + type);
            item.register(id);
            storage.put(id, item);
        }
    }

}
