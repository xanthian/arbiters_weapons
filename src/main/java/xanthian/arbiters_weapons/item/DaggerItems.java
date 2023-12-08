package xanthian.arbiters_weapons.item;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.Initialise;
import xanthian.arbiters_weapons.item.custom.ModDaggerItem;
import xanthian.arbiters_weapons.item.daggers.*;

import java.util.Map;

public class DaggerItems {

    public static Map<Identifier, Item> MOD_DAGGERS = Maps.newHashMap();

    public static final Item DAGGER = registerItem("daggers/dagger",
            new ModDaggerItem(ToolMaterials.IRON, 1, -1.8F));

    public static final Item HIDDEN_KNIFE = registerItem("daggers/hidden_knife",
            new HiddenKnife(ToolMaterials.IRON, 1, -1.6F));

    public static final Item DIRK = registerItem("daggers/dirk",
            new Dirk(ToolMaterials.IRON, 2, -1.8F));

    public static final Item EBONY_DAGGER = registerItem("daggers/ebony_dagger",
            new EbonyDagger(ToolMaterials.WOOD, 4, -1.8F));

    public static final Item TONGUESLICER = registerItem("daggers/tongueslicer",
            new Tongueslicer(ToolMaterials.IRON, 2, -1.8F));

    public static final Item TEORITE_DAGGER = registerItem("daggers/teorite_dagger",
            new TeoriteDagger(ToolMaterials.IRON, 2, -1.8F));

    public static final Item MAIN_GAUCHE = registerItem("daggers/main_gauche",
            new MainGauche(ToolMaterials.IRON, 2, -1.8F));

    public static final Item KUNAI = registerItem("daggers/kunai",
            new Kunai(ToolMaterials.IRON, 2, -1.8F));

    public static final Item JANBIYA = registerItem("daggers/janbiya",
            new Janbiya(ToolMaterials.GOLD, 4, -1.6F));

    public static final Item FLASH_KINFE = registerItem("daggers/flash_knife",
            new ModDaggerItem(ToolMaterials.IRON, 2, -1.3F));

    public static final Item WORM_TOOTH = registerItem("daggers/worm_tooth",
            new WormTooth(ToolMaterials.DIAMOND, 1, -1.8F));

    public static final Item DENDRITE_KNIFE = registerItem("daggers/dendrite_knife",
            new DendriteKnife(ToolMaterials.DIAMOND, 2, -1.8F));

    public static final Item DRAGONS_NAIL = registerItem("daggers/dragons_nail",
            new DragonsNail(ToolMaterials.NETHERITE, 2, -1.8F));

    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        MOD_DAGGERS.put(identifier, item);
        return Registry.register(Registries.ITEM, identifier, item);
    }

    public static void registerDaggerItems() {
    }
}