package net.slop.terraspore.block.entity;


import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slop.terraspore.TerraSpore;
import net.slop.terraspore.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TerraSpore.MODID);

    public static final RegistryObject<BlockEntityType<InfectedOreBlockEntity>> INFECTED_ORE_BLOCK =
            BLOCK_ENTITIES.register("infected_ore_be", () -> //TODO!
                    BlockEntityType.Builder.of(InfectedOreBlockEntity::new, ModBlocks.INFECTED_ORE.get()).build(null));

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
