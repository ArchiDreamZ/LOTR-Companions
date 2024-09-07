package net.richardsprojects.lotrcompanions.utils;

import lotr.common.init.LOTRItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.richardsprojects.lotrcompanions.npcs.HiredBreeGuard;
import net.richardsprojects.lotrcompanions.npcs.HiredGondorSoldier;

public class Constants {

    private static final ItemStack BREE_GUARD_HEAD = new ItemStack(Items.IRON_HELMET).setHoverName(new StringTextComponent("Base Helmet").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack BREE_GUARD_CHEST = new ItemStack(Items.LEATHER_CHESTPLATE).setHoverName(new StringTextComponent("Base Chestplate").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack BREE_GUARD_LEGS = new ItemStack(Items.CHAINMAIL_LEGGINGS).setHoverName(new StringTextComponent("Base Leggings").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack BREE_GUARD_FEET = new ItemStack(Items.CHAINMAIL_BOOTS).setHoverName(new StringTextComponent("Base Boots").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack BREE_GUARD_MAINHAND  = new ItemStack(LOTRItems.IRON_SPEAR.get()).setHoverName(new StringTextComponent("Base Weapon").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack BREE_GUARD_OFFHAND = new ItemStack(Items.SHIELD).setHoverName(new StringTextComponent("Base Shield").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));

    private static final ItemStack GONDOR_SOLDIER_HEAD = new ItemStack(LOTRItems.GONDOR_HELMET.get()).setHoverName(new StringTextComponent("Base Helmet").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack GONDOR_SOLDIER_CHEST = new ItemStack(LOTRItems.GONDOR_CHESTPLATE.get()).setHoverName(new StringTextComponent("Base Chestplate").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack GONDOR_SOLDIER_LEGS = new ItemStack(LOTRItems.GONDOR_LEGGINGS.get()).setHoverName(new StringTextComponent("Base Leggings").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack GONDOR_SOLDIER_FEET = new ItemStack(LOTRItems.GONDOR_BOOTS.get()).setHoverName(new StringTextComponent("Base Boots").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack GONDOR_SOLDIER_MAINHAND  = new ItemStack(LOTRItems.GONDOR_SWORD.get()).setHoverName(new StringTextComponent("Base Weapon").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));
    private static final ItemStack GONDOR_SOLDIER_OFFHAND = new ItemStack(LOTRItems.GONDOR_SHIELD.get()).setHoverName(new StringTextComponent("Base Shield").withStyle(TextFormatting.BOLD).withStyle(TextFormatting.GOLD));

    public static ItemStack[] getBaseGear(Entity entity) {
        ItemStack[] baseGear = new ItemStack[6];

        if (entity instanceof HiredGondorSoldier) {
            baseGear[0] = GONDOR_SOLDIER_HEAD;
            baseGear[1] = GONDOR_SOLDIER_CHEST;
            baseGear[2] = GONDOR_SOLDIER_LEGS;
            baseGear[3] = GONDOR_SOLDIER_FEET;
            baseGear[4] = GONDOR_SOLDIER_MAINHAND;
            baseGear[5] = GONDOR_SOLDIER_OFFHAND;
        } else if (entity instanceof HiredBreeGuard) {
            baseGear[0] = BREE_GUARD_HEAD;
            baseGear[1] = BREE_GUARD_CHEST;
            baseGear[2] = BREE_GUARD_LEGS;
            baseGear[3] = BREE_GUARD_FEET;
            baseGear[4] = BREE_GUARD_MAINHAND;
            baseGear[5] = BREE_GUARD_OFFHAND;
        } else {
            baseGear[0] = ItemStack.EMPTY;
            baseGear[1] = ItemStack.EMPTY;
            baseGear[2] = ItemStack.EMPTY;
            baseGear[3] = ItemStack.EMPTY;
            baseGear[4] = ItemStack.EMPTY;
            baseGear[5] = ItemStack.EMPTY;
        }

        return baseGear;
    }

}