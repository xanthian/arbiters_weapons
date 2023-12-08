package xanthian.arbiters_weapons.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xanthian.arbiters_weapons.util.ModStatusEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    // Silence Status effect
    @Inject(at = @At("HEAD"), method = "canTarget(Lnet/minecraft/entity/LivingEntity;)Z", cancellable = true)
    private void pacifyMob(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity thisEntity = ((LivingEntity) (Object) this);
        if (thisEntity.hasStatusEffect(ModStatusEffects.SILENCE)) {
            cir.setReturnValue(false);
        }
    }
}