package com.github.oresascended.item.misc;

import com.github.oresascended.OresAscended;

import com.github.oresascended.util.GroupItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {


    private static final String MODID = OresAscended.MODID;
    //items container
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static void register(){
        GroupItems.itemRegisters.add(ITEMS);
    }

}
