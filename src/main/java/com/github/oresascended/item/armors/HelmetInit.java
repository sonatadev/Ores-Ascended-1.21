package com.github.oresascended.item.armors;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HelmetInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items HELMETS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<ArmorItem> SAPPHIRE_HELMET = HELMETS.register("sapphire_helmet",
            () -> new ArmorItem(MyArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(27))
            ));

    public static final DeferredItem<ArmorItem> RUBY_HELMET = HELMETS.register("ruby_helmet",
            () -> new ArmorItem(MyArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(38))
            ));

    public static final DeferredItem<ArmorItem> CELESTIUM_HELMET = HELMETS.register("celestium_helmet",
            () -> new ArmorItem(MyArmorMaterials.CELESTIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(40))
            ));

    //register to the event bus
    public static void register(){
        GroupItems.addArmorRegister(HELMETS);
    }

}
