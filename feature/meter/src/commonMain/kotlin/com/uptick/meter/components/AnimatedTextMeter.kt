package com.uptick.meter.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uptick.shared.designsystem.fonts.interRegularFont
import com.uptick.shared.designsystem.theme.AppTheme

@Composable
fun AnimatedMeterText(
    value: Int,
    animationSpeed: Int = 300
) {

    val digits = value.toString()

    Row {

        digits.forEachIndexed { index, char ->

            key(index) {
                AnimatedDigit(
                    digit = char,
                    animationSpeed = animationSpeed
                )
            }

        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedDigit(
    digit: Char,
    animationSpeed: Int

) {
    AnimatedContent(
        targetState = digit,
        transitionSpec = {
            slideInVertically(
                animationSpec = tween(animationSpeed),
                initialOffsetY = { it }
            ) togetherWith
                    slideOutVertically(
                        animationSpec = tween(animationSpeed),
                        targetOffsetY = { -it }
                    )
        },
        label = "digitAnimation"
    ) { value ->

        Text(
            modifier = Modifier.width(40.dp),
            text = value.toString(),
            fontSize = 60.sp,
            fontFamily = interRegularFont(),
            color = AppTheme.colors.textPrimary
        )
    }
}