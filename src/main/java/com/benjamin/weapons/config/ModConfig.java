package com.benjamin.weapons.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {
    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {
        // Weapon attributes (read on startup/restart)
        public final ModConfigSpec.DoubleValue attackDamageBonus;
        public final ModConfigSpec.DoubleValue attackSpeed;
        public final ModConfigSpec.IntValue durability;

        // Effect config (read dynamically on hit)
        public final ModConfigSpec.ConfigValue<String> effectId;
        public final ModConfigSpec.IntValue effectDuration;
        public final ModConfigSpec.IntValue effectLevel;
        public final ModConfigSpec.DoubleValue activationChance;
        public final ModConfigSpec.IntValue cooldownSeconds;

        // Visuals and sounds (read dynamically on hit)
        public final ModConfigSpec.BooleanValue enableParticles;
        public final ModConfigSpec.IntValue particleCount;
        public final ModConfigSpec.BooleanValue enableSound;

        public Common(ModConfigSpec.Builder builder) {
            builder.push("Weapon Stats");
            attackDamageBonus = builder.comment("Damage bonus of the Aether Sword compared to a standard sword (Netherite is 4.0, Diamond is 3.0, default 3.5 for Aether)")
                    .defineInRange("attackDamageBonus", 3.5, 0.0, 100.0);
            attackSpeed = builder.comment("Attack speed modifier of the Aether Sword. Target speed is 4.0 + modifier. A modifier of -2.4 results in 1.6 attack speed.")
                    .defineInRange("attackSpeed", -2.4, -4.0, 4.0);
            durability = builder.comment("Durability of the Aether Sword (uses). Note: changing this requires game restart.")
                    .defineInRange("durability", 1750, 1, 100000);
            builder.pop();

            builder.push("Special Power Effect");
            effectId = builder.comment("The registry ID of the mob effect to apply (e.g., 'minecraft:slowness', 'minecraft:weakness', 'minecraft:poison', 'minecraft:glowing')")
                    .define("effectId", "minecraft:slowness");
            effectDuration = builder.comment("Duration of the effect in seconds")
                    .defineInRange("effectDuration", 2, 0, 3600);
            effectLevel = builder.comment("Level of the effect (1 to 255)")
                    .defineInRange("effectLevel", 1, 1, 255);
            activationChance = builder.comment("Probability of activation in percent (0.0 to 100.0)")
                    .defineInRange("activationChance", 25.0, 0.0, 100.0);
            cooldownSeconds = builder.comment("Cooldown duration in seconds")
                    .defineInRange("cooldownSeconds", 3, 0, 3600);
            builder.pop();

            builder.push("Visuals and Sounds");
            enableParticles = builder.comment("Whether to spawn particles when the effect is triggered")
                    .define("enableParticles", true);
            particleCount = builder.comment("Number of particles to spawn")
                    .defineInRange("particleCount", 20, 1, 100);
            enableSound = builder.comment("Whether to play a sound when the effect is triggered")
                    .define("enableSound", true);
            builder.pop();
        }
    }
}
