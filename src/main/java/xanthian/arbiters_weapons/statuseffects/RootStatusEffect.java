package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.util.ModAttributes;
import xanthian.arbiters_weapons.util.ModParticles;

public class RootStatusEffect extends StatusEffect {
    public RootStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 9126145);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "b97d749e-d108-43bd-b628-4d388efef68f",
                        -500.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(ModAttributes.GENERIC_JUMP_BOOST, "0e05c4e0-bd41-430f-91ba-e8d47fb6b715",
                        -500, EntityAttributeModifier.Operation.ADDITION);


        entity.setVelocity(0.0, -1.5, 0.0);
        entity.setMovementSpeed(0);

        World world = entity.getWorld();
        if (world instanceof ServerWorld serverWorld) {
            double px = entity.getX();
            double py = entity.getY() + 1.5;
            double pz = entity.getZ();
            serverWorld.spawnParticles(ModParticles.ROOT_PARTICLE, px, py, pz, 2, 0.2, 0.1, 0.2, 0);
        }
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