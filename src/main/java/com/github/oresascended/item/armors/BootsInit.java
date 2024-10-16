package com.github.oresascended.item.armors;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BootsInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items BOOTS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<ArmorItem> SAPPHIRE_BOOTS = BOOTS.register("sapphire_boots",
            () -> new ArmorItem(MyArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(27))
            ));

    public static final DeferredItem<ArmorItem> RUBY_BOOTS = BOOTS.register("ruby_boots",
            () -> new ArmorItem(MyArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(38))
            ));

    public static final DeferredItem<ArmorItem> CELESTIUM_BOOTS = BOOTS.register("celestium_boots",
            () -> new ArmorItem(MyArmorMaterials.CELESTIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(40))
            ));

    //register to the event bus
    public static void register(){
        GroupItems.addArmorRegister(BOOTS);
    }

}
