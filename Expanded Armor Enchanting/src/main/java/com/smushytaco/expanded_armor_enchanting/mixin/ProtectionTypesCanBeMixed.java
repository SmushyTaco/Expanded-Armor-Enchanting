package com.smushytaco.expanded_armor_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_armor_enchanting.ExpandedArmorEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
@Mixin(Enchantment.class)
public abstract class ProtectionTypesCanBeMixed {
    @ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second) {
        if (!ExpandedArmorEnchanting.INSTANCE.getConfig().getCanMixDifferentProtectionTypes()) return original;
        if (first.matchesKey(Enchantments.PROTECTION)) {
            if (second.matchesKey(Enchantments.PROJECTILE_PROTECTION) || second.matchesKey(Enchantments.BLAST_PROTECTION) || second.matchesKey(Enchantments.FIRE_PROTECTION)) return true;
        } else if (first.matchesKey(Enchantments.PROJECTILE_PROTECTION)) {
            if (second.matchesKey(Enchantments.PROTECTION) || second.matchesKey(Enchantments.BLAST_PROTECTION) || second.matchesKey(Enchantments.FIRE_PROTECTION)) return true;
        } else if (first.matchesKey(Enchantments.BLAST_PROTECTION)) {
            if (second.matchesKey(Enchantments.PROTECTION) || second.matchesKey(Enchantments.PROJECTILE_PROTECTION) || second.matchesKey(Enchantments.FIRE_PROTECTION)) return true;
        } else if (first.matchesKey(Enchantments.FIRE_PROTECTION)) {
            if (second.matchesKey(Enchantments.PROTECTION) || second.matchesKey(Enchantments.PROJECTILE_PROTECTION) || second.matchesKey(Enchantments.BLAST_PROTECTION)) return true;
        } else if (second.matchesKey(Enchantments.PROTECTION)) {
            if (first.matchesKey(Enchantments.PROJECTILE_PROTECTION) || first.matchesKey(Enchantments.BLAST_PROTECTION) || first.matchesKey(Enchantments.FIRE_PROTECTION)) return true;
        } else if (second.matchesKey(Enchantments.PROJECTILE_PROTECTION)) {
            if (first.matchesKey(Enchantments.PROTECTION) || first.matchesKey(Enchantments.BLAST_PROTECTION) || first.matchesKey(Enchantments.FIRE_PROTECTION)) return true;
        } else if (second.matchesKey(Enchantments.BLAST_PROTECTION)) {
            if (first.matchesKey(Enchantments.PROTECTION) || first.matchesKey(Enchantments.PROJECTILE_PROTECTION) || first.matchesKey(Enchantments.FIRE_PROTECTION)) return true;
        } else if (second.matchesKey(Enchantments.FIRE_PROTECTION)) {
            if (first.matchesKey(Enchantments.PROTECTION) || first.matchesKey(Enchantments.PROJECTILE_PROTECTION) || first.matchesKey(Enchantments.BLAST_PROTECTION)) return true;
        }
        return original;
    }
}