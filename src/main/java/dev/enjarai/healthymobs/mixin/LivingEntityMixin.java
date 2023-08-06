package dev.enjarai.healthymobs.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.enjarai.healthymobs.HealthyMobs.LESS_HEALTHY;
import static dev.enjarai.healthymobs.HealthyMobs.MORE_HEALTHY;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract void heal(float amount);

    @SuppressWarnings("ConstantValue")
    @Inject(
            method = "tickMovement",
            at = @At("HEAD")
    )
    private void healEntity(CallbackInfo info) {
        var type = getType();
        if (((Object) this instanceof PassiveEntity || type.isIn(MORE_HEALTHY)) && !type.isIn(LESS_HEALTHY)) {
            if (!this.getWorld().isClient && this.isAlive() && this.age % 100 == 0) {
                this.heal(1.0F);
            }
        }
    }
}
