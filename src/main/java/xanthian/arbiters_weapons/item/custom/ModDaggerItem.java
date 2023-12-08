package xanthian.arbiters_weapons.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
import net.minecraft.world.World;
import xanthian.arbiters_weapons.util.ModAttributes;

import java.util.UUID;

public class ModDaggerItem extends ModWeapon {
    private static final UUID CRIT_MODIFIER = UUID.fromString("baebc2be-725a-4653-a795-4b1914cc7651");

    public ModDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings());
    }

    public float getCrit() {
        return 0.02f;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float extraDamageMultiplier = 1.5F;

        if (!world.isClient && attacker.getMainHandStack().getItem() == this) {
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
            builder.put(ModAttributes.GENERIC_CRIT_BOOST, new EntityAttributeModifier(CRIT_MODIFIER, "crit Increase", getCrit(), EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return builder.build();
    }
}