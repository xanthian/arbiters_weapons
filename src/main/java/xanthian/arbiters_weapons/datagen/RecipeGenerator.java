package xanthian.arbiters_weapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import xanthian.arbiters_weapons.item.SwordItems;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        CookingRecipeJsonBuilder.createSmelting(
                Ingredient.ofItems(SwordItems.SHORTSWORD, SwordItems.LONGSWORD, SwordItems.SILVER_SWORD, SwordItems.TEORITE_SWORD, SwordItems.TOOTHED_SWORD, SwordItems.ICEBRAND, SwordItems.FLAMEBRAND, SwordItems.BOLTBRAND, SwordItems.ENHANCER
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET, 0.1f, 200)
                .criterion("has_shortsword", VanillaRecipeProvider.conditionsFromItem(SwordItems.SHORTSWORD))
                .criterion("has_longsword", VanillaRecipeProvider.conditionsFromItem(SwordItems.LONGSWORD))
                .criterion("has_silver_sword", VanillaRecipeProvider.conditionsFromItem(SwordItems.SILVER_SWORD))
                .criterion("has_teorite_sword", VanillaRecipeProvider.conditionsFromItem(SwordItems.TEORITE_SWORD))
                .criterion("has_toothed_sword", VanillaRecipeProvider.conditionsFromItem(SwordItems.TOOTHED_SWORD))
                .criterion("has_icebrand", VanillaRecipeProvider.conditionsFromItem(SwordItems.ICEBRAND))
                .criterion("has_flamebrand", VanillaRecipeProvider.conditionsFromItem(SwordItems.FLAMEBRAND))
                .criterion("has_boltbrand", VanillaRecipeProvider.conditionsFromItem(SwordItems.BOLTBRAND))
                .criterion("has_enhancer", VanillaRecipeProvider.conditionsFromItem(SwordItems.ENHANCER))
                .offerTo(exporter, VanillaRecipeProvider.getSmeltingItemPath(Items.IRON_NUGGET));

    }
}