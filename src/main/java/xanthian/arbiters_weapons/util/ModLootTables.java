package xanthian.arbiters_weapons.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetDamageLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.item.SwordItems;

public class ModLootTables {

    public static final Identifier ABANDONED_MINESHAFT_ID = new Identifier("minecraft", "chests/abandoned_mineshaft");
    public static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft", "chests/ancient_city");
    public static final Identifier BASTION_TREASURE_ID = new Identifier("minecraft", "chests/bastion_treasure");
    public static final Identifier DESERT_PYRAMID_ID = new Identifier("minecraft", "chests/desert_pyramid");
    public static final Identifier END_CITY_TREASURE_ID = new Identifier("minecraft", "chests/end_city_treasure");
    public static final Identifier IGLOO_CHEST_ID = new Identifier("minecraft", "chests/igloo_chest");
    public static final Identifier NETHER_BRIDGE_ID = new Identifier("minecraft", "chests/nether_bridge");
    public static final Identifier PILLAGER_OUTPOST_ID = new Identifier("minecraft", "chests/pillager_outpost");
    public static final Identifier RUINED_PORTAL_ID = new Identifier("minecraft", "chests/ruined_portal");
    public static final Identifier SHIPWRECK_TREASURE_ID = new Identifier("minecraft", "chests/shipwreck_treasure");
    public static final Identifier WOODLAND_MANSION_ID = new Identifier("minecraft", "chests/woodland_mansion");

    public static final Identifier FISHING_TREASURE_ID = new Identifier("minecraft", "gameplay/fishing/treasure");

    public static final Identifier BLAZE_ID = new Identifier("minecraft", "entities/blaze");
    public static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");
    public static final Identifier ENDER_DRAGON_ID = new Identifier("minecraft", "entities/ender_dragon");
    public static final Identifier GUARDIAN_ID = new Identifier("minecraft", "entities/guardian");
    public static final Identifier ELDER_GUARDIAN_ID = new Identifier("minecraft", "entities/elder_guardian");
    public static final Identifier STRAY_ID = new Identifier("minecraft", "entities/stray");
    public static final Identifier WARDEN_ID = new Identifier("minecraft", "entities/warden");
    public static final Identifier WITHER_SKELETON_ID = new Identifier("minecraft", "entities/wither_skeleton");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (ABANDONED_MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(SwordItems.SHORTSWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (FISHING_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(SwordItems.SHORTSWORD))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.0f, 0.25f)))
                        .apply(EnchantWithLevelsLootFunction.builder(ConstantLootNumberProvider.create(30.0f))
                                .allowTreasureEnchantments());
                tableBuilder.pool(poolBuilder.build());
            }

            if (ABANDONED_MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(SwordItems.LONGSWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (FISHING_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(SwordItems.LONGSWORD))
                        .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.0f, 0.25f)))
                        .apply(EnchantWithLevelsLootFunction.builder(ConstantLootNumberProvider.create(30.0f))
                                .allowTreasureEnchantments());
                tableBuilder.pool(poolBuilder.build());
            }

            if (ABANDONED_MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(SwordItems.TOOTHED_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }
            if (WOODLAND_MANSION_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(SwordItems.TOOTHED_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }

            if (STRAY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 0.01f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.ICEBRAND));
                tableBuilder.pool(poolBuilder.build());
            }
            if (IGLOO_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(SwordItems.ICEBRAND));
                tableBuilder.pool(poolBuilder.build());
            }

            if (NETHER_BRIDGE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.075f))
                        .with(ItemEntry.builder(SwordItems.FLAMEBRAND));
                tableBuilder.pool(poolBuilder.build());
            }
            if (BLAZE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.03f, 0.01f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.FLAMEBRAND));
                tableBuilder.pool(poolBuilder.build());
            }

            if (WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.05f, 0.01f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.STONEBRAND));
                tableBuilder.pool(poolBuilder.build());
            }
            if (DESERT_PYRAMID_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(SwordItems.STONEBRAND));
                tableBuilder.pool(poolBuilder.build());
            }

            if (CREEPER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .conditionally(WeatherCheckLootCondition.create().thundering(true))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.BOLTBRAND));
                tableBuilder.pool(poolBuilder.build());
            }

            if (RUINED_PORTAL_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(SwordItems.ENHANCER));
                tableBuilder.pool(poolBuilder.build());
            }
            if (ENDER_DRAGON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.5f, 0.1f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.ENHANCER));
                tableBuilder.pool(poolBuilder.build());
            }

            if (PILLAGER_OUTPOST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(SwordItems.EBONY_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }
            if (PILLAGER_OUTPOST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.50f))
                        .conditionally(TimeCheckLootCondition.create(BoundedIntUnaryOperator.create(12000, 24000)).period(24000))
                        .with(ItemEntry.builder(SwordItems.EBONY_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }

            if (GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.02f, 0.01f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.GUARDIAN_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }
            if (ELDER_GUARDIAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 0.01f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.GUARDIAN_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }

            if (END_CITY_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(SwordItems.DENDRITE_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(SwordItems.DENDRITE_SWORD));
                tableBuilder.pool(poolBuilder.build());
            }

            if (SHIPWRECK_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(SwordItems.EXCALIBUR));
                tableBuilder.pool(poolBuilder.build());
            }
            if (END_CITY_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(SwordItems.EXCALIBUR));
                tableBuilder.pool(poolBuilder.build());
            }

            if (SHIPWRECK_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(SwordItems.ETERNIAS));
                tableBuilder.pool(poolBuilder.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(SwordItems.ETERNIAS));
                tableBuilder.pool(poolBuilder.build());
            }

            if (BASTION_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(SwordItems.SOUL_EATER));
                tableBuilder.pool(poolBuilder.build());
            }
            if (WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.1f, 0.05f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(SwordItems.SOUL_EATER));
                tableBuilder.pool(poolBuilder.build());
            }

        }));
    }
}
