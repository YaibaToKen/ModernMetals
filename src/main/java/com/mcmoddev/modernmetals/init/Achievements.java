package com.mcmoddev.modernmetals.init;

import com.mcmoddev.modernmetals.util.Config.Options;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.Loader;

/** initializer for achievements */
public class Achievements extends com.mcmoddev.lib.init.Achievements {

	/** Make Aluminum Brass Blend */
	public static Achievement aluminumBrassMaker;
	/** Make Galvanized Steel Blend */
	public static Achievement galvanizedSteelMaker;
	/** Make Nichrome Blend */
	public static Achievement nichromeMaker;
	/** Make Stainless Steel Blend */
	public static Achievement stainlessSteelMaker;
	/** Make Titanium Blend */
	public static Achievement titaniumMaker;

	private static boolean initDone = false;

	private Achievements() {
		throw new IllegalAccessError("Not a instantiable class");
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		if (com.mcmoddev.basemetals.util.Config.Options.enableAchievements) {
			AchievementPage page = new AchievementPage(Loader.instance().activeModContainer().getModId());
			AchievementPage.registerAchievementPage(page);

			if (Options.enableAluminumBrass) {
				aluminumBrassMaker = makeAchievement("aluminumbrass_maker", com.mcmoddev.basemetals.init.Achievements.metallurgy, 0, 0, Materials.aluminumBrass.ingot, page);
			}
			if (Options.enableGalvanizedSteel) {
				galvanizedSteelMaker = makeAchievement("galvanized_steel_maker", com.mcmoddev.basemetals.init.Achievements.metallurgy, 0, 1, Materials.galvanizedSteel.ingot, page);
			}
			if (Options.enableNichrome) {
				nichromeMaker = makeAchievement("nichrome_maker", com.mcmoddev.basemetals.init.Achievements.metallurgy, 0, 2, Materials.nichrome.ingot, page);
			}
			if (Options.enableStainlessSteel) {
				stainlessSteelMaker = makeAchievement("stainless_steel_maker", com.mcmoddev.basemetals.init.Achievements.metallurgy, 0, 3, Materials.stainlessSteel.ingot, page);
			}
			if (Options.enableTitanium) {
				titaniumMaker = makeAchievement("titanium_maker", com.mcmoddev.basemetals.init.Achievements.metallurgy, 0, 4, Materials.titanium.ingot, page);
			}
		}

		initDone = true;
	}
}
