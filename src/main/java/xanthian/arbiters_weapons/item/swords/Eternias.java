package xanthian.arbiters_weapons.item.swords;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.item.custom.ModSwordItem;
import xanthian.arbiters_weapons.util.ModAttributes;

import java.util.UUID;


public class Eternias extends ModSwordItem {
    private static final UUID CRIT_MODIFIER = UUID.fromString("ce8b4b62-9c99-42a1-ad84-addcccea40d8");

    public Eternias(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    public float getCrit() {
        return 0.1F;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.UNCOMMON;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof LivingEntity livingEntity && livingEntity.getMainHandStack().getItem() == this) {
            if (livingEntity.age % 60 == 0) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,
                        80, 0, true, false, true));

            }
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        Item mainHand = attacker.getMainHandStack().getItem();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float extraDamageMultiplier = 1.5F;

        if (!world.isClient && mainHand == this) {
            if (world.random.nextFloat() <= this.getCrit()) {

                target.damage(world.getDamageSources().generic(), (baseDamage * extraDamageMultiplier));
                serverWorld.playSoundFromEntity(null, target, SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 1f, 1.2f);
                serverWorld.getChunkManager().sendToNearbyPlayers(target, new EntityAnimationS2CPacket(target, EntityAnimationS2CPacket.CRIT));
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getAttributeModifiers(slot);
        builder.putAll(modifiers);
        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(ModAttributes.GENERIC_CRIT_BOOST, new EntityAttributeModifier(CRIT_MODIFIER, "crit increase", this.getCrit(),
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return builder.build();
    }
}