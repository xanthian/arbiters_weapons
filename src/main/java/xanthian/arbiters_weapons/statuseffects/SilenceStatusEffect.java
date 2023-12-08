package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.util.ModParticles;

import java.util.Arrays;
import java.util.List;

public class SilenceStatusEffect extends StatusEffect {
    List<EntityType<?>> validTypes = Arrays.asList(
            EntityType.GHAST,
            EntityType.BLAZE,
            EntityType.GUARDIAN,
            EntityType.EVOKER,
            EntityType.ENDERMAN
    );

    public SilenceStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 16266787);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof MobEntity mobEntity) {
            if (validTypes.contains(entity.getType())) {
                mobEntity.setSilent(true);
                mobEntity.setPose(EntityPose.STANDING);
                super.onApplied(entity, attributes, amplifier);
            }
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof MobEntity mobEntity) {
            mobEntity.setSilent(false);
            super.onApplied(entity, attributes, amplifier);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (validTypes.contains(entity.getType())) {
            if (world instanceof ServerWorld serverWorld) {
                double px = entity.getX();
                double py = entity.getY() + 1.5;
                double pz = entity.getZ();
                serverWorld.spawnParticles(ModParticles.SILENCE_PARTICLE,
                        px, py, pz, 3, 0.2, 0.1, 0.2, 0);

            }
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