package com.github.oresascended.item.tools;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PickaxeInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items PICKAXES = DeferredRegister.createItems(MODID);

    public static final DeferredItem<PickaxeItem> SAPPHIRE_PICKAXE = PICKAXES.register("sapphire_pickaxe",
            () ->  new PickaxeItem(MyToolTiers.SAPPHIRE_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    MyToolTiers.SAPPHIRE_TIER, 1, -2.8f
            ))));

    public static final DeferredItem<PickaxeItem> RUBY_PICKAXE = PICKAXES.register("ruby_pickaxe",
            () -> new PickaxeItem(MyToolTiers.RUBY_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    MyToolTiers.RUBY_TIER, 1, -2.8f
            ))));

    public static final DeferredItem<PickaxeItem> CELESTIUM_PICKAXE = PICKAXES.register("celestium_pickaxe",
            () -> new PickaxeItem(MyToolTiers.CELESTIUM_TIER, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    MyToolTiers.CELESTIUM_TIER, 1, -2.8f
            ))));

    //register to the event bus
    public static void register(){
        GroupItems.addToolRegister(PICKAXES);
    }

}
