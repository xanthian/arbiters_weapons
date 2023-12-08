package xanthian.arbiters_weapons.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import xanthian.arbiters_weapons.util.ModAttributes;

import java.util.List;
import java.util.UUID;

public class ModAxeItem extends AxeItem {
    private static final UUID CRIT_MODIFIER = UUID.fromString("9a20c4bb-fe0c-461d-808a-d01d8ae1e563");

    public ModAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings());
    }

    public float getCrit() {
        return 0f;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        String key = (stack.getTranslationKey() + ".tooltip");
        if (I18n.hasTranslation(key)) {
            String info = I18n.translate(key);
            String[] infoLines = info.split("\\r?\\n");

            for (String infoLine : infoLines) {
                tooltip.add(Text.literal(infoLine).formatted(Formatting.ITALIC, Formatting.DARK_AQUA));
            }
        } else {
            tooltip.add(Text.literal(I18n.translate(key).formatted(Formatting.ITALIC, Formatting.DARK_AQUA)));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();
        ServerWorld serverWorld = (ServerWorld) attacker.getWorld();
        float baseDamage = (float) attacker.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        float extraDamageMultiplier = 1.75F;

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
            builder.put(ModAttributes.GENERIC_CRIT_BOOST, new EntityAttributeModifier(CRIT_MODIFIER,
                    "crit Increase", getCrit(), EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return builder.build();
    }
}