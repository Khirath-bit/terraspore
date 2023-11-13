package net.slop.terraspore.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slop.terraspore.TerraSpore;
import net.slop.terraspore.block.custom.ShitInfectedCoalOreBlock;
import net.slop.terraspore.block.custom.ShitInfectedOreBlock;
import net.slop.terraspore.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TerraSpore.MODID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Block> SHIT_INFECTED_COAL_ORE = registerBlock("shit_infected_coal_ore",
            () -> new ShitInfectedCoalOreBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).sound(SoundType.BASALT)));

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
