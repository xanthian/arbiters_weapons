package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;

public class SilenceStatusEffect extends StatusEffect {
    public SilenceStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 16266787);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof MobEntity) {
            ((MobEntity) entity).setAttacking(false);
            super.onApplied(entity, attributes, amplifier);
        }
    }
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof MobEntity) {
            ((MobEntity) entity).setAttacking(true);
            super.onApplied(entity, attributes, amplifier);
        }
    }
}