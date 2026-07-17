package net.darkside.moreore.mixin.client;

import java.util.Collection;
import java.util.stream.Collectors;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.darkside.moreore.effect.ModEffect;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

@Mixin(AbstractInventoryScreen.class)
public class StatusEffectsDisplayMixin {

    @Redirect(
            method = "drawStatusEffects(Lnet/minecraft/client/gui/DrawContext;II)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getStatusEffects()Ljava/util/Collection;")
    )
    private Collection<StatusEffectInstance> moreore$hideShadowToolFromInventory(ClientPlayerEntity player) {
        return player.getStatusEffects().stream()
                .filter(effect -> !effect.getEffectType().equals(ModEffect.SHADOW_TOOL)
                        && !effect.getEffectType().equals(ModEffect.SHADOW_WEAPON))
                .collect(Collectors.toList());
    }
}
