package net.slop.terraspore.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.slop.terraspore.block.ModBlocks;
import net.slop.terraspore.block.custom.InfectedOreBlock;

public class ShitItem extends Item {
    public ShitItem(Properties pProperties) {
        super(pProperties);

        pProperties.stacksTo(500);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if(level.isClientSide){
            return InteractionResult.FAIL;
        }

        BlockPos position = pContext.getClickedPos();
        BlockState state = level.getBlockState(position);

        pContext.getPlayer().sendSystemMessage(Component.literal(state.getBlock().getDescriptionId()));

        if(InfectedOreBlock.canReplace(level, position)){
            BlockState infectedState = ((InfectedOreBlock)ModBlocks.INFECTED_ORE.get()).getInfectedState(level, position);

            level.setBlock(position, infectedState, 2|1);
            level.gameEvent(pContext.getPlayer(), GameEvent.BLOCK_PLACE, position);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }
}
