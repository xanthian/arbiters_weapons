package xanthian.arbiters_weapons.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(value = EnvType.CLIENT)
public class SoulEaterTotemParticle extends AnimatedParticle {

    SoulEaterTotemParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, spriteProvider, 1.25f);
        this.velocityMultiplier = 0.96f;
        this.velocityX = velocityX;
        this.velocityY = -velocityY;
        this.velocityZ = velocityZ;
        this.scale *= 1.5f;
        this.maxAge = (int) (8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.setSpriteForAge(spriteProvider);
    }

    @Environment(value = EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new SoulEaterTotemParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
        }
    }
}