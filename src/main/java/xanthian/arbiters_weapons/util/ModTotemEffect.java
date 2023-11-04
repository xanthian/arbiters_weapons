package xanthian.arbiters_weapons.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import xanthian.arbiters_weapons.Initialise;

public final class ModTotemEffect {

    public static final Identifier TOTEM_EFFECT_PACKET = new Identifier(Initialise.MOD_ID, "totem_effect_packet");

    public static void sendTotemEffectPacket(ItemStack itemStack, LivingEntity livingEntity) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeItemStack(itemStack);
        buf.writeInt(livingEntity.getId());

        if (livingEntity instanceof ServerPlayerEntity player) {
            ServerPlayNetworking.send(player, TOTEM_EFFECT_PACKET, buf);
        }

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) livingEntity.getEntityWorld(), livingEntity.getBlockPos())) {
            ServerPlayNetworking.send(player, TOTEM_EFFECT_PACKET, buf);
        }
    }

    public static void playActivateAnimation(ItemStack itemStack, Entity entity, ParticleEffect particleEffect) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        minecraftClient.particleManager.addEmitter(entity, particleEffect, 30);

        ClientWorld clientWorld = minecraftClient.world;

        if (clientWorld != null) {
            clientWorld.playSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ITEM_TOTEM_USE, entity.getSoundCategory(), 1.0f, 1.0f, false);
        }

        if (entity == minecraftClient.player) {
            minecraftClient.gameRenderer.showFloatingItem(itemStack);
        }
    }
}