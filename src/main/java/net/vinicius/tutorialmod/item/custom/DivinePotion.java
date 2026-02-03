package net.vinicius.tutorialmod.item.custom;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;

public class DivinePotion extends Item {

    public DivinePotion(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {

        return UseAction.DRINK;
    }
}
