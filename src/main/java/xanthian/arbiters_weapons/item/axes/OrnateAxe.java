package xanthian.arbiters_weapons.item.axes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModAxeItem;

public class OrnateAxe extends ModAxeItem {
    public OrnateAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity && livingEntity.getMainHandStack().getItem() == this) {
            if (livingEntity.age % 60 == 0) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,
                        80, 0, true, false, true));
            }
        }
    }
}
