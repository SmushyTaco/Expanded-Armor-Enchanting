package com.smushytaco.expanded_armor_enchanting.mixin;
import com.smushytaco.expanded_armor_enchanting.ExpandedArmorEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(ProtectionEnchantment.class)
public abstract class ProtectionTypesCanBeMixed {
    @Shadow
    @Final
    public ProtectionEnchantment.Type protectionType;
    @Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
    private void hookCanAccept(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        if (!ExpandedArmorEnchanting.INSTANCE.getConfig().getCanMixDifferentProtectionTypes() || !(other instanceof ProtectionEnchantment)) return;
        ProtectionEnchantment protectionEnchantment = (ProtectionEnchantment) other;
        if (protectionType != protectionEnchantment.protectionType) cir.setReturnValue(true);
    }
}