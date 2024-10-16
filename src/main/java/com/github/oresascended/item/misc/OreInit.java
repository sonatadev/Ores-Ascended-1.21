package com.github.oresascended.item.misc;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OreInit {

    private static  final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items ORES = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> SAPPHIRE = ORES.register("sapphire",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));

    public static final DeferredItem<Item> RUBY = ORES.register("ruby",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));
    public static final DeferredItem<Item> AETHERIUM = ORES.register("aetherium",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));

    //register to the event bus
    public static void register(){
        GroupItems.addItemRegister(ORES);
    }
}
