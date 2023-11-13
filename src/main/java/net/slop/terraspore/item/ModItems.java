package net.slop.terraspore.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slop.terraspore.TerraSpore;
import net.slop.terraspore.item.custom.ShitItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TerraSpore.MODID);

    public static final RegistryObject<Item> SHIT = ITEMS.register("shit", () -> new ShitItem(new Item.Properties()));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
