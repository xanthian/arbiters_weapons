package xanthian.arbiters_weapons.item;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.Initialise;
import xanthian.arbiters_weapons.item.axes.*;
import xanthian.arbiters_weapons.item.custom.ModAxeItem;

import java.util.Map;

public class AxeItems {

    public static Map<Identifier, Item> MOD_AXES = Maps.newHashMap();

    public static final Item BATTLEAXE = registerItem("axes/battleaxe",
            new ModAxeItem(ToolMaterials.IRON, 6, -3.1F));

    public static final Item SILVER_AXE = registerItem("axes/silver_axe",
            new SilverAxe(ToolMaterials.IRON, 6, -3.1F));

    public static final Item CHOPPER = registerItem("axes/chopper",
            new ModAxeItem(ToolMaterials.IRON, 6, -3.1F));

    public static final Item TEORITE_AXE = registerItem("axes/teorite_axe",
            new TeoriteAxe(ToolMaterials.IRON, 6, -3.1F));

    public static final Item BLOOD_AXE = registerItem("axes/blood_axe",
            new BloodAxe(ToolMaterials.DIAMOND, 5, -3.1F));

    public static final Item MARAUDER_AXE = registerItem("axes/marauder_axe",
            new ModAxeItem(ToolMaterials.DIAMOND, 5, -3F));

    public static final Item ORNATE_AXE = registerItem("axes/ornate_axe",
            new OrnateAxe(ToolMaterials.GOLD, 8, -3.1F));

    public static final Item DARK_REIGN = registerItem("axes/dark_reign",
            new DarkReign(ToolMaterials.DIAMOND, 5, -3F));

    public static final Item EXECUTIONER = registerItem("axes/executioner",
            new ModAxeItem(ToolMaterials.DIAMOND, 8, -3.2F));

    public static final Item CRY_HAVOC = registerItem("axes/cry_havoc",
            new CryHavoc(ToolMaterials.NETHERITE, 6, -2.8F));

    private static Item registerItem(String name, Item item) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        MOD_AXES.put(identifier, item);
        return Registry.register(Registries.ITEM, new Identifier(Initialise.MOD_ID, name), item);
    }

    public static void registerAxeItems() {
    }
}