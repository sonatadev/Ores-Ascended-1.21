package com.github.oresascended.item;

import com.github.oresascended.OresAscended;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {


    private static final String MODID = OresAscended.MODID;
    //items container
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    
    public static final DeferredItem<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));
    public static final DeferredItem<Item> TOURMALINE = ITEMS.register("tourmaline",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));



    
    //register to the event bus
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
