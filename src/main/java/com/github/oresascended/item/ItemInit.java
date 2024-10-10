package com.github.oresascended.item;

import com.github.oresascended.OresAscended;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {


    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> SAPPHIRE = ITEMS.registerSimpleItem("sapphire",
            new Item.Properties()
            .fireResistant());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
