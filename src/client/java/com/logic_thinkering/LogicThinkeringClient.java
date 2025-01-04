package com.logic_thinkering;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.CommandManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import java.util.List;

public class LogicThinkeringClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("logic_thinkering_book")
                    .executes(context -> {

                        List<BookPage> pages = List.of(
                                new BookPage("Página 1 | AND", "The AND gate outputs \"1\" only when all inputs are \"1.\" Otherwise, it outputs \"0.\"", "textures/client/menu-and1.png"),
                                new BookPage("Página 2 | OR", "The OR gate outputs \"1\" if at least one of the inputs is \"1.\" It outputs \"0\" only when all inputs are \"0.\"", "textures/client/menu-or1.png"),
                                new BookPage("Página 3 | NOT", "The NOT gate inverts the input. If the input is \"0,\" the output is \"1,\" and vice versa.", "textures/client/menu-not1.png")
                        );

                        BookGuide book = new BookGuide(pages);

                        MinecraftClient.getInstance().execute(() -> {
                            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new BookGui(book)));
                        });
                        return 1;
                    })
            );
        });
    }
}