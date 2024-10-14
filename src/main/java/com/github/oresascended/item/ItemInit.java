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

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));
    //alloyed fuels
    public static final DeferredItem<Item> BRIGHTCOAL = ITEMS.register("brightcoal",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));

    public static final DeferredItem<Item> SHADOWFIRE_CORE = ITEMS.register("shadowfire_core",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));
    //alloyed ores
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.register("aquamarine",
            () -> new Item(new Item.Properties()
            ));

    public static final DeferredItem<Item> CELESTIUM = ITEMS.register("celestium",
            () -> new Item(new Item.Properties()
                    .fireResistant()
            ));

    public static final DeferredItem<Item> CRIMSONITE = ITEMS.register("crimsonite",
            () -> new Item(new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
            ));

    //tools
    //sapphire
    public static final DeferredItem<SwordItem> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () ->  new SwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(
                    Tiers.DIAMOND, 3, -2.4f
            ))));
    public static final DeferredItem<PickaxeItem> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () ->  new PickaxeItem(Tiers.DIAMOND, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    Tiers.DIAMOND, 1, -2.8f
            ))));
    public static final DeferredItem<AxeItem> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () ->  new AxeItem(Tiers.DIAMOND, new Item.Properties().attributes(AxeItem.createAttributes(
                    Tiers.DIAMOND, 6, -3.2f
            ))));
    public static final DeferredItem<ShovelItem> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () ->  new ShovelItem(Tiers.DIAMOND, new Item.Properties().attributes(ShovelItem.createAttributes(
                    Tiers.DIAMOND, 1.5f, -3.0f
            ))));
    public static final DeferredItem<HoeItem> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () ->  new HoeItem(Tiers.DIAMOND, new Item.Properties().attributes(HoeItem.createAttributes(
                    Tiers.DIAMOND, 5, 3
            ))));
    //celestium
    public static final DeferredItem<SwordItem> CELESTIUM_SWORD = ITEMS.register("celestium_sword",
            () -> new SwordItem(Tiers.DIAMOND, new Item.Properties().attributes(SwordItem.createAttributes(
                    Tiers.DIAMOND, 3, -2.4f
            ))));

    public static final DeferredItem<PickaxeItem> CELESTIUM_PICKAXE = ITEMS.register("celestium_pickaxe",
            () -> new PickaxeItem(Tiers.DIAMOND, new Item.Properties().attributes(PickaxeItem.createAttributes(
                    Tiers.DIAMOND, 1, -2.8f
            ))));

    public static final DeferredItem<AxeItem> CELESTIUM_AXE = ITEMS.register("celestium_axe",
            () -> new AxeItem(Tiers.DIAMOND, new Item.Properties().attributes(AxeItem.createAttributes(
                    Tiers.DIAMOND, 6, -3.2f
            ))));

    public static final DeferredItem<ShovelItem> CELESTIUM_SHOVEL = ITEMS.register("celestium_shovel",
            () -> new ShovelItem(Tiers.DIAMOND, new Item.Properties().attributes(ShovelItem.createAttributes(
                    Tiers.DIAMOND, 1.5f, -3.0f
            ))));

    public static final DeferredItem<HoeItem> CELESTIUM_HOE = ITEMS.register("celestium_hoe",
            () -> new HoeItem(Tiers.DIAMOND, new Item.Properties().attributes(HoeItem.createAttributes(
                    Tiers.DIAMOND, 5, 3
            ))));


    //armor stuff
    //sapphire
    public static final DeferredItem<ArmorItem> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(19))
            ));
    public static final DeferredItem<ArmorItem> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(19))
            ));
    public static final DeferredItem<ArmorItem> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(19))
            ));
    public static final DeferredItem<ArmorItem> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(19))
            ));
    //celestium
    public static final DeferredItem<ArmorItem> CELESTIUM_HELMET = ITEMS.register("celestium_helmet",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(19))
            ));
    public static final DeferredItem<ArmorItem> CELESTIUM_CHESTPLATE = ITEMS.register("celestium_chestplate",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(19))
            ));
    public static final DeferredItem<ArmorItem> CELESTIUM_LEGGINGS = ITEMS.register("celestium_leggings",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(19))
            ));
    public static final DeferredItem<ArmorItem> CELESTIUM_BOOTS = ITEMS.register("celestium_boots",
            () -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(19))
            ));



    
    //register to the event bus
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
