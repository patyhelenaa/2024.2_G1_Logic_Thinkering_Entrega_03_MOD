package com.logic_thinkering;

import com.logic_thinkering.itens.*;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import java.util.HashMap;
import java.util.Map;

public class LogicThinkeringItem {
    public Map<String, ConcreteItem> items = new HashMap<>();
    public Map<String, ConcreteArmor> armors = new HashMap<>();
    public Map<String, ConcreteTool> tools = new HashMap<>();

    public LogicThinkeringItem() {
        LogicThinkeringArmorMaterial REINFORCED_COPPER = new LogicThinkeringArmorMaterial(
                37,
                new int[]{3, 6, 8, 3, 11},
                15,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                3.0F,
                0.1F,
                ItemTags.REPAIRS_GOLD_ARMOR,
                EquipmentModels.NETHERITE
        );

        REINFORCED_EMERALD
        REINFORCED_AMETHYST
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
