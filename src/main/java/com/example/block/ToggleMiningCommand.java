package com.example.block;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class ToggleMiningCommand implements Command<ServerCommandSource> {

    @Override
    public int run(CommandContext<ServerCommandSource> context) {
        // Alterna o estado de mineração
        AutoMiningBlock.toggleMining();

        // Exibe uma mensagem indicando se a mineração foi ligada ou desligada
        String status = AutoMiningBlock.isMiningEnabled ? "ligado" : "desligado";
        return Command.SINGLE_SUCCESS;
    }

    // Registra o comando
    public static void register() {
        // O correto é registrar o comando com o dispatcher e registryAccess.
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    CommandManager.literal("toggleMining")
                            .executes(new ToggleMiningCommand())  // Registra o comando
            );
        });
    }
}
