package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;
import xanthian.arbiters_weapons.util.ModStatusEffects;

public class DragonsNail extends ModDaggerItem {
    public DragonsNail(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ItemStack mainHand = attacker.getMainHandStack();
        ItemStack offHand = attacker.getOffHandStack();

        if (!world.isClient && (mainHand.getItem() == this || offHand.getItem() == this)) {
            if (world.random.nextFloat() <= 0.62f) {

                StatusEffectInstance bleed = target.getStatusEffect(ModStatusEffects.BLEED);
                StatusEffectInstance poison = target.getStatusEffect(StatusEffects.POISON);

                if (bleed == null || bleed.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BLEED,
                            200, 0, true, false, true), target);
                }
                if (poison == null || poison.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON,
                            200, 0, true, true, true), target);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public float getCrit() {
        return 0.05F;
    }
}