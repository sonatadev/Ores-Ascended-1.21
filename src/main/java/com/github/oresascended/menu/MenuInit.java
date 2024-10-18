package com.github.oresascended.menu;

import com.github.oresascended.OresAscended;
import com.github.oresascended.block.tile.storage.ContainerBlock;
import com.github.oresascended.block.tile.storage.MyContainerEntity;
import com.github.oresascended.menu.screen.MyContainerScreen;
import com.github.oresascended.util.GroupMenuTypes;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuInit {
    private static final String MODID = OresAscended.MODID;

    // Register menu types
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, MODID);

    // Define the custom container menu type with additional checks
    public static final Supplier<MenuType<MyContainerMenu>> MY_CONTAINER_MENU_TYPE = MENU_TYPES.register(
            "my_container_menu",
            () -> new MenuType<>((id, playerInventory) -> {
                LocalPlayer player = (LocalPlayer) playerInventory.player;
                Level level = player.level();

                HitResult hitResult = player.pick(5.0D, 0.0F, false);
                if (hitResult instanceof BlockHitResult blockHitResult) {
                    BlockPos pos = blockHitResult.getBlockPos();

                    // Check if the block is of the correct type
                    if (!(level.getBlockState(pos).getBlock() instanceof ContainerBlock)) {
                        return null; // or handle appropriately
                    }

                    MyContainerEntity containerEntity = (MyContainerEntity) level.getBlockEntity(pos);
                    if (containerEntity == null) {
                        return null; // or handle this case appropriately
                    }

                    if (!level.hasChunkAt(pos)) {
                        return null; // or handle this case appropriately
                    }

                    return new MyContainerMenu(id, playerInventory, containerEntity);
                } else {
                    throw new IllegalStateException("Hit result is not a BlockHitResult for player " + player.getName().getString());
                }
            }, FeatureFlagSet.of())
    );

    // Method to register menu types
    public static void register() {
        GroupMenuTypes.addMenuTypeRegisters(MENU_TYPES);
    }
}
