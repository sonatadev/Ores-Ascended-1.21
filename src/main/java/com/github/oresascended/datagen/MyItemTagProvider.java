package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.item.misc.AlloyInit;
import com.github.oresascended.tags.TagsInit;
import com.github.oresascended.item.armors.BootsInit;
import com.github.oresascended.item.armors.ChestplateInit;
import com.github.oresascended.item.armors.HelmetInit;
import com.github.oresascended.item.armors.LeggingsInit;
import com.github.oresascended.item.tools.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MyItemTagProvider extends ItemTagsProvider {
    public MyItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, OresAscended.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        AlloyInit.ALLOYS.getEntries().forEach(deferredAlloy -> {
            tag(TagsInit.Items.ALLOYED_ITEMS)
                    .add(deferredAlloy.get());
        });

        SwordInit.SWORDS.getEntries().forEach(deferredSword -> {
            tag(ItemTags.SWORDS)
                    .add(deferredSword.get());
        });

        PickaxeInit.PICKAXES.getEntries().forEach(deferredPickaxe -> {
            tag(ItemTags.PICKAXES)
                    .add(deferredPickaxe.get());
        });

        AxeInit.AXES.getEntries().forEach(deferredAxe -> {
            tag(ItemTags.AXES)
                    .add(deferredAxe.get());
        });

        ShovelInit.SHOVELS.getEntries().forEach(deferredShovel -> {
            tag(ItemTags.SHOVELS)
                    .add(deferredShovel.get());
        });

        HoeInit.HOES.getEntries().forEach(deferredHoe -> {
            tag(ItemTags.HOES)
                    .add(deferredHoe.get());
        });

        HelmetInit.HELMETS.getEntries().forEach(deferredHelmet -> {
            tag(ItemTags.TRIMMABLE_ARMOR)
                    .add(deferredHelmet.get());
        });

        ChestplateInit.CHESTPLATES.getEntries().forEach(deferredChestplate -> {
            tag(ItemTags.TRIMMABLE_ARMOR)
                    .add(deferredChestplate.get());
        });

        LeggingsInit.LEGGINGS.getEntries().forEach(deferredLeggings -> {
            tag(ItemTags.TRIMMABLE_ARMOR)
                    .add(deferredLeggings.get());
        });

        BootsInit.BOOTS.getEntries().forEach(deferredBoots -> {
            tag(ItemTags.TRIMMABLE_ARMOR)
                    .add(deferredBoots.get());
        });

    }
}
