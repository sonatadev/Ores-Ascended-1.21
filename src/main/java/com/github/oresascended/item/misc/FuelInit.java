package com.github.oresascended.item.misc;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FuelInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items FUELS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> BRIGHTCOAL = FUELS.register("brightcoal",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));

    public static final DeferredItem<Item> SHADOWFIRE_CORE = FUELS.register("shadowfire_core",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));

    //register to the event bus
    public static void register(){
        GroupItems.itemRegisters.add(FUELS);
    }

}
