package com.github.oresascended.datagen;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.BlockInit;
import com.github.oresascended.item.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class MyItemModelProvider extends ItemModelProvider {
    public MyItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OresAscended.MODID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    @Override
    protected void registerModels() {
        // Simple item JSON generation
        for (DeferredHolder<Item, ? extends Item> deferredItem : ItemInit.ITEMS.getEntries()) {
            if (deferredItem.get() instanceof BlockItem || deferredItem.get() instanceof TieredItem) {
                continue;
            }
            basicItem(deferredItem.get());
        }
        //tools
        //sapphire
        handheldItem(ItemInit.SAPPHIRE_SWORD);
        handheldItem(ItemInit.SAPPHIRE_PICKAXE);
        handheldItem(ItemInit.SAPPHIRE_AXE);
        handheldItem(ItemInit.SAPPHIRE_SHOVEL);
        handheldItem(ItemInit.SAPPHIRE_HOE);
        //ruby
        handheldItem(ItemInit.RUBY_SWORD);
        handheldItem(ItemInit.RUBY_PICKAXE);
        handheldItem(ItemInit.RUBY_AXE);
        handheldItem(ItemInit.RUBY_SHOVEL);
        handheldItem(ItemInit.RUBY_HOE);
        //aetherium

        //aquamarine

        //celestium
        handheldItem(ItemInit.CELESTIUM_SWORD);
        handheldItem(ItemInit.CELESTIUM_PICKAXE);
        handheldItem(ItemInit.CELESTIUM_AXE);
        handheldItem(ItemInit.CELESTIUM_SHOVEL);
        handheldItem(ItemInit.CELESTIUM_HOE);

        //stellarium

        //armor trims
        //sapphire
        trimmedArmorItem(ItemInit.SAPPHIRE_BOOTS);
        trimmedArmorItem(ItemInit.SAPPHIRE_LEGGINGS);
        trimmedArmorItem(ItemInit.SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(ItemInit.SAPPHIRE_HELMET);
        //ruby
        trimmedArmorItem(ItemInit.RUBY_BOOTS);
        trimmedArmorItem(ItemInit.RUBY_LEGGINGS);
        trimmedArmorItem(ItemInit.RUBY_CHESTPLATE);
        trimmedArmorItem(ItemInit.RUBY_HELMET);
        //celestium
        trimmedArmorItem(ItemInit.CELESTIUM_BOOTS);
        trimmedArmorItem(ItemInit.CELESTIUM_LEGGINGS);
        trimmedArmorItem(ItemInit.CELESTIUM_CHESTPLATE);
        trimmedArmorItem(ItemInit.CELESTIUM_HELMET);


    }


    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(OresAscended.MODID,"item/" + item.getId().getPath()));
    }

    //i have no idea how this works tbh
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = OresAscended.MODID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }

}
