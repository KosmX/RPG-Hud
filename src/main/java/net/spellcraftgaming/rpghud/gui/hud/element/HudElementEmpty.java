package net.spellcraftgaming.rpghud.gui.hud.element;

import net.minecraft.client.gui.Gui;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HudElementEmpty extends HudElement {

    public HudElementEmpty() {
        super(HudElementType.VOID, 0, 0, 0, 0, false);
    }

    @Override
    public void drawElement(Gui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
    }

}
