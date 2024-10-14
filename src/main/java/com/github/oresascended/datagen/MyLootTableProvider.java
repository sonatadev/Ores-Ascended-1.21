package com.github.oresascended.datagen;

import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.ItemInit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class MyLootTableProvider extends BlockLootSubProvider {
    protected MyLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        //dropSelf Blocks
        dropSelf(BlockInit.SAPPHIRE_BLOCK.get());
        dropSelf(BlockInit.RUBY_BLOCK.get());

        //dropOre Blocks
        add(BlockInit.SAPPHIRE_ORE.get(),
                block -> createOreDrop(BlockInit.SAPPHIRE_ORE.get(), ItemInit.SAPPHIRE.get()));
        add(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createMultipleOreDrops(BlockInit.DEEPSLATE_SAPPHIRE_ORE.get(), ItemInit.SAPPHIRE.get(), 2, 5));
        add(BlockInit.RUBY_ORE.get(),
                block -> createOreDrop(BlockInit.RUBY_ORE.get(), ItemInit.RUBY.get()));
        add(BlockInit.DEEPSLATE_RUBY_ORE.get(),
                block -> createMultipleOreDrops(BlockInit.DEEPSLATE_RUBY_ORE.get(), ItemInit.RUBY.get(), 2, 5));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
}
