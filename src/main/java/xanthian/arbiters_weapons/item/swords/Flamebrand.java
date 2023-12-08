package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class Flamebrand extends ModSwordItem {
    public Flamebrand(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this) {
            if (world.random.nextFloat() < 0.20f) {
                target.setOnFireFor(7);
                serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.PLAYERS, 0.9f, 1.7f);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
