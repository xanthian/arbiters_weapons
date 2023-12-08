package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;
import xanthian.arbiters_weapons.util.ModStatusEffects;

public class Icebrand extends ModSwordItem {
    public Icebrand(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this) {
            if (world.random.nextFloat() <= 0.2f) {
                StatusEffectInstance freezeEffect = target.getStatusEffect(ModStatusEffects.FREEZE);
                if (freezeEffect == null || freezeEffect.getDuration() < 10) {
                    target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.FREEZE, 200, 0, true, false, true), attacker);
                    serverWorld.playSoundFromEntity(null, target, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1f, 2.6f);
                    serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_PLAYER_HURT_FREEZE, SoundCategory.PLAYERS, 3f, 1.2f);
                }
            }
        }
        if (target.isOnFire()) {
            target.extinguish();
        }
        return super.postHit(stack, target, attacker);
    }
}