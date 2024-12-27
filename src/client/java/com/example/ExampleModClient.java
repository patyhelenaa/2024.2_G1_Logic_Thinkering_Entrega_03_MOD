package com.example;

import com.example.screen.MiningMachineScreen;
import com.example.screenhandler.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ExampleModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreens.register(ModScreenHandlers.MINING_MACHINE_SCREEN_HANDLER, MiningMachineScreen::new);
	}
}