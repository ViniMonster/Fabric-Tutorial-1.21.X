package net.vinicius.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.vinicius.tutorialmod.TutorialMod;
import net.vinicius.tutorialmod.block.ModBlocks;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {

    public static final Map<Block, List<Block>> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, List.of(
                            Blocks.STONE_BRICKS,
                            Blocks.CRACKED_STONE_BRICKS,
                            Blocks.MOSSY_STONE_BRICKS
                    ),

                    Blocks.END_STONE, List.of(
                            Blocks.END_STONE_BRICKS,
                            Blocks.OBSIDIAN
                    ),

                    Blocks.DIAMOND_BLOCK, List.of(
                            ModBlocks.PINK_GARNET_BLOCK,
                            ModBlocks.RAW_PINK_GARNET_BLOCK
                    ),

                    Blocks.GOLD_BLOCK, List.of(
                            Blocks.NETHERITE_BLOCK,
                            Blocks.ANCIENT_DEBRIS
                    )
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block clickedBlock = world.getBlockState(pos).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient) {

                List<Block> possibleBlocks = CHISEL_MAP.get(clickedBlock);
                Random random = world.getRandom();

                Block chosenBlock = possibleBlocks.get(random.nextInt(possibleBlocks.size()));

                world.setBlockState(pos, chosenBlock.getDefaultState());

                context.getStack().damage(1,
                        (ServerWorld) world,
                        (ServerPlayerEntity) context.getPlayer(),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND)
                );

                world.playSound(
                        null,
                        pos,
                        SoundEvents.BLOCK_AMETHYST_CLUSTER_HIT,
                        SoundCategory.BLOCKS,
                        1.0F,
                        1.0F
                );
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip."+ TutorialMod.MOD_ID + ".chisel.shift_down.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip."+ TutorialMod.MOD_ID + ".chisel.tooltip"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}

