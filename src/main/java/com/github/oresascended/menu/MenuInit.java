package com.github.oresascended.menu;

import com.github.oresascended.OresAscended;
import com.github.oresascended.menu.screen.MyContainerScreen;
import com.github.oresascended.util.GroupMenuTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuInit {
    private static final String MODID = OresAscended.MODID;

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, MODID);

    public static final Supplier<MenuType<MyContainerMenu>> MY_CONTAINER_MENU_TYPE = MENU_TYPES.register(
            "my_container_menu",
            () -> new MenuType<>((id, playerInventory) -> new MyContainerMenu(id, playerInventory, null), FeatureFlagSet.of())
    );



    public static void register() {
        GroupMenuTypes.addMenuTypeRegisters(MENU_TYPES);
    }


}
