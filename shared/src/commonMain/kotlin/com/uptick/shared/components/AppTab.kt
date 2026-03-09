package com.uptick.shared.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uptick.shared.designsystem.theme.AppTheme

@Composable
fun AppTab(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    icon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit
) {

    val textColor = if (selected) {
        AppTheme.colors.textPrimary
    } else {
        AppTheme.colors.textSecondary
    }

    Column(
        modifier = modifier
            .width(IntrinsicSize.Min)
            .clickable {
                onClick()
            }
            .padding(all = AppTheme.spacing.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (icon != null) {
            icon()
        }
        Spacer(modifier = Modifier.height(AppTheme.spacing.small))
        Text(
            text = text,
            style = AppTheme.typography.label,
            color = textColor,
        )
        Spacer(modifier = Modifier.height(AppTheme.spacing.small))

        HorizontalDivider(
            modifier = Modifier,
            thickness = if (selected) 2.dp else 0.dp,
            color = AppTheme.colors.primary
        )
    }
}

@Preview
@Composable
fun AppTabPreview() {

    val selected = true
    Surface(
        color = AppTheme.colors.background
    ) {
        AppTab(
            text = "SLOW",
            icon = {
                Text(
                    text = "*",
                    style = AppTheme.typography.label,
                    color = if(selected) AppTheme.colors.textPrimary else AppTheme.colors.textSecondary
                )
            },
            selected = selected,
            onClick = {}
        )
    }
}