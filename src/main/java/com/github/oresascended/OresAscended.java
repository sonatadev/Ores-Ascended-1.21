package com.github.oresascended;

import com.github.oresascended.block.BlockInit;
import com.github.oresascended.block.OreBlockInit;
import com.github.oresascended.item.misc.AlloyInit;
import com.github.oresascended.item.misc.FuelInit;
import com.github.oresascended.item.misc.ItemInit;
import com.github.oresascended.item.misc.OreInit;
import com.github.oresascended.item.armors.BootsInit;
import com.github.oresascended.item.armors.ChestplateInit;
import com.github.oresascended.item.armors.HelmetInit;
import com.github.oresascended.item.armors.LeggingsInit;
import com.github.oresascended.item.blocks.BlockItemInit;
import com.github.oresascended.item.blocks.OreBlockItemInit;
import com.github.oresascended.item.tools.*;
import com.github.oresascended.util.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(OresAscended.MODID)
public class OresAscended {
    public static final String MODID = "oresascended";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OresAscended(IEventBus modEventBus, ModContainer modContainer) {
        //blocks registration
        BlockInit.BLOCKS.register(modEventBus);
        OreBlockInit.ORE_BLOCKS.register(modEventBus);

        GroupItems.initializeRegisters();
        //item registration
        for(DeferredRegister<? extends Item> armorRegister : GroupItems.armorRegisters){
            armorRegister.register(modEventBus);
        }
        //tool registration
        for(DeferredRegister<? extends Item> itemRegister : GroupItems.itemRegisters){
            itemRegister.register(modEventBus);
        }
        //armor registration
        for(DeferredRegister<? extends Item> toolRegister : GroupItems.toolRegisters){
            toolRegister.register(modEventBus);
        }

        //block entity registration
        GroupEntities.initializeRegisters();
        for(DeferredRegister<? extends BlockEntityType> blockEntityRegister : GroupEntities.entityRegisters){
            blockEntityRegister.register(modEventBus);
        }

        //menu registration
        GroupMenuTypes.initializeRegisters();
        for(DeferredRegister<MenuType<?>> menuTypeRegister : GroupMenuTypes.menuTypeRegisters){
            menuTypeRegister.register(modEventBus);
        }


        GroupItems.addAllItemRegisters();
        GroupTabs.initializeRegisters();
        //creative tabs registration
        for(DeferredRegister<CreativeModeTab> tabRegister : GroupTabs.tabRegisters){
            tabRegister.register(modEventBus);
        }
        //event bus registration
        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("Server Started");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }


}