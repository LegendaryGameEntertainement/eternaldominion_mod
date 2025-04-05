package com.eternaldominion.item;

import com.eternaldominion.EternalDominion;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EternalDominion.MOD_ID);

    public static final RegistryObject<Item> ITEMPLACEHOLDER = ITEMS.register("itemplaceholder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHERWART_STEW = ITEMS.register("netherwart_stew",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
