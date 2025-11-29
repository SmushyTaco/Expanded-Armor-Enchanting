package com.smushytaco.expanded_armor_enchanting
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = ExpandedArmorEnchanting.MOD_ID)
@Config(name = ExpandedArmorEnchanting.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var canMixDifferentProtectionTypes = true
}