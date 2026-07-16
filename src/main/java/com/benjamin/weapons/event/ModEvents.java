package com.benjamin.weapons.event;

import com.benjamin.weapons.BenjaminWeapons;
import com.benjamin.weapons.config.ModConfig;
import com.benjamin.weapons.registry.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

public class ModEvents {

    @SubscribeEvent
    public static void onItemAttributeModifier(ItemAttributeModifierEvent event) {
        // Apply custom configurable attribute modifiers to the Aether Sword
        if (event.getItemStack().is(ModItems.AETHER_SWORD.get())) {
            
            // Clear default attributes to prevent overlapping modifiers
            event.clearModifiers();

            // Register Configured Attack Damage
            double damageBonus = ModConfig.COMMON.attackDamageBonus.get();
            event.addModifier(
                    Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(
                            ResourceLocation.fromNamespaceAndPath(BenjaminWeapons.MOD_ID, "base_attack_damage"),
                            damageBonus,
                            AttributeModifier.Operation.ADD_VALUE
                    ),
                    EquipmentSlotGroup.MAINHAND
            );

            // Register Configured Attack Speed
            double attackSpeed = ModConfig.COMMON.attackSpeed.get();
            event.addModifier(
                    Attributes.ATTACK_SPEED,
                    new AttributeModifier(
                            ResourceLocation.fromNamespaceAndPath(BenjaminWeapons.MOD_ID, "base_attack_speed"),
                            attackSpeed,
                            AttributeModifier.Operation.ADD_VALUE
                    ),
                    EquipmentSlotGroup.MAINHAND
            );
        }
    }
}
