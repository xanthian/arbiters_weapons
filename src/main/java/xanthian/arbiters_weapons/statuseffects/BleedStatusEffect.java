package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.util.ModParticles;

public class BleedStatusEffect extends StatusEffect {

    public BleedStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 16266787);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i;
        i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (entity.getHealth() > 0.5F) {
            entity.damage(entity.getDamageSources().magic(), 1.5f * (amplifier));
            if (world instanceof ServerWorld serverWorld) {
                double px = entity.getX();
                double py = entity.getY() + 1.5;
                double pz = entity.getZ();
                serverWorld.spawnParticles(ModParticles.BLEED_PARTICLE, px, py, pz, 4, 0.3, 0.1, 0.3, 0);

            }
        }
    }
}