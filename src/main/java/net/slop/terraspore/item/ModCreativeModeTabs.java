package net.slop.terraspore.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.slop.terraspore.TerraSpore;
import net.slop.terraspore.block.ModBlocks;
import net.slop.terraspore.block.entity.ModBlockEntities;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TerraSpore.MODID);

    public static final RegistryObject<CreativeModeTab> TERRA_SPORE_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("terraspore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SHIT.get()))
                    .title(Component.translatable("creativetab.terraspore_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SHIT.get());
                        pOutput.accept(ModBlocks.INFECTED_ORE.get());
                    })
                    .build());

    public static void register(IEventBus bus){
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(bus);
    }
}
