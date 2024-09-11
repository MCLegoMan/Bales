/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.mixin.client;

import com.mclegoman.mclm_bales.config.BalesConfig;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedModelManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(BlockModels.class)
public abstract class BlockModelsMixin {
	@Shadow private Map<BlockState, BakedModel> models;
	@Shadow @Final private BakedModelManager modelManager;
	@Inject(at = @At(value = "HEAD"), method = "getModel", cancellable = true)
	private void loafy$getModel(BlockState state, CallbackInfoReturnable<BakedModel> cir) {
		BakedModel bakedModel = this.models.get(BalesConfig.getBlockState(state));
		if (bakedModel == null) bakedModel = this.modelManager.getMissingModel();
		cir.setReturnValue(bakedModel);
	}
}