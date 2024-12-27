package com.example.screenhandler;

import com.example.ExampleMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<MiningMachineScreenHandler> MINING_MACHINE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
            Identifier.of(ExampleMod.MOD_ID, "bloco_mineracao"),
            new ScreenHandlerType<>(MiningMachineScreenHandler::new, FeatureSet.empty())
    );

    public static void inicializa() {}
}
