package com.smushytaco.expanded_armor_enchanting
import com.smushytaco.expanded_armor_enchanting.configuration_support.ModConfiguration
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer
import net.fabricmc.api.ModInitializer
object ExpandedArmorEnchanting : ModInitializer {
    const val MOD_ID = "expanded_armor_enchanting"
    lateinit var config: ModConfiguration
        private set
    override fun onInitialize() {
        AutoConfig.register(ModConfiguration::class.java) { definition: Config, configClass: Class<ModConfiguration> ->
            GsonConfigSerializer(definition, configClass)
        }
        config = AutoConfig.getConfigHolder(ModConfiguration::class.java).config
    }
}