package com.mcmoddev.modernmetals.util;

import com.mcmoddev.modernmetals.data.AchievementNames;
import com.mcmoddev.modernmetals.data.MaterialNames;
import com.mcmoddev.modernmetals.init.Achievements;

import com.mcmoddev.lib.material.IMMDObject;
import com.mcmoddev.lib.item.ItemMMDIngot;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class EventHandler {

	/*  Right now this isn't needed, but might be at some point
	@SubscribeEvent
	void event(ItemCraftedEvent event) {
		if (!(com.mcmoddev.basemetals.util.Config.Options.enableAchievements())) {
			return;
		}

		final Item item = event.crafting.getItem();
		if (!(item instanceof IMMDObject)) {
			return;
		}
	}
	*/

	@SubscribeEvent
	void event(ItemSmeltedEvent event) {
		if (!(com.mcmoddev.basemetals.util.Config.Options.enableAchievements())) {
			return;
		}

		final Item item = event.smelting.getItem();
		if (!(item instanceof IMMDObject)) {
			return;
		}

		final String materialName = ((IMMDObject) item).getMMDMaterial().getName();
		if (item instanceof ItemMMDIngot) {
			// event.player.addStat(Achievements.getAchievementByName(AchievementNames.THIS_IS_NEW), 1);
			if (materialName.equals(MaterialNames.ALUMINUM_BRASS)) {
				event.player.addStat(Achievements.getAchievementByName(AchievementNames.ALUMINUM_BRASS_MAKER), 1);
			} else if (materialName.equals(MaterialNames.GALVANIZED_STEEL)) {
				event.player.addStat(Achievements.getAchievementByName(AchievementNames.GALVANIZED_STEEL_MAKER), 1);
			} else if (materialName.equals(MaterialNames.NICHROME)) {
				event.player.addStat(Achievements.getAchievementByName(AchievementNames.NICHROME_MAKER), 1);
			} else if (materialName.equals(MaterialNames.STAINLESS_STEEL)) {
			event.player.addStat(Achievements.getAchievementByName(AchievementNames.STAINLESS_STEEL_MAKER), 1);
			} else if (materialName.equals(MaterialNames.TITANIUM)) {
				event.player.addStat(Achievements.getAchievementByName(AchievementNames.TITANIUM_MAKER), 1);
			}
		}
	}
}
