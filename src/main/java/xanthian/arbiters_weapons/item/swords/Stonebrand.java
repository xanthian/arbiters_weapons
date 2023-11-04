package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class Stonebrand extends ModSwordItem {
    public Stonebrand(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();

        if ((!world.isClient) && (attacker.getMainHandStack().getItem() == this)) {
            if (world.random.nextFloat() <= 0.2f) {
                target.takeKnockback(1.0, -target.getX()+5,-target.getZ()+5);
                if (world instanceof ServerWorld serverWorld) {
                    serverWorld.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                            SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, SoundCategory.PLAYERS, 1f, 1.2f);
                    serverWorld.spawnParticles(ParticleTypes.POOF,
                            target.getX(), target.getY() + 1.5, target.getZ(), 4, 0.2, 1, 0.2, 0.5);
                }
            }
        }
            return super.postHit(stack, target, attacker);
    }
}