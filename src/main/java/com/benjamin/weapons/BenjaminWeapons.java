package com.benjamin.weapons;

import com.benjamin.weapons.config.ModConfig;
import com.benjamin.weapons.event.ModEvents;
import com.benjamin.weapons.registry.ModCreativeTabs;
import com.benjamin.weapons.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(BenjaminWeapons.MOD_ID)
public class BenjaminWeapons {
    public static final String MOD_ID = "benjamin_weapons";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BenjaminWeapons(IEventBus modEventBus, ModContainer modContainer) {
        // Register common/server configuration
        modContainer.registerConfig(net.neoforged.fml.config.ModConfig.Type.COMMON, ModConfig.COMMON_SPEC);

        // Register registry deferrers to mod event bus
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        // Register event handlers on game event bus
        NeoForge.EVENT_BUS.register(ModEvents.class);

        LOGGER.info("Benjamin Weapons Mod has been initialized!");
    }
}
