package xanthian.arbiters_weapons.item.swords;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;

public class Boltbrand extends ModSwordItem {
    public Boltbrand(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();

        if (!world.isClient && mainHand == this) {
            if (world.random.nextFloat() <= 0.2f) {
                LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
                if (lightning != null) {

                    lightning.setPos(target.getX(), target.getY(), target.getZ());
                    world.spawnEntity(lightning);

                }
            }
        }
        return super.postHit(stack, target, attacker);
    }
}