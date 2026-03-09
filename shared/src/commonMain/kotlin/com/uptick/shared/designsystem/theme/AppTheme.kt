package com.uptick.shared.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.uptick.shared.designsystem.color.AppColors
import com.uptick.shared.designsystem.color.DarkColors
import com.uptick.shared.designsystem.color.LightColors
import com.uptick.shared.designsystem.shapes.AppShapes
import com.uptick.shared.designsystem.shapes.DefaultShapes
import com.uptick.shared.designsystem.spacing.DefaultSpacing
import com.uptick.shared.designsystem.spacing.Spacing
import com.uptick.shared.designsystem.typography.AppTypography
import com.uptick.shared.designsystem.typography.defaultTypography

private val LocalColors = staticCompositionLocalOf { LightColors }
private val LocalTypography  = staticCompositionLocalOf<AppTypography> { error("Typography not provided") }
private val LocalSpacing = staticCompositionLocalOf { DefaultSpacing }
private val LocalShapes = staticCompositionLocalOf { DefaultShapes }


object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val spacing: Spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current

    val shapes: AppShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Composable
fun ProvideAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if(darkTheme) DarkColors else LightColors

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides defaultTypography(),
        LocalSpacing provides DefaultSpacing,
        LocalShapes provides DefaultShapes,
    ) {
        content()
    }
}
