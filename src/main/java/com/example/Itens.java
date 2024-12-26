package com.example;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

public class Itens {

    public static Item COBRE_REFORCADO = RegistrarItem.registrarItemComum("cobre_reforcado");
    public static Item ESMERALDA_REFORCADO = RegistrarItem.registrarItemComum("esmeralda_reforcado");
    public static Item AMETISTA_REFORCADO = RegistrarItem.registrarItemComum("ametista_reforcado");

    public static Item BOTA_COBRE_REFORCADA = RegistrarItem.registrarUtilizavel("botas_cobre_reforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.REINFORCED_COPPER, EquipmentType.BOOTS, settings);
    });
    public static Item BOTA_ESMERALDA_REFORCADA = RegistrarItem.registrarUtilizavel("botas_esmeralda_reforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.REINFORCED_EMERALD, EquipmentType.BOOTS, settings);
    });
    public static Item BOTA_AMETISTA_REFORCADA = RegistrarItem.registrarUtilizavel("botas_ametista_reforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.REINFORCED_AMETHYST, EquipmentType.BOOTS, settings);
    });

    public static Item aa = RegistrarItem.registrarUtilizavel("botas_ametista_reaaaaforcada", (settings) -> {
        return new ArmorItem(MateriaisArmadura.REINFORCED_AMETHYST, EquipmentType.LEGGINGS, settings);
    });

    public static void Inicializa() {
        GuiaInventario.adicionarItem(COBRE_REFORCADO);
        GuiaInventario.adicionarItem(ESMERALDA_REFORCADO);
        GuiaInventario.adicionarItem(AMETISTA_REFORCADO);
        GuiaInventario.adicionarItem(BOTA_COBRE_REFORCADA);
        GuiaInventario.adicionarItem(BOTA_ESMERALDA_REFORCADA);
        GuiaInventario.adicionarItem(BOTA_AMETISTA_REFORCADA);
    }
}
