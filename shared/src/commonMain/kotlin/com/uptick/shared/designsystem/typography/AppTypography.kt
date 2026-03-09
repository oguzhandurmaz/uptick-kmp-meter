package com.uptick.shared.designsystem.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uptick.shared.designsystem.fonts.interRegularFont


data class AppTypography(
    val headline: TextStyle,
    val title: TextStyle,
    val body: TextStyle,
    val label: TextStyle,
    val caption: TextStyle
)

@Composable
fun defaultTypography() = AppTypography(

    headline = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = interRegularFont()
    ),

    title = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = interRegularFont()
    ),

    body = TextStyle(
        fontSize = 16.sp,
        fontFamily = interRegularFont()
    ),
    label = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = interRegularFont()
    ),
    caption = TextStyle(
        fontSize = 10.sp,
        fontFamily = interRegularFont()
    )
)
