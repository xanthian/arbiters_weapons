package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class Excalibur extends ModSwordItem {
    public Excalibur(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (!world.isClient && entity instanceof LivingEntity livingEntity && stack.isOf(this)) {
            if (livingEntity.age % 60 == 0) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 0, true, false, true));
            }
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (!world.isClient && mainHand == this && target.isUndead()) {
            target.damage(world.getDamageSources().magic(), baseDamage + 2);
            serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.PLAYERS, 0.9f, 1.7f);

        }
        return super.postHit(stack, target, attacker);
    }
}
