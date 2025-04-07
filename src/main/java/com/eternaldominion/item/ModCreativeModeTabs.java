package com.eternaldominion.item;

import com.eternaldominion.EternalDominion;
import com.eternaldominion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EternalDominion.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OVERWOLD_FACTION= CREATIVE_MODE_TABS.register("overwolrd_faction",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.PURIFIED_IRON_ORE.get()))
                    .title(Component.translatable("creativetab.eternaldominion.overwold_faction"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModBlocks.PURIFIED_IRON_ORE.get());
                        output.accept(ModBlocks.PURIFIED_GOLD_ORE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> NETHER_FACTION = CREATIVE_MODE_TABS.register("nether_faction",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(Blocks.CRIMSON_NYLIUM))
                    .withTabsBefore(OVERWOLD_FACTION.getId())
                    .title(Component.translatable("creativetab.eternaldominion.nether_faction"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModItems.ITEMPLACEHOLDER.get());
                        output.accept(ModItems.NETHERWART_STEW.get());
                        output.accept(ModItems.WARPED_FUNGUS_STEW.get());
                        output.accept(ModItems.CRIMSON_FUNGUS_STEW.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> ENDER_FACTION = CREATIVE_MODE_TABS.register("ender_faction_",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.END_GRASS.get()))
                    .withTabsBefore(NETHER_FACTION.getId())
                    .title(Component.translatable("creativetab.eternaldominion.ender_faction"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModBlocks.END_GRASS.get());
                    })
                    .build());

    public static  void register(IEventBus eventbus) {
        CREATIVE_MODE_TABS.register(eventbus);
    }
}
