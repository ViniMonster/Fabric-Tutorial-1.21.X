package net.vinicius.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vinicius.tutorialmod.TutorialMod;
import net.vinicius.tutorialmod.item.custom.ChiselItem;
import net.vinicius.tutorialmod.item.custom.DrinkItem;

import java.util.List;

public class ModItens {

    public static final Item PINK_GARNET = registerItem("pink_garnet",new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes",new Item(new Item.Settings()));

    public static final Item CHISEL =  registerItem("chisel",new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item CAULIFLOWER =  registerItem("cauliflower",new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip."+ TutorialMod.MOD_ID + ".cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item DIVINE_POTION =  registerItem("divine_potion",new DrinkItem(new Item.Settings().food(ModFoodComponents.DIVINE_POTION).maxCount(1)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip."+ TutorialMod.MOD_ID + ".divine_potion.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",new Item(new Item.Settings()));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(PINK_GARNET_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(PINK_GARNET_PICKAXE);
        });
    }

}
