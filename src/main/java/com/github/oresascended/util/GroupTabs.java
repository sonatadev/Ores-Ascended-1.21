package com.github.oresascended.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class GroupTabs {
    public static List<DeferredRegister<CreativeModeTab>> tabRegisters = new ArrayList<>();

    public static void initializeRegisters(){
        ModCreativeModeTabs.register();
    }

    public static void addCreativeModeTabRegister(DeferredRegister<CreativeModeTab> tabRegister){
        tabRegisters.add(tabRegister);
    }
}
