/*
    Bales
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Bales
    Licence: GNU LGPLv3
*/

package com.mclegoman.mclm_bales.client;

import com.mclegoman.mclm_bales.config.BalesConfig;

public class Bales {
	public static void onInitializeClient() {
		System.out.println("*turns all your blocks into bread*");
		BalesConfig.init();
	}
}
