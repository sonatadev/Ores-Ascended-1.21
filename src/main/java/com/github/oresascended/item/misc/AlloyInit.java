package com.github.oresascended.item.misc;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AlloyInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items ALLOYS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> AQUAMARINE = ALLOYS.register("aquamarine",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
            ));

    public static final DeferredItem<Item> CELESTIUM = ALLOYS.register("celestium",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.RARE)
            ));

    public static final DeferredItem<Item> CRIMSONITE = ALLOYS.register("crimsonite",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
            ));

    //register to the event bus
    public static void register(){
        GroupItems.itemRegisters.add(ALLOYS);
    }

}
