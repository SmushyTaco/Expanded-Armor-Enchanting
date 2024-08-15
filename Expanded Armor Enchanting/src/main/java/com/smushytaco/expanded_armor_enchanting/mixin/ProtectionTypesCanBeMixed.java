package com.smushytaco.expanded_armor_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_armor_enchanting.ExpandedArmorEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Set;
@Mixin(Enchantment.class)
public abstract class ProtectionTypesCanBeMixed {
    @ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second) {
        if (!ExpandedArmorEnchanting.INSTANCE.getConfig().getCanMixDifferentProtectionTypes()) return original;
        return original || ExpandedArmorEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION));
    }
}