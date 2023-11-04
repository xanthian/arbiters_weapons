package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class DendriteSword extends ModSwordItem {
    public DendriteSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        if ((!world.isClient) && (attacker.getMainHandStack().getItem() == this)) {
            if (target.hasStatusEffect(StatusEffects.REGENERATION)) {
                target.removeStatusEffect(StatusEffects.REGENERATION);
            }
            if (world.random.nextFloat() <= 0.2f && target.isUndead()) {
                target.damage(target.getDamageSources().magic(), 8f);
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                        SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.PLAYERS, 0.3f, 0.2f);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}