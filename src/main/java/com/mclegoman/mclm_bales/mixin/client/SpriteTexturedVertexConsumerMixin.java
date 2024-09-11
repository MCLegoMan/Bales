/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.mixin.client;

import com.mclegoman.mclm_bales.config.BalesConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.SpriteTexturedVertexConsumer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.Sprite;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(SpriteTexturedVertexConsumer.class)
public abstract class SpriteTexturedVertexConsumerMixin {
	@Mutable @Shadow @Final private Sprite sprite;
	@Inject(at = @At(value = "RETURN"), method = "<init>")
	private void loafy$init(VertexConsumer delegate, Sprite sprite, CallbackInfo ci) {
		if (BalesConfig.getReplaceSpriteTextures()) {
			BlockModelsAccessor blockModels = ((BlockModelsAccessor) MinecraftClient.getInstance().getBakedModelManager().getBlockModels());
			BakedModel bakedModel = blockModels.getModels().get(BalesConfig.getDefaultBlockState());
			if (bakedModel == null) bakedModel = blockModels.getModelManager().getMissingModel();
			this.sprite = bakedModel.getParticleSprite();
		}
	}
}