package xanthian.arbiters_weapons.item;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.Initialise;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;
import xanthian.arbiters_weapons.item.swords.*;

import java.util.Map;

public class SwordItems {

    public static Map<Identifier, Item> MOD_SWORDS = Maps.newHashMap();

    public static final Item SHORTSWORD = registerItem("swords/shortsword",
            new ModSwordItem(ToolMaterials.IRON, 2, -2.4F));

    public static final Item LONGSWORD = registerItem("swords/longsword",
            new ModSwordItem(ToolMaterials.IRON, 3, -2.4F));

    public static final Item SILVER_SWORD = registerItem("swords/silver_sword",
            new SilverSword(ToolMaterials.IRON, 4, -2.4F));

    public static final Item TOOTHED_SWORD = registerItem("swords/toothed_sword",
            new ToothedSword(ToolMaterials.IRON, 3, -2.4F));

    public static final Item TEORITE_SWORD = registerItem("swords/teorite_sword",
            new ModSwordItem(ToolMaterials.IRON, 4, -2.4F));

    public static final Item ICEBRAND = registerItem("swords/icebrand",
            new Icebrand(ToolMaterials.IRON, 3, -2.4F));

    public static final Item FLAMEBRAND = registerItem("swords/flamebrand",
            new Flamebrand(ToolMaterials.IRON, 3, -2.4F));

    public static final Item STONEBRAND = registerItem("swords/stonebrand",
            new Stonebrand(ToolMaterials.STONE, 4, -2.4F));

    public static final Item BOLTBRAND = registerItem("swords/boltbrand",
            new Boltbrand(ToolMaterials.IRON, 3, -2.4F));

    public static final Item ENHANCER = registerItem("swords/enhancer",
            new Enhancer(ToolMaterials.IRON, 4, -2.4F));

    public static final Item EBONY_SWORD = registerItem("swords/ebony_sword",
            new EbonySword(ToolMaterials.WOOD, 4, -2.4F));

    public static final Item GUARDIAN_SWORD = registerItem("swords/guardian_sword",
            new GuardianSword(ToolMaterials.DIAMOND, 2, -2.4F));

    public static final Item DENDRITE_SWORD = registerItem("swords/dendrite_sword",
            new DendriteSword(ToolMaterials.DIAMOND, 3, -2.4F));

    public static final Item SINGING_SWORD = registerItem("swords/singing_sword",
            new SingingSword(ToolMaterials.DIAMOND, 3, -2.3F));

    public static final Item EXCALIBUR = registerItem("swords/excalibur",
            new Excalibur(ToolMaterials.DIAMOND, 4, -2.4F));

    public static final Item ETERNIAS = registerItem("swords/eternias",
            new Eternias(ToolMaterials.NETHERITE, 2, -2.2F));

    public static final Item SOUL_EATER = registerItem("swords/soul_eater",
            new SoulEater(ToolMaterials.NETHERITE, 2, -2.4F));

    public static final Item CHARGED_SOUL_EATER = registerItem("swords/charged_soul_eater",
            new ChargedSoulEater(ToolMaterials.NETHERITE, 5, -2.1F));

    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        MOD_SWORDS.put(identifier, item);
        return Registry.register(Registries.ITEM, identifier, item);
    }

    public static void registerSwordItems() {
    }
}