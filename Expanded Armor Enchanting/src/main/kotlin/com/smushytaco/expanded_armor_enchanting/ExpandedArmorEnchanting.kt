package com.smushytaco.expanded_armor_enchanting
import net.fabricmc.api.ModInitializer
import net.minecraft.core.Holder
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.enchantment.Enchantment
import kotlin.jvm.optionals.getOrNull
object ExpandedArmorEnchanting : ModInitializer {
    const val MOD_ID = "expanded_armor_enchanting"
    val config = ModConfig.createAndLoad()
    override fun onInitialize() {}
    fun canCombineEnchantments(first: Holder<Enchantment>, second: Holder<Enchantment>, enchantments: Set<ResourceKey<Enchantment>>) = enchantments.any { first.`is`(it) } && enchantments.any { second.`is`(it) } && (second.unwrapKey().getOrNull()?.let { !first.`is`(it) } ?: true)
}