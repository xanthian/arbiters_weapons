package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DefenceDownEffect extends StatusEffect {
    public DefenceDownEffect() {
        super(StatusEffectCategory.HARMFUL, 9126145);

        this.addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "eebdfcf6-a994-45d3-ba65-7bb8a820a405",
                        -10.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "8d9945ff-500f-4cc3-9e95-c8b01afb7e10",
                        -6.0, EntityAttributeModifier.Operation.ADDITION);
    }
}