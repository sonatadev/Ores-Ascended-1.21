package com.github.oresascended.item.tools;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HoeInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items HOES = DeferredRegister.createItems(MODID);

    public static final DeferredItem<HoeItem> SAPPHIRE_HOE = HOES.register("sapphire_hoe",
            () ->  new HoeItem(MyToolTiers.SAPPHIRE_TIER, new Item.Properties().attributes(HoeItem.createAttributes(
                    MyToolTiers.SAPPHIRE_TIER, 0, -3.0f
            ))));

    public static final DeferredItem<HoeItem> RUBY_HOE = HOES.register("ruby_hoe",
            () -> new HoeItem(MyToolTiers.RUBY_TIER, new Item.Properties().attributes(HoeItem.createAttributes(
                    MyToolTiers.RUBY_TIER, 0, -3.0f
            ))));

    public static final DeferredItem<HoeItem> CELESTIUM_HOE = HOES.register("celestium_hoe",
            () -> new HoeItem(MyToolTiers.CELESTIUM_TIER, new Item.Properties().attributes(HoeItem.createAttributes(
                    MyToolTiers.CELESTIUM_TIER, 0, -3.0f
            ))));

    //register to the event bus
    public static void register(){
        GroupItems.addToolRegister(HOES);
    }

}
