package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;

public class MainGauche extends ModDaggerItem {
    public MainGauche(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.UNCOMMON;
    }

    @Override
    public float getCrit() {
        return 0;
    }
}