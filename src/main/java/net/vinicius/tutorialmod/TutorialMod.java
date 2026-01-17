package net.vinicius.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.vinicius.tutorialmod.block.ModBlocks;
import net.vinicius.tutorialmod.item.ModItemGroups;
import net.vinicius.tutorialmod.item.ModItens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItens.registerModItems();
        ModBlocks.registerModBlocks();
	}
}