package xanthian.arbiters_weapons.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(value = EnvType.CLIENT)
public class BleedParticle extends SpriteBillboardParticle {

    BleedParticle(ClientWorld clientWorld, double d, double e, double f) {
        super(clientWorld, d, e, f, 0.0, 0.0, 0.0);
        this.velocityX *= 0.01f;
        this.velocityZ *= 0.01f;
        this.scale = 0.1f;
        this.maxAge = 16;
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.velocityX *= 0;
        this.velocityY = -0.05;
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
            BleedParticle bleedParticle = new BleedParticle(clientWorld, d, e + 1, f);
            bleedParticle.setSprite(this.spriteProvider);
            bleedParticle.setColor(1.0f, 1.0f, 1.0f);
            return bleedParticle;
        }
    }
}