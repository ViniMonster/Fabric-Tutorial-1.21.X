package net.vinicius.tutorialmod.fuel;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.vinicius.tutorialmod.TutorialMod;
import net.vinicius.tutorialmod.item.ModItens;

// double shift and type AbstractFurnaceBLockEntity to see all fuels (mark " include non-project items")
public class ModFuels {
    public static void registerModFuels() {
        TutorialMod.LOGGER.info("Registering Mod Fuels for " + TutorialMod.MOD_ID);

        FuelRegistry.INSTANCE.add(ModItens.STARLIGHT_ASHES, 600);

    }
}