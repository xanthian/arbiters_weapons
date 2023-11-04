package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class EbonySword extends ModSwordItem {
    public EbonySword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && (entity instanceof LivingEntity livingEntity) && (livingEntity.getMainHandStack().getItem() == this)) {

                if (livingEntity.hasStatusEffect(StatusEffects.BLINDNESS)) {

                    livingEntity.removeStatusEffect(StatusEffects.BLINDNESS);

            }
        }
    }
}