package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class SilverSword extends ModSwordItem {
    public SilverSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float damage = world.random.nextFloat() * (4 - 2) + 2;

        if (!world.isClient && mainHand == this && target.isUndead()) {

            target.damage(target.getWorld().getDamageSources().magic(), baseDamage + damage);
            serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.PLAYERS, 0.2f, 2.7f);
        }
        return super.postHit(stack, target, attacker);
    }
}
