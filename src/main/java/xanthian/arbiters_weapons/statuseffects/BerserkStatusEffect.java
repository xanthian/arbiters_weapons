package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BerserkStatusEffect extends StatusEffect {
    public BerserkStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 16266787);


        this.
                addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "991ad029-6a22-444c-9f35-fea7f44c9b11",
                        -20.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "85697e02-c16d-484d-8954-432c4ffeb44d",
                        -12.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "73c0ee82-4828-48bf-8f24-c41dce44eabb",
                        5.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, "4bd7cb1b-259c-45cc-a29a-7da019f22602",
                        2.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "26c206f0-d50e-42c9-8333-5f1d2aae9d65",
                        -15.0, EntityAttributeModifier.Operation.ADDITION);

    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity.getHealth() > 5 && entity.getMaxHealth() > 5) {
            entity.setHealth(5);
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
    }
}