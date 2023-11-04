package xanthian.arbiters_weapons.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(value= EnvType.CLIENT)
public class SoulEaterParticle extends AbstractSlowingParticle {

    private final SpriteProvider spriteProvider;

    SoulEaterParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.spriteProvider = spriteProvider;
        this.velocityMultiplier = 0.6f;
        this.velocityX = velocityX;
        this.velocityY = -velocityY;
        this.velocityZ = velocityZ;
        this.scale *= 1.5f;
        this.maxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteForAge(this.spriteProvider);
    }

    @Environment(value = EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {

        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            SoulEaterParticle soulParticle = new SoulEaterParticle(clientWorld, d, e, f, g, h, i, this.spriteProvider);
            soulParticle.setAlpha(1.0f);
            return soulParticle;
        }
    }
    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
}