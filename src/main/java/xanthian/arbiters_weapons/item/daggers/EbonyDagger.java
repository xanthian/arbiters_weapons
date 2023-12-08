package xanthian.arbiters_weapons.item.daggers;

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
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;

public class EbonyDagger extends ModDaggerItem {
    public EbonyDagger(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        Item offHand = attacker.getOffHandStack().getItem();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);

        if (!world.isClient && (mainHand == this || offHand == this) && !target.isUndead()) {
            if (world.random.nextFloat() <= 0.20f) {

                float damage = world.random.nextFloat() * (7 - 3) + 3;
                target.damage(target.getWorld().getDamageSources().magic(), baseDamage + damage);
                serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_SHULKER_TELEPORT, SoundCategory.PLAYERS, 1f, 0.2f);
                serverWorld.spawnParticles(ParticleTypes.REVERSE_PORTAL, target.getX(), target.getY() + 1, target.getZ(), 10, 0.3, 0.1, 0.3, 0.1);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}