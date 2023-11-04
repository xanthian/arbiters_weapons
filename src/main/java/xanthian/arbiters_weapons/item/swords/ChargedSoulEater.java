package xanthian.arbiters_weapons.item.swords;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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

public class ChargedSoulEater extends ModSwordItem {
    public ChargedSoulEater(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed);
    }

    public float getCrit() {
        return 0.16f;
    }

    private static final UUID CRIT_MODIFIER = UUID.fromString("0c0adf29-f916-4336-b69c-78dca42332ee");
    private static final UUID GENERIC_ARMOR = UUID.fromString("3c2851a4-d6f0-4dac-8c4c-dba52e73d667");

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();

        if ((!world.isClient) && (attacker.getMainHandStack().getItem() == this)) {
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
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getAttributeModifiers(slot);
        builder.putAll(modifiers);
        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(ModAttributes.GENERIC_CRIT_BOOST,
                    new EntityAttributeModifier(CRIT_MODIFIER, "crit Increase", getCrit(),
                            EntityAttributeModifier.Operation.MULTIPLY_BASE));
            builder.put(EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(GENERIC_ARMOR, "armor Increase", 5F,
                            EntityAttributeModifier.Operation.ADDITION));
        }
        return builder.build();
    }
}
