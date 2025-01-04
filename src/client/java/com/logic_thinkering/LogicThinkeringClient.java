package com.logic_thinkering;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;

public class LogicThinkeringClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("logic_thinkering_book")
                    .executes(context -> {
                        MinecraftClient.getInstance().setScreen(new CottonClientScreen(new ExampleGui()));
                        return 1;
                    })
            );
        });
        //MinecraftClient.getInstance().setScreen(new CustomLibGuiScreen());
        MinecraftClient.getInstance().setScreen(new CottonClientScreen(new ExampleGui()));

    }
}
