package com.mcmoddev.modernmetals.init;

import com.mcmoddev.modernmetals.util.Config.Options;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.Loader;

/** initializer for achievements */
public class Achievements extends com.mcmoddev.basemetals.init.Achievements {

	public static Achievement aluminumbrass_maker; // make blend
	public static Achievement galvanized_steel_maker; // make blend
	public static Achievement nichrome_maker; // make blend
	public static Achievement stainless_steel_maker; // make blend
	public static Achievement titanium_maker; // make blend

	private static boolean initDone = false;

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		if (com.mcmoddev.basemetals.util.Config.Options.ENABLE_ACHIEVEMENTS) {
			AchievementPage page = new AchievementPage(Loader.instance().activeModContainer().getModId());
			AchievementPage.registerAchievementPage(page);

			if (Options.ENABLE_ALUMINUMBRASS) {
				aluminumbrass_maker = makeAchievement("aluminumbrass_maker", metallurgy, 0, 0, Materials.aluminumbrass.ingot, page);
			}
			if (Options.ENABLE_GALVANIZEDSTEEL) {
				galvanized_steel_maker = makeAchievement("galvanized_steel_maker", metallurgy, 0, 1, Materials.galvanizedsteel.ingot, page);
			}
			if (Options.ENABLE_NICHROME) {
				nichrome_maker = makeAchievement("nichrome_maker", metallurgy, 0, 2, Materials.nichrome.ingot, page);
			}
			if (Options.ENABLE_STAINLESSSTEEL) {
				stainless_steel_maker = makeAchievement("stainless_steel_maker", metallurgy, 0, 3, Materials.stainlesssteel.ingot, page);
			}
			if (Options.ENABLE_TITANIUM) {
				titanium_maker = makeAchievement("titanium_maker", metallurgy, 0, 4, Materials.titanium.ingot, page);
			}
		}

		initDone = true;
	}
}