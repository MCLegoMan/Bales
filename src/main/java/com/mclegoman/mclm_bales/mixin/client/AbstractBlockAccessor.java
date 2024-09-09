/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.mixin.client;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AbstractBlock.class)
public interface AbstractBlockAccessor {
	@Invoker("getSoundGroup")
	BlockSoundGroup invokeGetSoundGroup(BlockState state);
}
