package com.github.oresascended.item.armors;

import com.github.oresascended.OresAscended;
import com.github.oresascended.util.GroupItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChestplateInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Items CHESTPLATES = DeferredRegister.createItems(MODID);

    public static final DeferredItem<ArmorItem> SAPPHIRE_CHESTPLATE = CHESTPLATES.register("sapphire_chestplate",
            () -> new ArmorItem(MyArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(27))
            ));

    public static final DeferredItem<ArmorItem> RUBY_CHESTPLATE = CHESTPLATES.register("ruby_chestplate",
            () -> new ArmorItem(MyArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(38))
            ));

    public static final DeferredItem<ArmorItem> CELESTIUM_CHESTPLATE = CHESTPLATES.register("celestium_chestplate",
            () -> new ArmorItem(MyArmorMaterials.CELESTIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(40))
            ));

    //register to the event bus
    public static void register(){
        GroupItems.addArmorRegister(CHESTPLATES);
    }

}
