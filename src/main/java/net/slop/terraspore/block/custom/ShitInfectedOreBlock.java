package net.slop.terraspore.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.slop.terraspore.Utils;
import net.slop.terraspore.block.ModBlocks;

public class ShitInfectedOreBlock extends Block {

    public ShitInfectedOreBlock(Properties pProperties) {
        super(pProperties);
    }

    public static boolean canReplace(Level level, BlockPos pos) {
        return Utils.BlockIsOre(level.getBlockState(pos)) && !(level.getBlockState(pos).getBlock() instanceof ShitInfectedOreBlock);
    }

    public static BlockState getReplacementState(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);

        if (state.is(Blocks.IRON_ORE)) {
        } else if (state.is(Blocks.COPPER_ORE)) {
        } else if (state.is(Blocks.DIAMOND_ORE)) {
        } else if (state.is(Blocks.LAPIS_ORE)) {
        } else if (state.is(Blocks.COAL_ORE)) {
            return ModBlocks.SHIT_INFECTED_COAL_ORE.get().defaultBlockState();
        } else if (state.is(Blocks.DEEPSLATE_COAL_ORE)) {
        } else if (state.is(Blocks.EMERALD_ORE)) {
        } else if (state.is(Blocks.GOLD_ORE)) {
        } else if (state.is(Blocks.REDSTONE_ORE)) {
        } else if (state.is(Blocks.NETHER_QUARTZ_ORE)) {
        } else if (state.is(Blocks.NETHER_GOLD_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_REDSTONE_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_LAPIS_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_IRON_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_GOLD_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_EMERALD_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_DIAMOND_ORE)) {
        } else if (state.is(Blocks.DEEPSLATE_COPPER_ORE)) {

        }

        return null; //TODO BAAAAD ?
    }
}
