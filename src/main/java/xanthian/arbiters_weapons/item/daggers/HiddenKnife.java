package xanthian.arbiters_weapons.item.daggers;

import net.minecraft.item.ToolMaterial;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;

public class HiddenKnife extends ModDaggerItem {
    public HiddenKnife(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    @Override
    public float getCrit() {
        return 0.05F;
    }
}