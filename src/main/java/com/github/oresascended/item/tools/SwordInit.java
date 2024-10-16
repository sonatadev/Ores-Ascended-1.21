package com.github.oresascended.item.tools;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SwordInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items SWORDS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<SwordItem> SAPPHIRE_SWORD = SWORDS.register("sapphire_sword",
            () ->  new SwordItem(MyToolTiers.SAPPHIRE_TIER, new Item.Properties().attributes(SwordItem.createAttributes(
                    MyToolTiers.SAPPHIRE_TIER, 3, -2.4f
            ))));

    public static final DeferredItem<SwordItem> RUBY_SWORD = SWORDS.register("ruby_sword",
            () -> new SwordItem(MyToolTiers.RUBY_TIER, new Item.Properties().attributes(SwordItem.createAttributes(
                    MyToolTiers.RUBY_TIER, 3, -2.4f
            ))));

    public static final DeferredItem<SwordItem> CELESTIUM_SWORD = SWORDS.register("celestium_sword",
            () -> new SwordItem(MyToolTiers.CELESTIUM_TIER, new Item.Properties().attributes(SwordItem.createAttributes(
                    MyToolTiers.CELESTIUM_TIER, 3, -2.4f
            ))));

    //register to the event bus
    public static void register(){
        GroupItems.addToolRegister(SWORDS);
    }
}
