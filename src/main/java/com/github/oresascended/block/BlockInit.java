package com.github.oresascended.block;

import com.github.oresascended.OresAscended;
import com.github.oresascended.item.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {

    private static final String MODID = OresAscended.MODID;
    //blocks container
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Creates a new Block with the id "oresascended:sapphire_block", combining the namespace and path
    public static final DeferredBlock<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .explosionResistance(6f)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .explosionResistance(8f)
                    .strength(8f)
                    .requiresCorrectToolForDrops()
            ));
//    public static final DeferredBlock<Block> OBSIDIAN_RUBY_BLOCK = registerBlock("obsidian_ruby_block",
//            () -> new Block(BlockBehaviour.Properties.of()
//                    .sound(SoundType.LARGE_AMETHYST_BUD)
//                    .explosionResistance(12f)
//                    .strength(12f)
//                    .requiresCorrectToolForDrops()
//            ));
    
    //register blocks
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //register block items
    private static final <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    //registr to the event bus
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
