package com.github.oresascended.item.blocks;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OreBlockItemInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items ORE_BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static void register(){
        GroupItems.itemRegisters.add(ORE_BLOCK_ITEMS);
    }
}
