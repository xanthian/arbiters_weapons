package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class FrozenStatusEffect extends StatusEffect {
    public FrozenStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 125168255);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "b97d749e-d108-43bd-b628-4d388efef68f",
                -500.0, EntityAttributeModifier.Operation.ADDITION);
        entity.setVelocity(0.0, -1.5, 0.0);
        entity.setMovementSpeed(0);
        entity.setFrozenTicks(200);

        World world = entity.getWorld();
        if(world instanceof ServerWorld serverWorld) {
            for (int i = 0; i < 5; i++) {
                double angle = Math.random() * 360;
                double radius = 0.5;
                double px = entity.getX() + Math.cos(Math.toRadians(angle)) * radius;
                double py = entity.getY() + 1.5;
                double pz = entity.getZ() + Math.sin(Math.toRadians(angle)) * radius;
                serverWorld.spawnParticles(ParticleTypes.SNOWFLAKE,
                        px, py, pz, 1, 0.5, 0, 0.5, 0);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}