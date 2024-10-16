package com.github.oresascended.item.tools;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AxeInit {
    private static final String MODID = OresAscended.MODID;


    public static final DeferredRegister.Items AXES = DeferredRegister.createItems(MODID);



    public static final DeferredItem<AxeItem> SAPPHIRE_AXE = AXES.register("sapphire_axe",
            () ->  new AxeItem(MyToolTiers.SAPPHIRE_TIER, new Item.Properties().attributes(AxeItem.createAttributes(
                    MyToolTiers.SAPPHIRE_TIER, 6, -3.2f
            ))));

    public static final DeferredItem<AxeItem> RUBY_AXE = AXES.register("ruby_axe",
            () -> new AxeItem(MyToolTiers.RUBY_TIER, new Item.Properties().attributes(AxeItem.createAttributes(
                    MyToolTiers.RUBY_TIER, 6, -3.2f
            ))));

    public static final DeferredItem<AxeItem> CELESTIUM_AXE = AXES.register("celestium_axe",
            () -> new AxeItem(MyToolTiers.CELESTIUM_TIER, new Item.Properties().attributes(AxeItem.createAttributes(
                    MyToolTiers.CELESTIUM_TIER, 6, -3.2f
            ))));

    //register to the event bus
    public static void register(){
        GroupItems.addToolRegister(AXES);
    }

}
