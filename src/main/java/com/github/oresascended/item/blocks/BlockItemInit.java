package com.github.oresascended.item.blocks;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockItemInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static void register(){
        GroupItems.itemRegisters.add(BLOCK_ITEMS);
    }
}
