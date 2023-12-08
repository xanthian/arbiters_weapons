package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.util.ModParticles;

public class SleepStatusEffect extends StatusEffect {
    public SleepStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 8100544);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient && entity instanceof MobEntity mobEntity) {
            mobEntity.setAiDisabled(true);
            mobEntity.setSilent(true);
            mobEntity.setPose(EntityPose.SLEEPING);
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient && entity instanceof MobEntity mobEntity) {
            mobEntity.setAiDisabled(false);
            mobEntity.setSilent(false);
            mobEntity.setPose(EntityPose.STANDING);
            super.onApplied(entity, attributes, amplifier);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(ModParticles.SLEEP_PARTICLE,
                    entity.getX(), entity.getY(), entity.getZ(), 0, 0.5, 0.5, 0.5, 0);

        }
        super.applyUpdateEffect(entity, amplifier);
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
}