package net.vinicius.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vinicius.tutorialmod.TutorialMod;
import net.vinicius.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItens.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItens.PINK_GARNET);
                        entries.add(ModItens.RAW_PINK_GARNET);
                        entries.add(ModItens.PINK_GARNET_SWORD);
                        entries.add(ModItens.PINK_GARNET_PICKAXE);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                    }).build());

//    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
//            Identifier.of(TutorialMod.MOD_ID,"pink_garnet_Blocks"),
//            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
//                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
//                    .entries((displayContext, entries) -> {
//                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
//                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
//                    }).build());



    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
