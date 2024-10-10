    package com.github.oresascended.datagen;

    import com.github.oresascended.ModCreativeModeTabs;
    import com.github.oresascended.OresAscended;
    import com.github.oresascended.block.BlockInit;
    import com.github.oresascended.item.ItemInit;
    import net.minecraft.data.PackOutput;
    import net.minecraft.world.item.CreativeModeTab;
    import net.minecraft.world.item.Item;
    import net.minecraft.world.level.block.Block;
    import net.neoforged.neoforge.common.data.ExistingFileHelper;
    import net.neoforged.neoforge.common.data.LanguageProvider;
    import net.neoforged.neoforge.registries.DeferredHolder;

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

        @Override
        protected void addTranslations() {
            // Adds a block translation.
            for(DeferredHolder<Block, ? extends Block> deferredBlock : BlockInit.BLOCKS.getEntries()){
                String name = formatName(deferredBlock.getId().getPath());
                //add(deferredBlock.get(), name);
                addBlock(deferredBlock, name);
            }

            // Adds an item translation.
            for(DeferredHolder<Item, ? extends Item> deferredItem : ItemInit.ITEMS.getEntries()){
                String name = formatName(deferredItem.getId().getPath());
                //add(deferredItem.get(), name);
                addItem(deferredItem, name);
            }

            //adds creative mode tabs translation
            for(DeferredHolder<CreativeModeTab, ? extends CreativeModeTab> deferredTab : ModCreativeModeTabs.CREATIVE_MODE_TAB.getEntries()){
                String name = formatName(deferredTab.getId().getPath());

            }
            
            

            // Adds an item stack translation. This is mainly for items that have NBT-specific names.
        //    add(MyItems.EXAMPLE_ITEM_STACK.get(), "Example Item");
    //        addItemStack(MyItems.EXAMPLE_ITEM_STACK, "Example Item");
    //
    //
    //
    //        // Adds an entity type translation.
    //        add(MyEntityTypes.EXAMPLE_ENTITY_TYPE.get(), "Example Entity");
    //        addEntityType(MyEntityTypes.EXAMPLE_ENTITY_TYPE, "Example Entity");
    //        // Adds an enchantment translation.
    //        add(MyEnchantments.EXAMPLE_ENCHANTMENT.get(), "Example Enchantment");
    //        addEnchantment(MyEnchantments.EXAMPLE_ENCHANTMENT, "Example Enchantment");
    //        // Adds a mob effect translation.
    //        add(MyMobEffects.EXAMPLE_MOB_EFFECT.get(), "Example Effect");
    //        addEffect(MyMobEffects.EXAMPLE_MOB_EFFECT, "Example Effect");
        }
    }