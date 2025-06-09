package com.littenboi.thegrim;

import com.littenboi.thegrim.block.ModBlocks;
import com.littenboi.thegrim.item.ModItemGroups;
import com.littenboi.thegrim.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheGrim implements ModInitializer {
	public static final String MOD_ID = "the-grim";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}