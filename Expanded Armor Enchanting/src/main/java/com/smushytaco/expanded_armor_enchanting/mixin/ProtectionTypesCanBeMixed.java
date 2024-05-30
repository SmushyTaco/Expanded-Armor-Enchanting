package com.smushytaco.expanded_armor_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_armor_enchanting.ExpandedArmorEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(ProtectionEnchantment.class)
public abstract class ProtectionTypesCanBeMixed {
    @Shadow
    @Final
    public ProtectionEnchantment.Type protectionType;
    @ModifyReturnValue(method = "canAccept", at = @At("RETURN"))
    private boolean hookCanAccept(boolean original, Enchantment other) { return !ExpandedArmorEnchanting.INSTANCE.getConfig().getCanMixDifferentProtectionTypes() || !(other instanceof ProtectionEnchantment protectionEnchantment) ? original : protectionType != protectionEnchantment.protectionType || original; }
}