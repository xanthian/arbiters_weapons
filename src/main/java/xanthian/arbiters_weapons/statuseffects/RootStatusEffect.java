package xanthian.arbiters_weapons.statuseffects;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import xanthian.arbiters_weapons.util.ModAttributes;


public class RootStatusEffect extends StatusEffect {
    public RootStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 9126145);
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "b97d749e-d108-43bd-b628-4d388efef68f",
                        -500.0, EntityAttributeModifier.Operation.ADDITION)

        .addAttributeModifier(ModAttributes.GENERIC_JUMP_BOOST,"0e05c4e0-bd41-430f-91ba-e8d47fb6b715",
                -500, EntityAttributeModifier.Operation.ADDITION);
    }
}