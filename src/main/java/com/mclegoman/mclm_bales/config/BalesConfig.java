/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.config;

import me.magistermaks.simple_config.SimpleConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class BalesConfig {
	protected static final String id = "mclm_bales";
	protected static SimpleConfig config;
	protected static ConfigProvider configProvider;
	private static String blockId = "minecraft:hay_block";
	private static BlockState blockState = Blocks.AIR.getDefaultState();
	public static void init() {
		try {
			configProvider = new ConfigProvider();
			create();
			config = SimpleConfig.of(id).provider(configProvider).request();
			assign();
			blockState = Registries.BLOCK.get(Identifier.of(blockId)).getDefaultState();
		} catch (Exception error) {
			System.out.println(error.getLocalizedMessage());
		}
	}
	protected static void create() {
		configProvider.add(new Pair<>("block", "minecraft:hay_block"));
	}
	protected static void assign() {
		blockId = config.getOrDefault("block", "minecraft:hay_block");
	}
	public static BlockState getBlockState() {
		return blockState;
	}
}
