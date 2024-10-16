package com.github.oresascended.item.armors;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LeggingsInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items LEGGINGS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<ArmorItem> SAPPHIRE_LEGGINGS = LEGGINGS.register("sapphire_leggings",
            () -> new ArmorItem(MyArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(27))
            ));

    public static final DeferredItem<ArmorItem> RUBY_LEGGINGS = LEGGINGS.register("ruby_leggings",
            () -> new ArmorItem(MyArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(38))
            ));

    public static final DeferredItem<ArmorItem> CELESTIUM_LEGGINGS = LEGGINGS.register("celestium_leggings",
            () -> new ArmorItem(MyArmorMaterials.CELESTIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(40))
            ));

    //register to the event bus
    public static void register(){
        GroupItems.addArmorRegister(LEGGINGS);
    }

}
