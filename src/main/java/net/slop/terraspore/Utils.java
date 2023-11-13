package net.slop.terraspore;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Utils {
    public static boolean BlockIsOre(BlockState blockState){
        return blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.COPPER_ORE) || blockState.is(Blocks.DIAMOND_ORE) ||
                blockState.is(Blocks.LAPIS_ORE) || blockState.is(Blocks.COAL_ORE) || blockState.is(Blocks.DEEPSLATE_COAL_ORE) ||
                blockState.is(Blocks.EMERALD_ORE) || blockState.is(Blocks.GOLD_ORE) || blockState.is(Blocks.REDSTONE_ORE) ||
                blockState.is(Blocks.NETHER_QUARTZ_ORE) || blockState.is(Blocks.NETHER_GOLD_ORE) || blockState.is(Blocks.DEEPSLATE_REDSTONE_ORE) ||
                blockState.is(Blocks.DEEPSLATE_LAPIS_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE) || blockState.is(Blocks.DEEPSLATE_GOLD_ORE) ||
                blockState.is(Blocks.DEEPSLATE_EMERALD_ORE) || blockState.is(Blocks.DEEPSLATE_DIAMOND_ORE) || blockState.is(Blocks.DEEPSLATE_COPPER_ORE);
    }
}
