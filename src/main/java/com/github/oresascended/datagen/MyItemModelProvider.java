package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.item.ItemInit;
import net.minecraft.data.PackOutput;
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
        // Block items generally use their corresponding block models as parent.
//        withExistingParent(MyItemsClass.EXAMPLE_BLOCK_ITEM.get(), modLoc("block/example_block"));
        // Items generally use a simple parent and one texture. The most common parents are item/generated and item/handheld.
        // In this example, the item texture would be located at assets/examplemod/textures/item/example_item.png.
        // If you want a more complex model, you can use getBuilder() and then work from that, like you would with block models.
//        withExistingParent(MyItemsClass.EXAMPLE_ITEM.get(), mcLoc("item/generated")).texture("layer0", "item/example_item");
        // The above line is so common that there is a shortcut for it. Note that the item registry name and the
        // texture path, relative to textures/item, must match.
//        basicItem(MyItemsClass.EXAMPLE_ITEM.get());

        //simple item json generation
        for(DeferredHolder<Item, ? extends Item> deferredItem : ItemInit.ITEMS.getEntries()){
            basicItem(deferredItem.get());
        }
    }
}
