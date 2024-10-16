package com.github.oresascended.util;

import com.github.oresascended.OresAscended;
import com.github.oresascended.item.misc.AlloyInit;
import com.github.oresascended.item.misc.OreInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OresAscended.MODID);

    public static final Supplier<CreativeModeTab> ORES_ASCENDED_TAB = CREATIVE_MODE_TABS.register("ores_ascended_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(OreInit.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.oresascended"))
                    .displayItems((parameters, output) -> {
                        for(DeferredRegister<? extends Item> itemRegister : GroupItems.allItems){
                            itemRegister.getEntries().forEach(deferredItem -> {
                                output.accept(deferredItem.get());
                            });
                        }
                    })
                    .build());

    public static final Supplier<CreativeModeTab> ORES_ASCENDED_EVOLVED_TAB = CREATIVE_MODE_TABS.register("ores_ascended_evolved_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(AlloyInit.CRIMSONITE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(OresAscended.MODID, "ores_ascended_tab"))
                    .title(Component.translatable("creativetab.oresascendedevolved"))
                    .displayItems((parameters, output) -> {
                        for(DeferredRegister<? extends Item> itemRegister : GroupItems.allItems){
                            itemRegister.getEntries().forEach(deferredItem -> {
                                output.accept(deferredItem.get());
                            });
                        }
                    })
                    .build());


    public static void register(){
        GroupTabs.tabRegisters.add(CREATIVE_MODE_TABS);
    }
}
