package com.example;

import com.example.ExampleMod;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public interface ModeloEquipamento {
    Identifier COBRE_REFORCADO = Identifier.of(ExampleMod.nomeMod, "cobre_reforcado");
    Identifier ESMERALDA_REFORCADA = Identifier.of(ExampleMod.nomeMod, "esmeralda_reforcada");
    Identifier AMETISTA_REFORCADA = Identifier.of(ExampleMod.nomeMod, "ametista_reforcada");

    private static EquipmentModel buildHumanoid(String path) {
        return EquipmentModel.builder().addHumanoidLayers(Identifier.of(ExampleMod.nomeMod, path)).build();
    }

    static void adicionarModelos(BiConsumer<Identifier, EquipmentModel> equipmentModelBiConsumer){
        equipmentModelBiConsumer.accept(COBRE_REFORCADO, buildHumanoid("cobre_reforcado"));
        equipmentModelBiConsumer.accept(ESMERALDA_REFORCADA, buildHumanoid("esmeralda_reforcada"));
        equipmentModelBiConsumer.accept(AMETISTA_REFORCADA, buildHumanoid("ametista_reforcada"));
    }
}
