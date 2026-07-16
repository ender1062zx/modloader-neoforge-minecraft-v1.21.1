package com.benjamin.weapons.datagen;

import com.benjamin.weapons.BenjaminWeapons;
import com.benjamin.weapons.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    private final String locale;

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, BenjaminWeapons.MOD_ID, locale);
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        if ("en_us".equals(locale)) {
            add(ModItems.AETHER_SWORD.get(), "Aether Sword");
            add("item.benjamin_weapons.aether_sword.tooltip", "Forged with Aether energy");
            add("creativetab.benjamin_weapons.main", "Benjamin Weapons");
        } else if ("es_cl".equals(locale)) {
            add(ModItems.AETHER_SWORD.get(), "Espada de Aether");
            add("item.benjamin_weapons.aether_sword.tooltip", "Forjada con energía del Aether");
            add("creativetab.benjamin_weapons.main", "Benjamin Weapons");
        }
    }
}
