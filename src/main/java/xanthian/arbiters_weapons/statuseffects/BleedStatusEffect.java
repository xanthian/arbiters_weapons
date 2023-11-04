package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

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
        if (entity.getHealth() > 0.5F) {
            entity.damage(entity.getDamageSources().magic(), 1.5f * (amplifier + 1));
        }
    }
}