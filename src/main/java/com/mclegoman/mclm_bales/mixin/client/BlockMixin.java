/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.mixin.client;

import com.mclegoman.mclm_bales.config.BalesConfig;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public abstract class BlockMixin {
	@Shadow protected abstract Block asBlock();
	@Inject(at = @At(value = "HEAD"), method = "getSoundGroup", cancellable = true)
	private void loafy$getSoundGroup(BlockState state, CallbackInfoReturnable<BlockSoundGroup> cir) {
		try {
			if ((state.isLiquid() && BalesConfig.getIgnoreLiquids()) || !state.isLiquid()) if (!this.asBlock().getDefaultState().equals(BalesConfig.getBlockState(state))) cir.setReturnValue(((AbstractBlockAccessor)BalesConfig.getBlockState(state).getBlock()).invokeGetSoundGroup(BalesConfig.getBlockState(state)));
		} catch (Exception ignored) {}
	}
}