package xanthian.arbiters_weapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.item.SwordItems;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final TagKey<Item> C_SWORDS = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:swords"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        for (Item sword : SwordItems.MOD_SWORDS.values()) {

            getOrCreateTagBuilder(ItemTags.SWORDS)
                    .add(sword);

            getOrCreateTagBuilder(C_SWORDS)
                    .add(sword);
        }
    }
}
