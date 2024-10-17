package com.github.oresascended.datagen;

import com.github.oresascended.block.BlockInit;
import com.github.oresascended.block.OreBlockInit;
import com.github.oresascended.item.misc.OreInit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
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
import java.util.stream.Stream;

public class MyLootTableProvider extends BlockLootSubProvider {
    protected MyLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        //dropSelf Blocks
        dropSelf(BlockInit.SAPPHIRE_BLOCK.get());
        dropSelf(BlockInit.RUBY_BLOCK.get());
        dropSelf(BlockInit.AETHERIUM_BLOCK.get());
        dropSelf(BlockInit.CONTAINER_BLOCK.get());

        //dropOre Blocks
        add(OreBlockInit.SAPPHIRE_ORE.get(),
                block -> createOreDrop(OreBlockInit.SAPPHIRE_ORE.get(), OreInit.SAPPHIRE.get()));
        add(OreBlockInit.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createMultipleOreDrops(OreBlockInit.DEEPSLATE_SAPPHIRE_ORE.get(), OreInit.SAPPHIRE.get(), 2, 5));
        add(OreBlockInit.RUBY_ORE.get(),
                block -> createOreDrop(OreBlockInit.RUBY_ORE.get(), OreInit.RUBY.get()));
        add(OreBlockInit.AETHERIUM_ORE.get(),
                block -> createOreDrop(OreBlockInit.AETHERIUM_ORE.get(), OreInit.AETHERIUM.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Stream.concat(
                BlockInit.BLOCKS.getEntries().stream().map(Holder::value),
                OreBlockInit.ORE_BLOCKS.getEntries().stream().map(Holder::value)
        )::iterator;
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
}
