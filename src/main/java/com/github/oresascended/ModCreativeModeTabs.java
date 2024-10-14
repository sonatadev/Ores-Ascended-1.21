package com.github.oresascended;

import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class ModCreativeModeTabs {
    private static final Logger LOGGER = Logger.getLogger(ModCreativeModeTabs.class.getName());

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OresAscended.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static final Supplier<CreativeModeTab> ORES_ASCENDED_TAB = CREATIVE_MODE_TAB.register("ores_ascended_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ItemInit.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.oresascended"))
                    .displayItems((parameters, output) -> {
                        ItemInit.ITEMS.getEntries().stream().map(DeferredHolder::get).forEach(item -> {
                           output.accept(item);
                        });
                    })
                    .build());

    // Uncomment and modify if additional creative tabs are needed

    public static final Supplier<CreativeModeTab> ORES_ASCENDED_EVOLVED_TAB = CREATIVE_MODE_TAB.register("ores_ascended_evolved_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(BlockInit.SAPPHIRE_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(OresAscended.MODID, "ores_ascended_tab"))
                    .title(Component.translatable("creativetab.oresascendedevolved"))
                    .displayItems((parameters, output) -> {
                        BlockInit.BLOCKS.getEntries().forEach(deferredBlock -> {
                            Block block = deferredBlock.get();
                            if (block != null) {
                                ItemStack itemStack = new ItemStack(block.asItem(), 1);
                                if (itemStack.isEmpty()) {
                                    LOGGER.warning("Block " + block + " has an invalid item stack");
                                } else if (itemStack.getCount() != 1) {
                                    LOGGER.warning("Block " + block + " has an invalid stack count: " + itemStack.getCount());
                                } else {
                                    output.accept(itemStack);
                                }
                            }
                        });

                        ItemInit.ITEMS.getEntries().forEach(deferredItem -> {
                            Item item = deferredItem.get();
                            if (item != null) {
                                ItemStack itemStack = new ItemStack(item, 1);
                                if (itemStack.isEmpty()) {
                                    LOGGER.warning("Item " + item + " has an invalid item stack");
                                } else if (itemStack.getCount() != 1) {
                                    LOGGER.warning("Item " + item + " has an invalid stack count: " + itemStack.getCount());
                                } else {
                                    output.accept(itemStack);
                                }
                            }
                        });
                    })
                    .build());

}