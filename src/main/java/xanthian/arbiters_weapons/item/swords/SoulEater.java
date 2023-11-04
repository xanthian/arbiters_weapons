package xanthian.arbiters_weapons.item.swords;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import xanthian.arbiters_weapons.item.SwordItems;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;
import xanthian.arbiters_weapons.util.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SoulEater extends ModSwordItem {

    private static final String KILL_COUNT_NBT_KEY = "KillCount";

    public float getCrit() {
        return 0.01f;
    }

    public SoulEater(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);

    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int killCount = getKillCount(stack);
        tooltip.add(Text.literal("Kill Count: " + killCount).formatted(Formatting.DARK_RED));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();

        if (!world.isClient && attacker.getMainHandStack().getItem() == this) {
            if (world.random.nextFloat() <= this.getCrit()) {

                float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                float extraDamageMultiplier = 1.5F;
                target.damage(world.getDamageSources().generic(), (baseDamage * extraDamageMultiplier));
                world.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                        SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1f, 1.2f);

                if (world instanceof ServerWorld serverWorld) {
                    serverWorld.getChunkManager().sendToNearbyPlayers(target, new EntityAnimationS2CPacket(target, EntityAnimationS2CPacket.CRIT));
                }
            }

            if (target.isDead()) {

                int killCount = getKillCount(stack);
                killCount++;
                setKillCount(stack, killCount);
                if (world instanceof ServerWorld serverWorld) {
                    for (int i = 0; i < 5; i++) {
                        double angle = Math.random() * 360;
                        double radius = 1;
                        double px = target.getX() + Math.cos(Math.toRadians(angle)) * radius;
                        double py = target.getY() + 1.5;
                        double pz = target.getZ() + Math.sin(Math.toRadians(angle)) * radius;
                        serverWorld.spawnParticles(ModParticles.SOUL_EATER_PARTICLE,
                                px, py, pz, 10, 1, 1, 1, 0);

                    }
                }
            }
        }
        return super.postHit(stack,target,attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if(world instanceof ServerWorld) {
            int killCount = getKillCount(stack);
            if (killCount >= 2) {
                ItemStack oldSword = player.getMainHandStack();
                ItemStack newSword = new ItemStack(SwordItems.CHARGED_SOUL_EATER);
                Map<Enchantment, Integer> enchants = EnchantmentHelper.get(oldSword);
                EnchantmentHelper.set(enchants, newSword);
                oldSword.decrement(1);
                player.setStackInHand(Hand.MAIN_HAND, newSword);

                ModTotemEffect.sendTotemEffectPacket(SwordItems.CHARGED_SOUL_EATER.getDefaultStack(), player);
                //ModTotemEffect.playActivateAnimation(SwordItems.SOUL_EATER.getDefaultStack(),player, ModParticles.SOUL_EATER_TOTEM_PARTICLE);

                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private int getKillCount(ItemStack stack) {
        NbtCompound tag = stack.getOrCreateNbt();
        return tag.getInt(KILL_COUNT_NBT_KEY);
    }

    private void setKillCount(ItemStack stack, int killCount) {
        NbtCompound tag = stack.getOrCreateNbt();
        tag.putInt(KILL_COUNT_NBT_KEY, killCount);
    }

    private static final UUID CRIT_MODIFIER = UUID.fromString("7c9810b4-069a-436c-a1af-8a13b5ebf3af");

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.RARE;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getAttributeModifiers(slot);
        builder.putAll(modifiers);
        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(ModAttributes.GENERIC_CRIT_BOOST,
                    new EntityAttributeModifier(CRIT_MODIFIER, "crit Increase", getCrit(),
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return builder.build();
    }
}