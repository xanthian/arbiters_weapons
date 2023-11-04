package xanthian.arbiters_weapons.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import xanthian.arbiters_weapons.Initialise;
import xanthian.arbiters_weapons.statuseffects.*;


public class ModStatusEffects {

    public static final StatusEffect BERSERK = new BerserkStatusEffect();
    public static final StatusEffect BLEED = new BleedStatusEffect();
    public static final StatusEffect CHARM = new CharmedStatusEffect();
    public static final StatusEffect DEF_DOWN = new DefenceDownEffect();
    public static final StatusEffect FREEZE = new FrozenStatusEffect();
    public static final StatusEffect REBIRTH = new RebirthStatusEffect();
    public static final StatusEffect ROOT = new RootStatusEffect();
    public static final StatusEffect SILENCE = new SilenceStatusEffect();
    public static final StatusEffect SLEEP = new SleepStatusEffect();
    public static final StatusEffect THORNS = new ThornsStatusEffect();

    public static void registerStatusEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "berserk"), BERSERK);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "bleed"), BLEED);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "charm"), CHARM);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "def_down"), DEF_DOWN);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "freeze"), FREEZE);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "rebirth"), REBIRTH);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "root"), ROOT);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "silence"), SILENCE);
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "sleep"), SLEEP);

        Registry.register(Registries.STATUS_EFFECT, new Identifier(Initialise.MOD_ID, "thorns"), THORNS);
    }
}
