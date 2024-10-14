package com.github.oresascended.item;

import com.github.oresascended.OresAscended;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
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
//    public static final DeferredItem<Item> AQUAMARINE = ITEMS.register("aquamarine",
//            () -> new Item(new Item.Properties()
//            ));
//    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
//            () -> new Item(new Item.Properties()
//                    .fireResistant()
//            ));
//    public static final DeferredItem<Item> OBSIDIAN_RUBY_ALLOY = ITEMS.register("obsidian_ruby_alloy",
//            () -> new Item(new Item.Properties()
//                    .fireResistant()
//                    .rarity(Rarity.EPIC)
//            ));

    //tools
    public static final DeferredItem<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () ->  new SwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(
                    Tiers.DIAMOND, 5, 3
            )))
            );
//    public static final DeferredItem<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
//            () ->  new PickaxeItem(Tiers.DIAMOND, new Item.Properties().attributes(PickaxeItem.createAttributes(
//                    Tiers.DIAMOND, 5, 3
//            )))
//    );
    public static final DeferredItem<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () ->  new AxeItem(Tiers.DIAMOND, new Item.Properties().attributes(AxeItem.createAttributes(
                    Tiers.DIAMOND, 5, 3
            )))
    );
//    public static final DeferredItem<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
//            () ->  new ShovelItem(Tiers.DIAMOND, new Item.Properties().attributes(ShovelItem.createAttributes(
//                    Tiers.DIAMOND, 5, 3
//            )))
//    );
    public static final DeferredItem<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () ->  new HoeItem(Tiers.DIAMOND, new Item.Properties().attributes(HoeItem.createAttributes(
                    Tiers.DIAMOND, 5, 3
            )))
    );

    //armor stuff
    public static final DeferredItem<ArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(19))
            ));




    
    //register to the event bus
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
