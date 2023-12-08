package xanthian.arbiters_weapons.item.axes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;
import xanthian.arbiters_weapons.item.custom.ModAxeItem;

public class CryHavoc extends ModAxeItem {
    public CryHavoc(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.UNCOMMON;
    }

    @Override
    public float getCrit() {
        return 0.03F;
    }
}