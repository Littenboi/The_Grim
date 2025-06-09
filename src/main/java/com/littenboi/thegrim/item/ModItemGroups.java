package com.littenboi.thegrim.item;

import com.littenboi.thegrim.TheGrim;
import com.littenboi.thegrim.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup THE_GRIM_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheGrim.MOD_ID, "the_grim_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STATIC_GEM))
                    .displayName(Text.translatable("itemgroup.the-grim.the_grim_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STATIC_GEM);
                        entries.add(ModItems.RAW_STATIC);
                    }).build());

    public static final ItemGroup THE_GRIM_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheGrim.MOD_ID, "the_grim_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.GRIM_GRASS_BLOCK))
                    .displayName(Text.translatable("itemgroup.the-grim.the_grim_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GRIM_GRASS_BLOCK);
                        entries.add(ModBlocks.GRIM_DIRT_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        TheGrim.LOGGER.info("Registering Item Groups for " + TheGrim.MOD_ID);
    }
}
