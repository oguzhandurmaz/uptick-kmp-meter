package com.uptick.navigation

import androidx.navigation.NavType
import androidx.savedstate.SavedState
import androidx.savedstate.read
import androidx.savedstate.write
import com.uptick.shared.domain.MeterSpeed
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


val MeterSpeedType = object : NavType<MeterSpeed>(isNullableAllowed = false) {
    override fun put(bundle: SavedState, key: String, value: MeterSpeed) {
        bundle.write { putString(key, Json.encodeToString(value)) }
    }
    override fun get(bundle: SavedState, key: String): MeterSpeed? {
        return bundle.read { getStringOrNull(key) }?.let { Json.decodeFromString(it) }
    }
    override fun parseValue(value: String): MeterSpeed {
        return Json.decodeFromString(value)
    }
    override fun serializeAsValue(value: MeterSpeed): String {
        return Json.encodeToString(value)
    }
}