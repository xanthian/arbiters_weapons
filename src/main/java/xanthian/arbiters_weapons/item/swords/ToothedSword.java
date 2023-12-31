package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;
import xanthian.arbiters_weapons.util.ModStatusEffects;

public class ToothedSword extends ModSwordItem {
    public ToothedSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this && !target.isUndead()) {
            if (world.random.nextFloat() <= 0.25f) {
                StatusEffectInstance bleedEffect = target.getStatusEffect(ModStatusEffects.BLEED);
                if (bleedEffect == null || bleedEffect.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEED,
                            200, 1, true, false, true), attacker);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}