package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;

public class WormTooth extends ModDaggerItem {
    public WormTooth(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        Item offHand = attacker.getOffHandStack().getItem();

        if (!world.isClient && (mainHand == this || offHand == this)) {
            if (world.random.nextFloat() <= 0.75f) {
                StatusEffectInstance poison = target.getStatusEffect(StatusEffects.POISON);
                if (poison == null || poison.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,
                            200, 1, true, true, true), target);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}