package com.benjamin.weapons.datagen;

import com.benjamin.weapons.BenjaminWeapons;
import com.benjamin.weapons.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BenjaminWeapons.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Generates the model with parent "minecraft:item/handheld"
        withExistingParent(ModItems.AETHER_SWORD.getId().getPath(), mcLoc("item/handheld"))
                .texture("layer0", modLoc("item/" + ModItems.AETHER_SWORD.getId().getPath()));
    }
}
