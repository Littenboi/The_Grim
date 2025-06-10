package com.littenboi.thegrim.block;

import com.littenboi.thegrim.TheGrim;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GRIM_GRASS_BLOCK = registerBlock("grim_grass_block",
            new GrimGrassBlock(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.GRASS).luminance(state -> 5)));

    public static final Block GRIM_DIRT_BLOCK = registerBlock("grim_dirt_block",
            new GrimGrassBlock(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.GRAVEL).luminance(state -> 5)));

    public static final Block GRIMSTONE_BLOCK = registerBlock("grimstone_block",
            new Block(AbstractBlock.Settings.create().strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE).luminance(state -> 10)));

    public static final Block GRIM_SHORT_GRASS = registerBlock("grim_short_grass",
            new ShortPlantBlock(AbstractBlock.Settings.create().replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY).nonOpaque().luminance(state -> 1)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return  Registry.register(Registries.BLOCK, Identifier.of(TheGrim.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TheGrim.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TheGrim.LOGGER.info("Registering Mod Blocks for " + TheGrim.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.GRIM_GRASS_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.GRIM_DIRT_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.GRIMSTONE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.GRIM_SHORT_GRASS);
        });
    }
}
