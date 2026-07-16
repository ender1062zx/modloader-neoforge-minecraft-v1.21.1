package com.benjamin.weapons.item;

import com.benjamin.weapons.config.ModConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.Optional;

public class AetherSwordItem extends SwordItem {

    public AetherSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Run logic only on server side to prevent duplication and desync
        if (!attacker.level().isClientSide()) {
            Player player = attacker instanceof Player ? (Player) attacker : null;
            
            // Check if attacker is not on cooldown for this item
            if (player == null || !player.getCooldowns().isOnCooldown(stack.getItem())) {
                
                // Roll probability
                double chance = ModConfig.COMMON.activationChance.get();
                if (attacker.getRandom().nextDouble() * 100.0 < chance) {
                    
                    // Retrieve mob effect dynamically from config registry ID
                    String effectIdStr = ModConfig.COMMON.effectId.get();
                    ResourceLocation effectRl = ResourceLocation.tryParse(effectIdStr);
                    
                    if (effectRl != null) {
                        Optional<Holder.Reference<MobEffect>> holderOpt = BuiltInRegistries.MOB_EFFECT.getHolder(effectRl);
                        
                        if (holderOpt.isPresent() && target.isAlive()) {
                            Holder<MobEffect> effectHolder = holderOpt.get();
                            int duration = ModConfig.COMMON.effectDuration.get() * 20; // seconds to ticks
                            int level = ModConfig.COMMON.effectLevel.get() - 1; // 1-indexed to 0-indexed amplifier
                            
                            // Apply the effect
                            MobEffectInstance effectInstance = new MobEffectInstance(
                                    effectHolder,
                                    duration,
                                    level,
                                    false, // ambient
                                    true,  // showParticles
                                    true   // showIcon
                            );
                            target.addEffect(effectInstance);

                            // Apply cooldown to player
                            if (player != null) {
                                int cooldownTicks = ModConfig.COMMON.cooldownSeconds.get() * 20; // seconds to ticks
                                if (cooldownTicks > 0) {
                                    player.getCooldowns().addCooldown(stack.getItem(), cooldownTicks);
                                }
                            }

                            // Play magic amethyst block chime sound
                            if (ModConfig.COMMON.enableSound.get()) {
                                target.level().playSound(
                                        null,
                                        target.getX(),
                                        target.getY(),
                                        target.getZ(),
                                        SoundEvents.AMETHYST_BLOCK_CHIME,
                                        SoundSource.PLAYERS,
                                        1.0F,
                                        1.0F
                                );
                            }

                            // Spawn portal particles around the target
                            if (ModConfig.COMMON.enableParticles.get() && target.level() instanceof ServerLevel serverLevel) {
                                int count = ModConfig.COMMON.particleCount.get();
                                serverLevel.sendParticles(
                                        ParticleTypes.PORTAL,
                                        target.getX(),
                                        target.getY() + target.getBbHeight() / 2.0,
                                        target.getZ(),
                                        count,
                                        0.5,
                                        0.5,
                                        0.5,
                                        0.1
                                );
                            }
                        }
                    }
                }
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        // Dynamically override durability from config
        return ModConfig.COMMON.durability.get();
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        // Add a beautiful light-violet colored tooltip
        tooltipComponents.add(Component.translatable("item.benjamin_weapons.aether_sword.tooltip")
                .withStyle(style -> style.withColor(TextColor.fromRgb(0xD8B2FF))));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
