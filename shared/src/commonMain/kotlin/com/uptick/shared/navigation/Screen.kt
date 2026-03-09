package com.uptick.shared.navigation

import com.uptick.shared.domain.MeterSpeed
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    object Home: Screen()
    @Serializable
    data class Meter(
        val name: String,
        val speed: MeterSpeed
    ): Screen()
}