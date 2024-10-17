package com.github.oresascended.block;

import com.github.oresascended.OresAscended;
import com.github.oresascended.item.blocks.OreBlockItemInit;
import com.github.oresascended.item.misc.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class OreBlockInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister.Blocks ORE_BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .explosionResistance(6f)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .explosionResistance(7f)
                    .strength(7f)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.NETHER_ORE)
                    .explosionResistance(7f)
                    .strength(7f)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> AETHERIUM_ORE = registerBlock("aetherium_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.ANCIENT_DEBRIS)
                    .explosionResistance(8f)
                    .strength(8f)
                    .requiresCorrectToolForDrops()
            ));

    //register blocks
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = ORE_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //register block items
    private static final <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        OreBlockItemInit.ORE_BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
