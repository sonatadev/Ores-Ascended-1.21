package com.github.oresascended.menu.screen;

import com.github.oresascended.menu.MyContainerMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.ResourceLocation;

public class MyContainerScreen extends AbstractContainerScreen<MyContainerMenu> {
    // Define the texture location for the chest inventory
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("minecraft", "textures/gui/container/shulker_box.png");

    public MyContainerScreen(MyContainerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176; // Width of the screen
        this.imageHeight = 166; // Height of the screen
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY); // Render background
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick); // Render the items
        this.renderLabels(pGuiGraphics, pMouseX, pMouseY); // Render labels
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        // Render the texture using integer positions
        int adjustedLeftPos = Math.round(this.leftPos);
        int adjustedTopPos = Math.round(this.topPos);
        pGuiGraphics.blit(TEXTURE, adjustedLeftPos, adjustedTopPos, 0, 0, this.imageWidth, this.imageHeight);
    }


}
