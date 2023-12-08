package xanthian.arbiters_weapons.util;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xanthian.arbiters_weapons.Initialise;

public final class ModParticles {

    public static final DefaultParticleType BLEED_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType ROOT_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SOUL_EATER_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SOUL_EATER_TOTEM_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SILENCE_PARTICLE = FabricParticleTypes.simple();
    public static final DefaultParticleType SLEEP_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Initialise.MOD_ID, "bleed_particle"), BLEED_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Initialise.MOD_ID, "root_particle"), ROOT_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Initialise.MOD_ID, "soul_eater_particle"), SOUL_EATER_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Initialise.MOD_ID, "soul_eater_totem_particle"), SOUL_EATER_TOTEM_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Initialise.MOD_ID, "silence_particle"), SILENCE_PARTICLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(Initialise.MOD_ID, "sleep_particle"), SLEEP_PARTICLE);
    }
}
