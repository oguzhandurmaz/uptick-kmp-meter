package com.uptick.shared.designsystem.shapes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

data class AppShapes(
    val none: RoundedCornerShape = RoundedCornerShape(0.dp),
    val small: RoundedCornerShape,
    val medium: RoundedCornerShape,
    val large: RoundedCornerShape,
    val circle: RoundedCornerShape = RoundedCornerShape(50)
)

val DefaultShapes = AppShapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp)
)
