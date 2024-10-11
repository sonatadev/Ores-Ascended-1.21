package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MyItemModelProvider extends ItemModelProvider {
    public MyItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OresAscended.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //simple item json generation
        for(DeferredHolder<Item, ? extends Item> deferredItem : ItemInit.ITEMS.getEntries()){
                if(deferredItem.get() instanceof BlockItem){
                    continue;
                }
                basicItem(deferredItem.get());
        }
    }
}
