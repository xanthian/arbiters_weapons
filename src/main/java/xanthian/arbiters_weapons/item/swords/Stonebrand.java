package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
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
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this) {
            if (world.random.nextFloat() <= 0.25f) {
                target.takeKnockback(2, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
                serverWorld.playSoundFromEntity(null, target,
                        SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, SoundCategory.PLAYERS, 1f, 1.2f);
                serverWorld.spawnParticles(ParticleTypes.POOF,
                        target.getX(), target.getY() + 1.5, target.getZ(), 4, 0.2, 1, 0.2, 0.5);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}