package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class Enhancer extends ModSwordItem {
    public Enhancer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float damage = world.random.nextFloat() * (7 - 3) + 3;

        if (!world.isClient && mainHand == this && !target.isUndead()) {
            if (world.random.nextFloat() <= 0.20f) {

                target.damage(target.getWorld().getDamageSources().magic(), baseDamage + damage);
                serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, SoundCategory.PLAYERS, 1f, 0.2f);
                serverWorld.spawnParticles(ParticleTypes.REVERSE_PORTAL,
                        target.getX(), target.getY() + 1, target.getZ(), 10, 0.3, 0.1, 0.3, 0.1);

            }
        }
        return super.postHit(stack, target, attacker);
    }
}