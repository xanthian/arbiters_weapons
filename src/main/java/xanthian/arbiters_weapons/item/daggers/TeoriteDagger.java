package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;
import xanthian.arbiters_weapons.util.ModStatusEffects;

public class TeoriteDagger extends ModDaggerItem {
    public TeoriteDagger(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        Item offHand = attacker.getOffHandStack().getItem();

        if (!world.isClient && (mainHand == this || offHand == this)) {
            if (world.random.nextFloat() <= 0.62f) {
                StatusEffectInstance root = target.getStatusEffect(ModStatusEffects.ROOT);
                if (root == null || root.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.ROOT, 100, 0, true, false, true), target);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}