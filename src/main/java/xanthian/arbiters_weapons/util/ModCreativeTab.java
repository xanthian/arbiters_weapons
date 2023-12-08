package xanthian.arbiters_weapons.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.Initialise;
import xanthian.arbiters_weapons.item.SwordItems;

import java.util.Comparator;

public class ModCreativeTab {

    public static final ItemGroup AW_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Initialise.MOD_ID, "arbiters_weapons"),
            FabricItemGroup.builder().displayName(Text.literal("Arbiters Weapons"))
                    .icon(() -> new ItemStack(SwordItems.CHARGED_SOUL_EATER)).entries((displayContext, entries) -> {
                        entries.addAll(Registries.ITEM.getIds().stream()
                                .filter(identifier -> identifier.getNamespace().matches(Initialise.MOD_ID))
                                .sorted(Comparator.comparing(Identifier::getPath))
                                .map(Registries.ITEM::get)
                                .map(ItemStack::new)
                                .filter(input -> !input.isEmpty())
                                .toList());
                    })
                    .build());

    public static void registerGroup() {
    }
}