package xanthian.arbiters_weapons;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import xanthian.arbiters_weapons.item.SwordItems;
import xanthian.arbiters_weapons.util.*;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "arbiters_weapons";

    public static Identifier id(String key) {
        return new Identifier(MOD_ID, key);
    }

    @Override
    public void onInitialize() {

        ModAttributes.registerAttributes();
        ModStatusEffects.registerStatusEffects();
        SwordItems.registerSwordItems();
        ModCreativeTab.registerGroup();
        ModParticles.registerParticles();
        ModLootTables.modifyLootTables();

    }
}
