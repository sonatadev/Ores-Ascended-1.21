package com.github.oresascended.util;

import com.github.oresascended.item.armors.BootsInit;
import com.github.oresascended.item.armors.ChestplateInit;
import com.github.oresascended.item.armors.HelmetInit;
import com.github.oresascended.item.armors.LeggingsInit;
import com.github.oresascended.item.blocks.BlockItemInit;
import com.github.oresascended.item.blocks.OreBlockItemInit;
import com.github.oresascended.item.misc.AlloyInit;
import com.github.oresascended.item.misc.FuelInit;
import com.github.oresascended.item.misc.ItemInit;
import com.github.oresascended.item.misc.OreInit;
import com.github.oresascended.item.tools.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class GroupItems {
    public static List<DeferredRegister<? extends Item>> allItems = new ArrayList<>();
    public static List<DeferredRegister<? extends Item>> itemRegisters = new ArrayList<>();
    public static List<DeferredRegister<? extends Item>> toolRegisters = new ArrayList<>();
    public static List<DeferredRegister<? extends Item>> armorRegisters = new ArrayList<>();

    public static void initializeRegisters(){

        ItemInit.register();
        FuelInit.register();
        AlloyInit.register();
        OreInit.register();
        BlockItemInit.register();
        OreBlockItemInit.register();
        //tools registration
        SwordInit.register();
        PickaxeInit.register();
        AxeInit.register();
        ShovelInit.register();
        HoeInit.register();
        //armor registration
        HelmetInit.register();
        ChestplateInit.register();
        LeggingsInit.register();
        BootsInit.register();
    }

    public static void addItemRegister(DeferredRegister<? extends Item> itemRegister){
        itemRegisters.add(itemRegister);
    }

    public static void addToolRegister(DeferredRegister<? extends Item> toolRegister){
        toolRegisters.add(toolRegister);
    }

    public static void addArmorRegister(DeferredRegister<? extends Item> armorRegister){
        armorRegisters.add(armorRegister);
    }

    public static void addAllItemRegisters(){
        allItems.addAll(itemRegisters);
        allItems.addAll(toolRegisters);
        allItems.addAll(armorRegisters);
    }


}
