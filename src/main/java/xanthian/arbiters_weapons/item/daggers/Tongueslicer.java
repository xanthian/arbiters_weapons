package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;
import xanthian.arbiters_weapons.util.ModStatusEffects;

import java.util.Arrays;
import java.util.List;

public class Tongueslicer extends ModDaggerItem {
    List<EntityType<?>> validTypes = Arrays.asList(
            EntityType.GHAST,
            EntityType.BLAZE,
            EntityType.GUARDIAN,
            EntityType.EVOKER,
            EntityType.ENDERMAN
    );

    public Tongueslicer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        Item offHand = attacker.getOffHandStack().getItem();

        if (!world.isClient && (mainHand == this || offHand == this)) {
            if (world.random.nextFloat() <= 0.62f) {
                if (validTypes.contains(target.getType())) {
                    StatusEffectInstance silence = target.getStatusEffect(ModStatusEffects.SILENCE);
                    if (silence == null || silence.getDuration() < 10) {
                        target.addStatusEffect(new StatusEffectInstance(ModStatusEffects.SILENCE,
                                200, 0, true, false, true), target);
                    }
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}