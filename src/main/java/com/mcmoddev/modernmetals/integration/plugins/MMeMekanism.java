package com.mcmoddev.modernmetals.integration.plugins;

import java.util.Arrays;
import java.util.List;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.Mekanism;
import com.mcmoddev.lib.util.Config.Options;
import com.mcmoddev.modernmetals.ModernMetals;
import com.mcmoddev.modernmetals.data.MaterialNames;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@MMDPlugin(addonId = ModernMetals.MODID, pluginId = MMeMekanism.PLUGIN_MODID)
public class MMeMekanism extends Mekanism implements IIntegration {
	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		final List<String> materials = Arrays.asList(MaterialNames.ALUMINUM, MaterialNames.BERYLLIUM,
				MaterialNames.BORON, MaterialNames.CADMIUM, MaterialNames.CHROMIUM, MaterialNames.IRIDIUM,
				MaterialNames.MAGNESIUM, MaterialNames.MANGANESE, MaterialNames.PLUTONIUM, MaterialNames.RUTILE,
				MaterialNames.TANTALUM, MaterialNames.THORIUM, MaterialNames.TITANIUM, MaterialNames.TUNGSTEN,
				MaterialNames.URANIUM, MaterialNames.ZIRCONIUM);

		materials.stream().filter(Materials::hasMaterial)
				.filter(materialName -> !Materials.getMaterialByName(materialName).isEmpty())
				.forEach(Mekanism::addGassesForMaterial);

		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * 
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void multiplyOres(final RegistryEvent.Register<IRecipe> event) {
		final List<String> materials = Arrays.asList(MaterialNames.ALUMINUM, MaterialNames.BERYLLIUM,
				MaterialNames.BORON, MaterialNames.CADMIUM, MaterialNames.CHROMIUM, MaterialNames.IRIDIUM,
				MaterialNames.MAGNESIUM, MaterialNames.MANGANESE, MaterialNames.PLUTONIUM, MaterialNames.RUTILE,
				MaterialNames.TANTALUM, MaterialNames.THORIUM, MaterialNames.TITANIUM, MaterialNames.TUNGSTEN,
				MaterialNames.URANIUM, MaterialNames.ZIRCONIUM);

		materials.stream().filter(Materials::hasMaterial)
				.filter(materialName -> !Materials.getMaterialByName(materialName).isEmpty())
				.forEach(Mekanism::addOreMultiplicationRecipes);
	}
}
