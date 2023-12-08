package xanthian.arbiters_weapons.item.axes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModAxeItem;

public class BloodAxe extends ModAxeItem {
    public BloodAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.UNCOMMON;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this) {
            if (attacker instanceof PlayerEntity player) {
                if (!player.getItemCooldownManager().isCoolingDown(this) && player.getHealth() < player.getMaxHealth() / 2) {
                    player.heal(10);
                    player.getItemCooldownManager().set(this, 600);
                    serverWorld.playSoundFromEntity(null, attacker, SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS, 1f, 1.6f);
                    serverWorld.spawnParticles(ParticleTypes.HEART, attacker.getX() + 0.5, attacker.getY() + 1.5, attacker.getZ() + 0.5, 5, 0.1, 0.1, 0.1, 1);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}