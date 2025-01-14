/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.mixin.client;

import com.mclegoman.mclm_bales.config.BalesConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.Sprite;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FluidRenderer.class)
public abstract class FluidRendererMixin {
	@Shadow private Sprite waterOverlaySprite;
	@Shadow @Final private Sprite[] waterSprites;
	@Shadow @Final private Sprite[] lavaSprites;
	@Inject(at = @At(value = "HEAD"), method = "onResourceReload", cancellable = true)
	private void loafy$onResourceReload(CallbackInfo ci) {
		if (BalesConfig.getReplaceSpriteTextures()) {
			BlockModelsAccessor blockModels = ((BlockModelsAccessor) MinecraftClient.getInstance().getBakedModelManager().getBlockModels());
			BakedModel bakedModel = blockModels.getModels().get(BalesConfig.getDefaultBlockState());
			if (bakedModel == null) bakedModel = blockModels.getModelManager().getMissingModel();
			Sprite sprite = bakedModel.getParticleSprite();
			this.lavaSprites[0] = sprite;
			this.lavaSprites[1] = sprite;
			this.waterSprites[0] = sprite;
			this.waterSprites[1] = sprite;
			this.waterOverlaySprite = sprite;
			ci.cancel();
		}
	}
}