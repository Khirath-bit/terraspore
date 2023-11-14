package net.slop.terraspore.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.slop.terraspore.TerraSpore;
import net.slop.terraspore.block.custom.InfectedOreBlock;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InfectedOreBlockEntity extends BlockEntity implements Container {
    private final Instant beginOfLife;
    private static final long TIME_TO_HARVEST = 5;
    private List<ItemStack> items = new ArrayList<>();

    public InfectedOreBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.INFECTED_ORE_BLOCK.get(), pPos, pBlockState);
        this.beginOfLife = Instant.now();
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(Duration.between(beginOfLife, Instant.now()).toSeconds() > TIME_TO_HARVEST){
            System.out.println("DROP " + pPos.toString());
            pLevel.removeBlock(pPos, false); //TODO: maybe false is false
        }
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return items.size() == 0 ? ItemStack.EMPTY : items.get(0);
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {
        items.add(pStack);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true; //TODO ?????
    }

    @Override
    public void clearContent() {

    }
}
