package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;

public class Dirk extends ModDaggerItem {
    public Dirk(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ItemStack mainHand = attacker.getMainHandStack();
        ItemStack offHand = attacker.getOffHandStack();

        if (!world.isClient && (mainHand.getItem() == this || offHand.getItem() == this)) {
            if (world.random.nextFloat() <= 0.62f) {
                StatusEffectInstance blindness = target.getStatusEffect(StatusEffects.BLINDNESS);
                if (blindness == null || blindness.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,
                            200, 0, true, true, true), target);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}