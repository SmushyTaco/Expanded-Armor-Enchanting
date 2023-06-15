package com.smushytaco.expanded_armor_enchanting
import com.llamalad7.mixinextras.MixinExtrasBootstrap
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint
@Suppress("UNUSED")
object ExpandedArmorEnchantingPreLaunch: PreLaunchEntrypoint { override fun onPreLaunch() { MixinExtrasBootstrap.init() } }