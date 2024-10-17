package com.github.oresascended.util;

import com.github.oresascended.block.tile.BlockEntityInit;
import com.github.oresascended.menu.MenuInit;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class GroupMenuTypes {
    public static List<DeferredRegister<MenuType<?>>> menuTypeRegisters = new ArrayList<>();

    public static void initializeRegisters(){
        MenuInit.register();
    }

    public static void addMenuTypeRegisters(DeferredRegister<MenuType<?>> menuTypeRegister){
        menuTypeRegisters.add(menuTypeRegister);
    }
}
