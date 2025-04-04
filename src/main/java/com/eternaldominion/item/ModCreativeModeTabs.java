package com.eternaldominion.item;

import com.eternaldominion.EternalDominion;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EternalDominion.MOD_ID);



    public static  void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
