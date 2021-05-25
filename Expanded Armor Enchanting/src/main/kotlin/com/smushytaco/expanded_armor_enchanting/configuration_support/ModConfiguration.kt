package com.smushytaco.expanded_armor_enchanting.configuration_support
import com.smushytaco.expanded_armor_enchanting.ExpandedArmorEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExpandedArmorEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes you'll be able to mix all different protection types on the same piece of armor. If set to no you won't be able to.")
    val canMixDifferentProtectionTypes = true
}