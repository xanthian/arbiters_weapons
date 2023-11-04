package xanthian.arbiters_weapons.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import xanthian.arbiters_weapons.util.ModParticles;
import xanthian.arbiters_weapons.util.ModTotemEffect;

public class ArbitersWeaponsClient implements ClientModInitializer {

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {

        this.registerParticleFactories();
        this.registerTotemPacket();
    }

    private void registerParticleFactories() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.SOUL_EATER_PARTICLE, SoulEaterParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SOUL_EATER_TOTEM_PARTICLE, SoulEaterTotemParticle.Factory::new);
    }
    private void registerTotemPacket() {
        ClientPlayNetworking.registerGlobalReceiver(ModTotemEffect.TOTEM_EFFECT_PACKET, (client, handler, buf, responseSender) -> {
            ItemStack itemStack = buf.readItemStack();
            assert client.world != null;
            Entity entity = client.world.getEntityById(buf.readInt());
                client.execute(() -> ModTotemEffect.playActivateAnimation(itemStack, entity, ModParticles.SOUL_EATER_TOTEM_PARTICLE));
        });
    }
}