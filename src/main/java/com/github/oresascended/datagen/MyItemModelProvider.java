package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class MyItemModelProvider extends ItemModelProvider {
    public MyItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OresAscended.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Simple item JSON generation
        for (DeferredHolder<Item, ? extends Item> deferredItem : ItemInit.ITEMS.getEntries()) {
            if (deferredItem.get() instanceof BlockItem || deferredItem.get() instanceof TieredItem) {
                continue;
            }
            basicItem(deferredItem.get());
        }
        //tools
        //sapphire
        handheldItem(ItemInit.SAPPHIRE_SWORD);
        handheldItem(ItemInit.SAPPHIRE_PICKAXE);
        handheldItem(ItemInit.SAPPHIRE_AXE);
        handheldItem(ItemInit.SAPPHIRE_SHOVEL);
        handheldItem(ItemInit.SAPPHIRE_HOE);
        //ruby
        handheldItem(ItemInit.RUBY_SWORD);
        handheldItem(ItemInit.RUBY_PICKAXE);
        handheldItem(ItemInit.RUBY_AXE);
        handheldItem(ItemInit.RUBY_SHOVEL);
        handheldItem(ItemInit.RUBY_HOE);
        //celestium
        handheldItem(ItemInit.CELESTIUM_SWORD);
        handheldItem(ItemInit.CELESTIUM_PICKAXE);
        handheldItem(ItemInit.CELESTIUM_AXE);
        handheldItem(ItemInit.CELESTIUM_SHOVEL);
        handheldItem(ItemInit.CELESTIUM_HOE);

    }


    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(OresAscended.MODID,"item/" + item.getId().getPath()));
    }


}
