package seb.Sebiseb.beaconrange.mixin;

import seb.Sebiseb.beaconrange.BeaconRange;
import seb.Sebiseb.beaconrange.config.BeaconRangeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;

@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin {

    /**
     * Intercepte la variable 'range' dans la méthode applyEffects()
     * juste après son calcul : double range = (double)(levels * 10 + 10);
     */
    @ModifyVariable(
            method = "applyEffects(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;ILnet/minecraft/core/Holder;Lnet/minecraft/core/Holder;)V",
            at = @At(value = "STORE"),
            ordinal = 0
    )
    private static double modifyBeaconRange(double vanillaRange) {
        // Calcule le niveau depuis le range vanilla
        // vanilla: niveau 1 = 20.0, niveau 2 = 30.0, niveau 3 = 40.0, niveau 4 = 50.0
        int pyramidLevel = Math.clamp((int)((vanillaRange - 10.0) / 10.0), 1, 4);

        // Applique la portée depuis la config
        int customRange = BeaconRangeConfig.get().getRangeForLevel(pyramidLevel);

        //BeaconRange.LOGGER.info("[BeaconRange] Beacon niveau {} - Portée vanilla: {} -> custom: {}", pyramidLevel, (int)vanillaRange, customRange);

        return (double) customRange;
    }
}