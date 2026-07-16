package com.benjamin.weapons.registry;

import com.benjamin.weapons.BenjaminWeapons;
import com.benjamin.weapons.item.AetherSwordItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BenjaminWeapons.MOD_ID);

    // Custom tool tier for Aether Sword.
    // Repairs using amethyst shard, has epic enchantability and netherite mining capabilities.
    public static final Tier AETHER_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // block harvest level similar to netherite
            1750, // default max durability
            8.0F, // speed
            3.5F, // base attack damage bonus (between Diamond (+3.0) and Netherite (+4.0))
            22,   // enchantability level (higher than diamond, similar to gold/epic items)
            () -> Ingredient.of(Items.AMETHYST_SHARD) // repaired with amethyst shards
    );

    public static final DeferredItem<Item> AETHER_SWORD = ITEMS.register("aether_sword",
            () -> new AetherSwordItem(
                    AETHER_TIER,
                    new Item.Properties().rarity(Rarity.EPIC)
            )
    );
}
