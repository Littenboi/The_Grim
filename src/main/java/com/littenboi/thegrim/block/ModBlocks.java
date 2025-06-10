package com.littenboi.thegrim.block;

import com.littenboi.thegrim.TheGrim;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;

public class ModBlocks {
    public static final Block GRIM_GRASS_BLOCK = registerBlock("grim_grass_block",
            new GrimGrassBlock(AbstractBlock.Settings.create().strength(0.6f).sounds(BlockSoundGroup.GRASS).luminance(state -> 5)));

    public static final Block GRIM_DIRT_BLOCK = registerBlock("grim_dirt_block",
            new GrimGrassBlock(AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.GRAVEL).luminance(state -> 5)));

    public static final Block GRIMSTONE_BLOCK = registerBlock("grimstone_block",
            new Block(AbstractBlock.Settings.create().strength(50.0F, 1200.0F).sounds(BlockSoundGroup.NETHERITE).luminance(state -> 10)));

    public static final Block GRIM_SHORT_GRASS = registerBlock("grim_short_grass",
            new ShortPlantBlock(AbstractBlock.Settings.create().replaceable().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY).nonOpaque().luminance(state -> 1)));

    public static final Block STATIC_ORE = registerBlock("static_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F).sounds(BlockSoundGroup.STONE).luminance(state -> 2)));

    public static final Block DEEPSLATE_STATIC_ORE = registerBlock("deepslate_static_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.copy(STATIC_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).luminance(state -> 2)));


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
            fabricItemGroupEntries.add(ModBlocks.STATIC_ORE);
            fabricItemGroupEntries.add(ModBlocks.DEEPSLATE_STATIC_ORE);
        });
    }
}
