package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class Flamebrand extends ModSwordItem {
    public Flamebrand(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        if ((!world.isClient) && (attacker.getMainHandStack().getItem() == this)) {
                if (world.random.nextFloat() < 0.20f) {
                    target.setOnFireFor(7);
                }
            }
        return super.postHit(stack, target, attacker);
    }
}
