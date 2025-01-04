package com.logic_thinkering;

import com.logic_thinkering.itens.*;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicThinkeringItem {
    public Map<String, ConcreteTool> tools = new HashMap<>();

    public List<ConcreteItem> items = new ArrayList<>();
    public List<ConcreteArmor> armors = new ArrayList<>();
    public List<LogicThinkeringArmorMaterial> armorMaterials = new ArrayList<>();

    public LogicThinkeringItem() {

        armorMaterials.add(new LogicThinkeringArmorMaterial("REINFORCED_COPPER", 37, new int[]{3, 6, 8, 3, 11}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.NETHERITE));
        armorMaterials.add(new LogicThinkeringArmorMaterial("REINFORCED_EMERALD", 37, new int[]{3, 6, 8, 3, 11}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.NETHERITE));
        armorMaterials.add(new LogicThinkeringArmorMaterial("REINFORCED_AMETHYST", 37, new int[]{3, 6, 8, 3, 11}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_GOLD_ARMOR, EquipmentModels.NETHERITE));

        items.add(new ConcreteItem("reinforced_copper_ingot"));
        insertItemCommon("reinforced_emerald_shard");
        insertItemCommon("reinforced_amethyst_shard");

    }

    private void insertAllArmors() {
        for (ArmorType armorType : ArmorType.values()) {
            ConcreteArmor prototype = new ConcreteArmor(armorMaterials.getFirst().getName().toLowerCase() + "_" + armorType.name().toLowerCase(), armorType, armorMaterials.getFirst());
            armors.add(prototype);

            for (int i = 1; i < armorMaterials.size(); i++) {
                ConcreteArmor clone = prototype.clone();
                clone.updateMaterial(armorMaterials.get(i));
                clone.register("reinforced_" + armorMaterials.get(i).getName().toLowerCase() + "_" + armorType.name().toLowerCase());
                armors.add(clone);
            }
        }
    }

    private void insertItemCommon(String id){
        ConcreteItem clone = items.getFirst().clone();
        clone.register(id);
        items.add(clone);
    }

}
