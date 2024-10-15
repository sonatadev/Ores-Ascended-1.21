package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.item.ItemInit;
import com.github.oresascended.item.TagsInit;
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
        tag(TagsInit.Items.ALLOYED_ITEMS)
                //fuel items
                .add(ItemInit.BRIGHTCOAL.get())
                .add(ItemInit.SHADOWFIRE_CORE.get())
                //alloyed ores
                .add(ItemInit.AQUAMARINE.get())
                .add(ItemInit.CELESTIUM.get());
        tag(ItemTags.SWORDS)
                .add(ItemInit.SAPPHIRE_SWORD.get())
                .add(ItemInit.RUBY_SWORD.get())
                .add(ItemInit.CELESTIUM_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ItemInit.SAPPHIRE_PICKAXE.get())
                .add(ItemInit.RUBY_PICKAXE.get())
                .add(ItemInit.CELESTIUM_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ItemInit.SAPPHIRE_AXE.get())
                .add(ItemInit.RUBY_AXE.get())
                .add(ItemInit.CELESTIUM_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ItemInit.SAPPHIRE_SHOVEL.get())
                .add(ItemInit.RUBY_SHOVEL.get())
                .add(ItemInit.CELESTIUM_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ItemInit.SAPPHIRE_HOE.get())
                .add(ItemInit.RUBY_HOE.get())
                .add(ItemInit.CELESTIUM_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ItemInit.SAPPHIRE_BOOTS.get())
                .add(ItemInit.SAPPHIRE_LEGGINGS.get())
                .add(ItemInit.SAPPHIRE_CHESTPLATE.get())
                .add(ItemInit.SAPPHIRE_HELMET.get())
                .add(ItemInit.RUBY_BOOTS.get())
                .add(ItemInit.RUBY_LEGGINGS.get())
                .add(ItemInit.RUBY_CHESTPLATE.get())
                .add(ItemInit.RUBY_HELMET.get())
                .add(ItemInit.CELESTIUM_BOOTS.get())
                .add(ItemInit.CELESTIUM_LEGGINGS.get())
                .add(ItemInit.CELESTIUM_CHESTPLATE.get())
                .add(ItemInit.CELESTIUM_HELMET.get());

    }
}
