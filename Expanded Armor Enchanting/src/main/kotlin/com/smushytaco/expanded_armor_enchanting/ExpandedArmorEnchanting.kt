package com.smushytaco.expanded_armor_enchanting
import net.fabricmc.api.ModInitializer
import net.minecraft.enchantment.Enchantment
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.entry.RegistryEntry
import kotlin.jvm.optionals.getOrNull
object ExpandedArmorEnchanting : ModInitializer {
    const val MOD_ID = "expanded_armor_enchanting"
    val config = ModConfig.createAndLoad()
    override fun onInitialize() {}
    fun canCombineEnchantments(first: RegistryEntry<Enchantment>, second: RegistryEntry<Enchantment>, enchantments: Set<RegistryKey<Enchantment>>) = enchantments.any { first.matchesKey(it) } && enchantments.any { second.matchesKey(it) } && !first.matchesKey(second.key.getOrNull())
}