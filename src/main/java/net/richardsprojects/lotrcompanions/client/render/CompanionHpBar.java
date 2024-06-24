package net.richardsprojects.lotrcompanions.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.richardsprojects.lotrcompanions.LOTRCompanions;
import net.richardsprojects.lotrcompanions.client.ColorHelper;

public class CompanionHpBar {

    private static final float HEALTHBAR_OPACITY = 80 / 100f;

    private static final float BACKGROUND_RED = 0 / 255f;
    private static final float BACKGROUND_GREEN = 0 / 255f;
    private static final float BACKGROUND_BLUE = 0 / 255f;

    private static final int TEXT_POS_X = 0;
    private static final int TEXT_POS_Y = 0;

    private static final int HB_POS_X_OFFSET = 0;
    private static final int HB_POS_Y_OFFSET = 0;

    private static final int HB_POS_X = -50;
    private static final int HB_POS_Y = 20;

    private static final int HB_WIDTH = 100;
    private static final int HB_HEIGHT = 9;

    private static final float HB_GREEN_R = 144 / 255.0F;
    private static final float HB_GREEN_G = 238 / 255.0F;
    private static final float HB_GREEN_B = 144 / 255.0F;



    public static void draw(LivingEntity entity, float textScale, MatrixStack matrixStackIn, FontRenderer font) {
        float vit = entity.getMaxHealth(), hp = entity.getHealth();
        float hpWidth = ((float) -font.width((int) hp + "/" + (int) vit) / 2);

        RenderSystem.enableDepthTest();
        RenderSystem.defaultBlendFunc();
        matrixStackIn.pushPose();

        // render background
        matrixStackIn.translate(HB_POS_X_OFFSET, HB_POS_Y_OFFSET, 0.0D);
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        ResourceLocation bar = new ResourceLocation(LOTRCompanions.MOD_ID, "textures/gui/healthbar.png");
        BarRendererHelper.bind(bar);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderSystem.color4f(BACKGROUND_RED, BACKGROUND_GREEN, BACKGROUND_BLUE, HEALTHBAR_OPACITY);
        BarRendererHelper.blit(matrixStackIn, HB_POS_X, HB_POS_Y, 0, 19, HB_WIDTH, HB_HEIGHT);

        // render healthbar
        matrixStackIn.translate(HB_POS_X_OFFSET, HB_POS_Y_OFFSET, 0.0D);
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        BarRendererHelper.bind(bar);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        RenderSystem.color4f(HB_GREEN_R, HB_GREEN_G, HB_GREEN_B, HEALTHBAR_OPACITY);
        BarRendererHelper.blit(matrixStackIn, HB_POS_X, HB_POS_Y, 0, 19, (int) Math.ceil((double) HB_WIDTH * (hp / vit)), HB_HEIGHT);

        // render text
        matrixStackIn.translate(0.0D, 0.0D, -0.01D);
        matrixStackIn.translate(TEXT_POS_X, TEXT_POS_Y, -0.03D);
        matrixStackIn.scale(textScale, textScale, 1.0F);
        int color = ColorHelper.ARGB32.color(255, 255, 255, 255); // set black text color no opacity
        BarRendererHelper.drawString(matrixStackIn, font, (int) hp + "/" + (int) vit, (int)hpWidth, 20, color, false);

        RenderSystem.disableBlend();
        matrixStackIn.popPose();
        RenderSystem.disableDepthTest();
    }

}
