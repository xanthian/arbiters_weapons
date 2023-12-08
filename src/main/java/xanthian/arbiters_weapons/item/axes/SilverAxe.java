package xanthian.arbiters_weapons.item.axes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModAxeItem;

public class SilverAxe extends ModAxeItem {
    public SilverAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);

        if (!world.isClient && mainHand == this && target.isUndead()) {
            if (world.random.nextFloat() <= 0.2f) {
                target.damage(target.getWorld().getDamageSources().generic(), baseDamage + 6);
                serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.PLAYERS, 0.9f, 0.7f);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}