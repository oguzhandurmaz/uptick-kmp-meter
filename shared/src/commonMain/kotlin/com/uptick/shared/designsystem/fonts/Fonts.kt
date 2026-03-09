package com.uptick.shared.designsystem.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import uptick.shared.generated.resources.Res
import uptick.shared.generated.resources.inter_regular
import uptick.shared.generated.resources.playfair_display

@Composable
fun playFairDisplayFont() = FontFamily(
    Font(Res.font.playfair_display)
)

@Composable
fun interRegularFont() = FontFamily(
    Font(Res.font.inter_regular)
)