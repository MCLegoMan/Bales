/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.config;

import me.magistermaks.simple_config.SimpleConfig;
import net.minecraft.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ConfigProvider implements SimpleConfig.DefaultConfig {
	private String contents = "";
	private final List<Pair<String, ?>> configList = new ArrayList<>();
	public ConfigProvider() {
	}
	public void add(Pair<String, ?> keyValueSet) {
		this.configList.add(keyValueSet);
	}
	public String get(String namespace) {
		return this.contents;
	}
}
