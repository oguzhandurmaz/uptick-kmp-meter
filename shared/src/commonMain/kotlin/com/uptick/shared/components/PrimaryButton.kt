package com.uptick.shared.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uptick.shared.designsystem.theme.AppTheme
import com.uptick.shared.designsystem.theme.ProvideAppTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = {
            onClick()
        },
        shape = AppTheme.shapes.none,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.primary,
            contentColor = AppTheme.colors.textOnPrimary
        )
    ){
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    ProvideAppTheme(darkTheme = true) {

        PrimaryButton(
            modifier = Modifier.padding(AppTheme.spacing.small),
            text = "START",
            onClick = {}
        )
    }
}
