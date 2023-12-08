package xanthian.arbiters_weapons.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(value = EnvType.CLIENT)
public class SleepParticle extends SpriteBillboardParticle {
    protected SleepParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {

        super(clientWorld, d, e, f, g, h, i);
        float j;
        this.red = j = this.random.nextFloat() * 0.1f + 0.2f;
        this.green = j;
        this.blue = j;
        this.setBoundingBoxSpacing(0.02f, 0.02f);
        this.scale *= this.random.nextFloat() * 0.6f + 0.5f;
        this.velocityX *= 0.2f;
        this.velocityY *= 0.2f;
        this.velocityZ *= 0.2f;
        this.maxAge = (int) (20.0 / (Math.random() * 0.8 + 0.2));
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
        if (this.maxAge-- <= 10) {
            this.markDead();
            return;
        }
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.velocityX *= 0.99;
        this.velocityY *= 0.99;
        this.velocityZ *= 0.99;
    }

    @Environment(value = EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            SleepParticle sleepParticle = new SleepParticle(clientWorld, d, e, f, g, h, i);
            sleepParticle.setSprite(this.spriteProvider);
            sleepParticle.setColor(1.0f, 1.0f, 1.0f);
            return sleepParticle;
        }
    }
}