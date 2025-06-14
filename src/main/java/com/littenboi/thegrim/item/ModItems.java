package com.littenboi.thegrim.item;

import com.littenboi.thegrim.TheGrim;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STATIC_GEM = registerItem( "static_gem", new Item(new Item.Settings()));
    public static final Item RAW_STATIC = registerItem( "raw_static", new Item(new Item.Settings()));
    public static final Item GRIMSTONE_SHARD = registerItem( "grimstone_shard", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheGrim.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheGrim.LOGGER.info("Registering Mod Items for " + TheGrim.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(STATIC_GEM);
            fabricItemGroupEntries.add(RAW_STATIC);
            fabricItemGroupEntries.add(GRIMSTONE_SHARD);
        });
    }
}
