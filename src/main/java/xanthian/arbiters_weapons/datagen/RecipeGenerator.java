package xanthian.arbiters_weapons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import xanthian.arbiters_weapons.item.AxeItems;
import xanthian.arbiters_weapons.item.DaggerItems;
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
                .offerTo(exporter, VanillaRecipeProvider.getSmeltingItemPath(Items.IRON_NUGGET) + "_swords");

        CookingRecipeJsonBuilder.createBlasting(
                        Ingredient.ofItems(SwordItems.SHORTSWORD, SwordItems.LONGSWORD, SwordItems.SILVER_SWORD, SwordItems.TEORITE_SWORD, SwordItems.TOOTHED_SWORD, SwordItems.ICEBRAND, SwordItems.FLAMEBRAND, SwordItems.BOLTBRAND, SwordItems.ENHANCER
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET, 0.1f, 100)
                .criterion("has_shortsword", VanillaRecipeProvider.conditionsFromItem(SwordItems.SHORTSWORD))
                .criterion("has_longsword", VanillaRecipeProvider.conditionsFromItem(SwordItems.LONGSWORD))
                .criterion("has_silver_sword", VanillaRecipeProvider.conditionsFromItem(SwordItems.SILVER_SWORD))
                .criterion("has_teorite_sword", VanillaRecipeProvider.conditionsFromItem(SwordItems.TEORITE_SWORD))
                .criterion("has_toothed_sword", VanillaRecipeProvider.conditionsFromItem(SwordItems.TOOTHED_SWORD))
                .criterion("has_icebrand", VanillaRecipeProvider.conditionsFromItem(SwordItems.ICEBRAND))
                .criterion("has_flamebrand", VanillaRecipeProvider.conditionsFromItem(SwordItems.FLAMEBRAND))
                .criterion("has_boltbrand", VanillaRecipeProvider.conditionsFromItem(SwordItems.BOLTBRAND))
                .criterion("has_enhancer", VanillaRecipeProvider.conditionsFromItem(SwordItems.ENHANCER))
                .offerTo(exporter, VanillaRecipeProvider.getBlastingItemPath(Items.IRON_NUGGET) + "_swords");

        CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItems(DaggerItems.DAGGER, DaggerItems.HIDDEN_KNIFE, DaggerItems.DIRK, DaggerItems.TEORITE_DAGGER, DaggerItems.TONGUESLICER, DaggerItems.MAIN_GAUCHE, DaggerItems.KUNAI, DaggerItems.FLASH_KINFE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET, 0.1f, 200)
                .criterion("has_dagger", VanillaRecipeProvider.conditionsFromItem(DaggerItems.DAGGER))
                .criterion("has_hidden_knife", VanillaRecipeProvider.conditionsFromItem(DaggerItems.HIDDEN_KNIFE))
                .criterion("has_dirk", VanillaRecipeProvider.conditionsFromItem(DaggerItems.DIRK))
                .criterion("has_teorite_dagger", VanillaRecipeProvider.conditionsFromItem(DaggerItems.TEORITE_DAGGER))
                .criterion("has_main_gauche", VanillaRecipeProvider.conditionsFromItem(DaggerItems.MAIN_GAUCHE))
                .criterion("has_tongueslicer", VanillaRecipeProvider.conditionsFromItem(DaggerItems.TONGUESLICER))
                .criterion("has_kunai", VanillaRecipeProvider.conditionsFromItem(DaggerItems.KUNAI))
                .criterion("has_flash_knife", VanillaRecipeProvider.conditionsFromItem(DaggerItems.FLASH_KINFE))
                .offerTo(exporter, VanillaRecipeProvider.getSmeltingItemPath(Items.IRON_NUGGET) + "_daggers");

        CookingRecipeJsonBuilder.createBlasting(
                        Ingredient.ofItems(DaggerItems.DAGGER, DaggerItems.HIDDEN_KNIFE, DaggerItems.DIRK, DaggerItems.TEORITE_DAGGER, DaggerItems.TONGUESLICER, DaggerItems.MAIN_GAUCHE, DaggerItems.KUNAI, DaggerItems.FLASH_KINFE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET, 0.1f, 100)
                .criterion("has_dagger", VanillaRecipeProvider.conditionsFromItem(DaggerItems.DAGGER))
                .criterion("has_hidden_knife", VanillaRecipeProvider.conditionsFromItem(DaggerItems.HIDDEN_KNIFE))
                .criterion("has_dirk", VanillaRecipeProvider.conditionsFromItem(DaggerItems.DIRK))
                .criterion("has_teorite_dagger", VanillaRecipeProvider.conditionsFromItem(DaggerItems.TEORITE_DAGGER))
                .criterion("has_main_gauche", VanillaRecipeProvider.conditionsFromItem(DaggerItems.MAIN_GAUCHE))
                .criterion("has_tongueslicer", VanillaRecipeProvider.conditionsFromItem(DaggerItems.TONGUESLICER))
                .criterion("has_kunai", VanillaRecipeProvider.conditionsFromItem(DaggerItems.KUNAI))
                .criterion("has_flash_knife", VanillaRecipeProvider.conditionsFromItem(DaggerItems.FLASH_KINFE))
                .offerTo(exporter, VanillaRecipeProvider.getBlastingItemPath(Items.IRON_NUGGET) + "_daggers");

        CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItems(AxeItems.BATTLEAXE, AxeItems.SILVER_AXE, AxeItems.CHOPPER, AxeItems.TEORITE_AXE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET, 0.1f, 200)
                .criterion("has_battleaxe", VanillaRecipeProvider.conditionsFromItem(AxeItems.BATTLEAXE))
                .criterion("has_silver_axe", VanillaRecipeProvider.conditionsFromItem(AxeItems.SILVER_AXE))
                .criterion("has_chopper", VanillaRecipeProvider.conditionsFromItem(AxeItems.CHOPPER))
                .criterion("has_teorite_axe", VanillaRecipeProvider.conditionsFromItem(AxeItems.TEORITE_AXE))
                .offerTo(exporter, VanillaRecipeProvider.getSmeltingItemPath(Items.IRON_NUGGET) + "_axes");

        CookingRecipeJsonBuilder.createBlasting(
                        Ingredient.ofItems(AxeItems.BATTLEAXE, AxeItems.SILVER_AXE, AxeItems.CHOPPER, AxeItems.TEORITE_AXE
                        ),
                        RecipeCategory.MISC,
                        Items.IRON_NUGGET, 0.1f, 100)
                .criterion("has_battleaxe", VanillaRecipeProvider.conditionsFromItem(AxeItems.BATTLEAXE))
                .criterion("has_silver_axe", VanillaRecipeProvider.conditionsFromItem(AxeItems.SILVER_AXE))
                .criterion("has_chopper", VanillaRecipeProvider.conditionsFromItem(AxeItems.CHOPPER))
                .criterion("has_teorite_axe", VanillaRecipeProvider.conditionsFromItem(AxeItems.TEORITE_AXE))
                .offerTo(exporter, VanillaRecipeProvider.getBlastingItemPath(Items.IRON_NUGGET) + "_axes");

        CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItems(DaggerItems.JANBIYA, AxeItems.ORNATE_AXE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET, 0.1f, 200)
                .criterion("has_janbiya", VanillaRecipeProvider.conditionsFromItem(DaggerItems.JANBIYA))
                .criterion("has_ornate_axe", VanillaRecipeProvider.conditionsFromItem(AxeItems.ORNATE_AXE))
                .offerTo(exporter, VanillaRecipeProvider.getSmeltingItemPath(Items.GOLD_NUGGET));

        CookingRecipeJsonBuilder.createBlasting(
                        Ingredient.ofItems(DaggerItems.JANBIYA, AxeItems.ORNATE_AXE
                        ),
                        RecipeCategory.MISC,
                        Items.GOLD_NUGGET, 0.1f, 100)
                .criterion("has_janbiya", VanillaRecipeProvider.conditionsFromItem(DaggerItems.JANBIYA))
                .criterion("has_ornate_axe", VanillaRecipeProvider.conditionsFromItem(AxeItems.ORNATE_AXE))
                .offerTo(exporter, VanillaRecipeProvider.getBlastingItemPath(Items.GOLD_NUGGET));

    }
}