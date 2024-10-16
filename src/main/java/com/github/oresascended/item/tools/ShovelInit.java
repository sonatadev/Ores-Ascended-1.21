package com.github.oresascended.item.tools;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ShovelInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items SHOVELS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<ShovelItem> SAPPHIRE_SHOVEL = SHOVELS.register("sapphire_shovel",
            () ->  new ShovelItem(MyToolTiers.SAPPHIRE_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(
                    MyToolTiers.SAPPHIRE_TIER, 1.5f, -3.0f
            ))));

    public static final DeferredItem<ShovelItem> RUBY_SHOVEL = SHOVELS.register("ruby_shovel",
            () -> new ShovelItem(MyToolTiers.RUBY_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(
                    MyToolTiers.RUBY_TIER, 1.5f, -3.0f
            ))));

    public static final DeferredItem<ShovelItem> CELESTIUM_SHOVEL = SHOVELS.register("celestium_shovel",
            () -> new ShovelItem(MyToolTiers.CELESTIUM_TIER, new Item.Properties().attributes(ShovelItem.createAttributes(
                    MyToolTiers.CELESTIUM_TIER, 1.5f, -3.0f
            ))));

    //register to the event bus
    public static void register(){
        GroupItems.addToolRegister(SHOVELS);
    }

}
