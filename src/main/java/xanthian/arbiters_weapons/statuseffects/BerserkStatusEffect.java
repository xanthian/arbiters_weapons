package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BerserkStatusEffect extends StatusEffect {
    private float healthBefore;

    public BerserkStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 16266787);

    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        healthBefore = entity.getHealth();

        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "991ad029-6a22-444c-9f35-fea7f44c9b11",
                        -20.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "85697e02-c16d-484d-8954-432c4ffeb44d",
                        -12.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "73c0ee82-4828-48bf-8f24-c41dce44eabb",
                        5.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "4bd7cb1b-259c-45cc-a29a-7da019f22602",
                        2.0, EntityAttributeModifier.Operation.ADDITION);
        entity.setHealth(5);

        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        entity.setHealth(healthBefore);

        super.onRemoved(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int dura, int amplifier) {
        return true;
    }
}