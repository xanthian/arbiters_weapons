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

public class DarkReign extends ModAxeItem {

    public DarkReign(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);

    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        float damage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float damageAdd;

        if (!world.isClient && mainHand == this && world.isNight()) {

            if (world.random.nextFloat() <= 0.025f) {
                damageAdd = world.random.nextFloat() * (2.5f - 1.75f) + 1.75f;
            } else {
                damageAdd = world.random.nextFloat() * (1.75f - 1.25f) + 1.25f;
            }
            target.damage(world.getDamageSources().generic(), (damage * damageAdd));
            serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, SoundCategory.PLAYERS, 0.9f, 0.7f);
        }
        return super.postHit(stack, target, attacker);
    }
}