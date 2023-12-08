package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;

public class Kunai extends ModDaggerItem {
    public Kunai(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        Item offHand = attacker.getOffHandStack().getItem();

        if (!world.isClient && (mainHand == this || offHand == this)) {
            if (world.random.nextFloat() <= 0.62f) {
                StatusEffectInstance weakness = target.getStatusEffect(StatusEffects.WEAKNESS);
                if (weakness == null || weakness.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,
                            200, 0, true, true, true), target);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}