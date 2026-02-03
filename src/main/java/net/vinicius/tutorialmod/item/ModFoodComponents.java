package net.vinicius.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

// double shift and FoodComponents to see all foods (mark " include non-project items")

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build();

    public static final FoodComponent DIVINE_POTION = new FoodComponent.Builder()
            .nutrition(0)
            .saturationModifier(0)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200), 0.100f).build();
}
