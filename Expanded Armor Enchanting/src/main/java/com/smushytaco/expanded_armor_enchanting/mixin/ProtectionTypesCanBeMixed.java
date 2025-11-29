package com.smushytaco.expanded_armor_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_armor_enchanting.ExpandedArmorEnchanting;
import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Set;
@Mixin(Enchantment.class)
public abstract class ProtectionTypesCanBeMixed {
    @ModifyReturnValue(method = "areCompatible", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, Holder<Enchantment> first, Holder<Enchantment> second) {
        if (!ExpandedArmorEnchanting.INSTANCE.getConfig().getCanMixDifferentProtectionTypes()) return original;
        return original || ExpandedArmorEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION));
    }
}