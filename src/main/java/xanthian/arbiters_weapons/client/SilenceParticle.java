package xanthian.arbiters_weapons.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(value = EnvType.CLIENT)
public class SilenceParticle extends SpriteBillboardParticle {

    SilenceParticle(ClientWorld clientWorld, double d, double e, double f) {
        super(clientWorld, d, e, f, 0.0, 0.0, 0.0);
        this.velocityX *= 0.01f;
        this.velocityZ *= 0.01f;
        this.scale = 0.15f;
        this.maxAge = 20;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.setBoundingBox(this.getBoundingBox().offset(dx, dy, dz));
        this.repositionFromBoundingBox();
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.velocityX *= 0;
        this.velocityY = -0.005;
        this.velocityZ *= 0;
        if (this.maxAge-- <= 5) {
            this.markDead();
        }
    }

    @Environment(value = EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            SilenceParticle silenceParticle = new SilenceParticle(clientWorld, d, e + 1, f);
            silenceParticle.setSprite(this.spriteProvider);
            silenceParticle.setColor(1.0f, 1.0f, 1.0f);
            return silenceParticle;
        }
    }
}