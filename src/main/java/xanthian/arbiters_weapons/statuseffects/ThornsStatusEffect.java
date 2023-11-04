package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.World;

public class ThornsStatusEffect extends StatusEffect {
    public ThornsStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 16737294);
    }

    @Override
    public void applyUpdateEffect(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getWorld().isClient()) {
            Entity attacker = livingEntity.getAttacker();

            // if hit
            if (livingEntity.hurtTime == 9) {
                if (attacker != null){
                    World world = attacker.getWorld();
                    attacker.damage(world.getDamageSources().thorns(livingEntity), amplifier + 2);
                }
            }
        }
        super.applyUpdateEffect(livingEntity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int amplifier) {
        return true;
    }
}