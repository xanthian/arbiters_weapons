package xanthian.arbiters_weapons.item.axes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModAxeItem;

import java.util.Collection;

public class TeoriteAxe extends ModAxeItem {
    public TeoriteAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this) {
            if (target.getActiveStatusEffects() != null) {
                Collection<StatusEffectInstance> effects = target.getStatusEffects();
                for (StatusEffectInstance effectInstance : effects) {
                    StatusEffect effect = effectInstance.getEffectType();
                    if (effect.isBeneficial()) {
                        target.removeStatusEffect(effect);
                        serverWorld.playSoundFromEntity(null, target, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 0.7f, 1.9f);
                    }
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}