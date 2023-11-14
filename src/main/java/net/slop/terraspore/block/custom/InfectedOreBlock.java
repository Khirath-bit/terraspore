package net.slop.terraspore.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.slop.terraspore.Utils;
import net.slop.terraspore.block.ModBlocks;
import net.slop.terraspore.block.entity.InfectedOreBlockEntity;
import net.slop.terraspore.block.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class InfectedOreBlock extends BaseEntityBlock {

    private Block infectedBlock = Blocks.COAL_ORE; //TODO NOT GOOD IF INITIALIZED. problem is if a block gets infected and game closes and opens before harvested, this property is reset effectively

    public InfectedOreBlock(Properties pProperties) {
        super(pProperties);
    }

    public static BlockState getInfectedState(Level level, BlockPos position){
        BlockState desiredState = ModBlocks.INFECTED_ORE.get().defaultBlockState();
        ((InfectedOreBlock)desiredState.getBlock()).infectedBlock = level.getBlockState(position).getBlock();
        return desiredState;
        /*
        * if (pState.is(Blocks.IRON_ORE)) {
        } else if (pState.is(Blocks.COPPER_ORE)) {
        } else if (pState.is(Blocks.DIAMOND_ORE)) {
        } else if (pState.is(Blocks.LAPIS_ORE)) {
        } else if (pState.is(Blocks.COAL_ORE)) {

        } else if (pState.is(Blocks.DEEPSLATE_COAL_ORE)) {
        } else if (pState.is(Blocks.EMERALD_ORE)) {
        } else if (pState.is(Blocks.GOLD_ORE)) {
        } else if (pState.is(Blocks.REDSTONE_ORE)) {
        } else if (pState.is(Blocks.NETHER_QUARTZ_ORE)) {
        } else if (pState.is(Blocks.NETHER_GOLD_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_REDSTONE_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_LAPIS_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_IRON_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_GOLD_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_EMERALD_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_DIAMOND_ORE)) {
        } else if (pState.is(Blocks.DEEPSLATE_COPPER_ORE)) {

        }
        * */
    }

    public static boolean canReplace(Level level, BlockPos position) {
        return Utils.BlockIsOre(level.getBlockState(position));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        InfectedOreBlockEntity entity =  new InfectedOreBlockEntity(pPos, pState);
        Item item = infectedBlock.asItem();

        if (infectedBlock.equals(Blocks.DIAMOND_ORE)) {
            item = Items.DIAMOND;
        } else if (infectedBlock.equals(Blocks.LAPIS_ORE)) {
            item = Items.LAPIS_LAZULI;
        } else if (infectedBlock.equals(Blocks.COAL_ORE)) {
            item = Items.COAL;
        } else if (infectedBlock.equals(Blocks.DEEPSLATE_COAL_ORE)) {
            item = Items.COAL;
        } else if (infectedBlock.equals(Blocks.EMERALD_ORE)) {
            item = Items.EMERALD;
        } else if (infectedBlock.equals(Blocks.REDSTONE_ORE)) {
            item = Items.REDSTONE;
        } else if (infectedBlock.equals(Blocks.NETHER_QUARTZ_ORE)) {
            item = Items.QUARTZ;
        } else if (infectedBlock.equals(Blocks.DEEPSLATE_REDSTONE_ORE)) {
            item = Items.REDSTONE;
        } else if (infectedBlock.equals(Blocks.DEEPSLATE_LAPIS_ORE)) {
            item = Items.LAPIS_LAZULI;
        } else if (infectedBlock.equals(Blocks.DEEPSLATE_EMERALD_ORE)) {
            item = Items.EMERALD;
        } else if (infectedBlock.equals(Blocks.DEEPSLATE_DIAMOND_ORE)) {
            item = Items.DIAMOND;
        }

        entity.setItem(0, new ItemStack(item));
        return entity;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof Container) {
                Containers.dropContents(pLevel, pPos, (Container)blockentity);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide()) {
            return null;
        }

        return createTickerHelper(pBlockEntityType, ModBlockEntities.INFECTED_ORE_BLOCK.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }
}
