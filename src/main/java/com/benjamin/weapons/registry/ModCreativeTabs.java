package com.benjamin.weapons.registry;

import com.benjamin.weapons.BenjaminWeapons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BenjaminWeapons.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.benjamin_weapons.main"))
                    .icon(() -> new ItemStack(ModItems.AETHER_SWORD.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.AETHER_SWORD.get());
                    })
                    .build()
    );
}
