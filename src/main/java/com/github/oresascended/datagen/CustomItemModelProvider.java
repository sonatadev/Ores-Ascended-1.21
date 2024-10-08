package com.github.oresascended.datagen;

import com.github.oresascended.item.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class CustomItemModelProvider extends ItemModelProvider {

    public CustomItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "ores_ascended", existingFileHelper);
    }

   
}