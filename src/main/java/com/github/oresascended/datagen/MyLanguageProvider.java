package com.github.oresascended.datagen;

import com.github.oresascended.util.GroupEntities;
import com.github.oresascended.util.GroupItems;
import com.github.oresascended.util.ModCreativeModeTabs;
import com.github.oresascended.OresAscended;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MyLanguageProvider extends LanguageProvider {
    public MyLanguageProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(
                // Provided by the GatherDataEvent.
                output,
                // Your mod id.
                OresAscended.MODID,
                // The locale to use. You may use multiple language providers for different locales.
                "en_us"
        );
    }

    @Override
    protected void addTranslations() {
        for (DeferredRegister<? extends Item> itemRegister : GroupItems.allItems) {
            itemRegister.getEntries().forEach(deferredItem -> {
                String name = formatName(deferredItem.getId().getPath());
                addItem(deferredItem, name);
            });
        }

        ModCreativeModeTabs.CREATIVE_MODE_TABS.getEntries().forEach(deferredTab -> {
            String name = formatName(deferredTab.getId().getPath());
            addCreativeModeTab(deferredTab, name);
        });

        add("oresascended.storage_container", "Storage Container"); //
    }

    public void addCreativeModeTab(Object key, String name) {
        CreativeModeTab tab;
        if (key instanceof Supplier) {
            tab = ((Supplier<? extends CreativeModeTab>) key).get();
        } else if (key instanceof CreativeModeTab) {
            tab = (CreativeModeTab) key;
        } else {
            throw new IllegalArgumentException("Invalid key type: " + key.getClass().getName());
        }
        add(tab.getDisplayName().getString(), name);
    }

    private String formatName(String input) {
        String[] parts = input.split("_");
        StringBuilder name = new StringBuilder();

        for (String part : parts) {
            if (name.length() > 0) {
                name.append(" ");
            }
            name.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }

        return name.toString();
    }

    // Other methods for item stack translations, entity types, enchantments, etc. can go here.
}
