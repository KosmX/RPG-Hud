package net.spellcraftgaming.rpghud.gui.hud;

import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.AIR;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.ARMOR;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.CLOCK;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.COMPASS;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.CROSSHAIR;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.DETAILS;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.ENTITY_INSPECT;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.EXPERIENCE;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.FOOD;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.HEALTH;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.HEALTH_MOUNT;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.HOTBAR;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.JUMP_BAR;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.LEVEL;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.RECORD_OVERLAY;
import static net.spellcraftgaming.rpghud.gui.hud.element.HudElementType.WIDGET;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElement;
import net.spellcraftgaming.rpghud.gui.hud.element.HudElementType;

public abstract class Hud {

    /** Hud key for registering */
    private final String hudKey;

    /** Hud name for display in settings */
    private final String hudName;

    protected Map<HudElementType, HudElement> elements = new HashMap<>();

    /** Minecraft instance */
    protected Minecraft mc;

    public int chatOffset = 0;

    public Hud(Minecraft mc, String hudKey, String hudName) {
        this.mc = mc;
        this.hudKey = hudKey;
        this.hudName = hudName;
        this.setElements();
    }

    /**
     * Function to register all elements to this HUD.<br>
     * Has to be run in order for this HUD to function properly
     */
    public void setElements() {
        this.elements.put(HOTBAR, this.setElementHotbar());
        this.elements.put(CROSSHAIR, this.setElementCrosshair());
        this.elements.put(HEALTH, this.setElementHealth());
        this.elements.put(ARMOR, this.setElementArmor());
        this.elements.put(FOOD, this.setElementFood());
        this.elements.put(HEALTH_MOUNT, this.setElementHealthMount());
        this.elements.put(AIR, this.setElementAir());
        this.elements.put(JUMP_BAR, this.setElementJumpBar());
        this.elements.put(EXPERIENCE, this.setElementExperience());
        this.elements.put(LEVEL, this.setElementLevel());
        this.elements.put(CLOCK, this.setElementClock());
        this.elements.put(DETAILS, this.setElementDetails());
        this.elements.put(WIDGET, this.setElementWidget());
        this.elements.put(RECORD_OVERLAY, this.setElementRecordOverlay());
        this.elements.put(COMPASS, this.setElementCompass());
        this.elements.put(ENTITY_INSPECT, this.setElementEntityInspect());

    }

    /** get the key (String) of this HUD */
    public String getHudKey() {
        return this.hudKey;
    }

    /** get the name of this HUD */
    public String getHudName() {
        return this.hudName;
    }

    /** Function which returns a new element which is the crosshair element */
    protected abstract HudElement setElementCrosshair();

    /** Function which returns a new element which is the hotbar element */
    protected abstract HudElement setElementHotbar();

    /** Function which returns a new element which is the health element */
    protected abstract HudElement setElementHealth();

    /** Function which returns a new element which is the food element */
    protected abstract HudElement setElementFood();

    /** Function which returns a new element which is the armor element */
    protected abstract HudElement setElementArmor();

    /** Function which returns a new element which is the air element */
    protected abstract HudElement setElementAir();

    /** Function which returns a new element which is the experience element */
    protected abstract HudElement setElementExperience();

    /**
     * Function which returns a new element which is the experience level element
     */
    protected abstract HudElement setElementLevel();

    /** Function which returns a new element which is the jump bar element */
    protected abstract HudElement setElementJumpBar();

    /**
     * Function which returns a new element which is the mount health element
     */
    protected abstract HudElement setElementHealthMount();

    /** Function which returns a new element which is the clock element */
    protected abstract HudElement setElementClock();

    /** Function which returns a new element which is the details element */
    protected abstract HudElement setElementDetails();

    /** Function which returns a new element which is the widget element */
    protected abstract HudElement setElementWidget();

    /** Function which returns a new element which is the widget element */
    protected abstract HudElement setElementRecordOverlay();

    /** Function which returns a new element which is the compass element */
    protected abstract HudElement setElementCompass();

    /** Function which returns a new element which is the item pickup element */
    protected abstract HudElement setElementEntityInspect();

    /**
     * Draws the an element of the HudElementType type on the screen
     * 
     * @param type         The type of the Element
     * @param gui          The gui to draw on
     * @param zLevel       The zLevel to draw at
     * @param partialTicks The partialTicks for animations
     */
    public void drawElement(HudElementType type, AbstractGui gui, float zLevel, float partialTicks, int scaledWidth, int scaledHeight) {
        this.elements.get(type).draw(gui, zLevel, partialTicks, scaledWidth, scaledHeight);
    }

    /**
     * Checks whether the element of the specified type should be rendered
     * 
     * @param type The HudElementType to get checked
     * @return true if it should be rendered, false if not
     */
    public boolean checkElementConditions(HudElementType type) {
        return this.elements.get(type).checkConditions();
    }
}
