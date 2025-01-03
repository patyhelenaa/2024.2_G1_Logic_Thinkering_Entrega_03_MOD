package com.logic_thinkering;

import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public interface EquipmentModel {
    Identifier COBRE_REFORCADO = Identifier.of(Main.MOD_ID, "cobre_reforcado");
    Identifier ESMERALDA_REFORCADA = Identifier.of(Main.MOD_ID, "esmeralda_reforcada");
    Identifier AMETISTA_REFORCADA = Identifier.of(Main.MOD_ID, "ametista_reforcada");

    private static EquipmentModel buildHumanoid(String path) {
        return EquipmentModel.builder().addHumanoidLayers(Identifier.of(Main.MOD_ID, path)).build();
    }

    static void adicionarModelos(BiConsumer<Identifier, EquipmentModel> equipmentModelBiConsumer){
        equipmentModelBiConsumer.accept(COBRE_REFORCADO, buildHumanoid("cobre_reforcado"));
        equipmentModelBiConsumer.accept(ESMERALDA_REFORCADA, buildHumanoid("esmeralda_reforcada"));
        equipmentModelBiConsumer.accept(AMETISTA_REFORCADA, buildHumanoid("ametista_reforcada"));
    }
}
