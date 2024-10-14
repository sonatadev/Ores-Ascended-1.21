package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.mojang.datafixers.types.templates.Hook;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = OresAscended.MODID)
public class MyDatagenHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        // Data generators may require some of these as constructor parameters.
        // See below for more details on each of these.
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //register the block provider
        generator.addProvider(
                event.includeClient(),
                new MyBlockStateProvider(output, existingFileHelper)
        );
        //item provider
        generator.addProvider(
                event.includeClient(),
                new MyItemModelProvider(output, existingFileHelper)
        );
        //language provider
        generator.addProvider(
                event.includeClient(),
                new MyLanguageProvider(output, existingFileHelper)
        );
        //loot table provider
        generator.addProvider(
                event.includeServer(),
                new LootTableProvider(output, Collections.emptySet(),
                        List.of(new LootTableProvider.SubProviderEntry(MyLootTableProvider::new, LootContextParamSets.BLOCK)),
                        lookupProvider));
        //recipe provider
        generator.addProvider(event.includeServer(), new MyRecipeProvider(output, lookupProvider));
        //block tag provider
        BlockTagsProvider blockTagsProvider = new MyBlockTagProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        //item tag provider
        generator.addProvider(event.includeServer(), new MyItemTagProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

    }
}
