package com.benjamin.weapons.datagen;

import com.benjamin.weapons.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Crafting Recipe:
        // A = Amethyst Shard
        // N = Netherite Ingot
        // B = Blaze Rod
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AETHER_SWORD.get())
                .pattern("A")
                .pattern("N")
                .pattern("B")
                .define('A', Items.AMETHYST_SHARD)
                .define('N', Items.NETHERITE_INGOT)
                .define('B', Items.BLAZE_ROD)
                // Automatically creates recipe book unlock advancement when Amethyst Shard is obtained
                .unlockedBy("has_amethyst", has(Items.AMETHYST_SHARD))
                .save(output);
    }
}
