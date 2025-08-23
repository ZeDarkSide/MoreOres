package net.darkside.moreore;

import net.darkside.moreore.block.ModBlocks;
import net.darkside.moreore.item.ItemGroups;
import net.darkside.moreore.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreOre implements ModInitializer {
	public static final String MOD_ID = "moreore";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ItemGroups.registerItemGroup();
		LOGGER.info("Hello world!");
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}



}