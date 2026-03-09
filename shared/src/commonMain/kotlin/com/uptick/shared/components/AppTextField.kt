package com.uptick.shared.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uptick.shared.designsystem.fonts.interRegularFont
import com.uptick.shared.designsystem.fonts.playFairDisplayFont
import com.uptick.shared.designsystem.theme.AppTheme
import com.uptick.shared.designsystem.theme.ProvideAppTheme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit
) {

    TextField(
        modifier = modifier,
        value = value,
        placeholder = {
            Text(
                text = placeholder,
                color = AppTheme.colors.textSecondary,
                style = AppTheme.typography.body,
                fontWeight = FontWeight.Thin
            )
        },
        onValueChange = onValueChange,
        shape = AppTheme.shapes.none,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = AppTheme.colors.background,
            unfocusedContainerColor = AppTheme.colors.background,
            focusedIndicatorColor = AppTheme.colors.primary,
            unfocusedIndicatorColor = AppTheme.colors.primary,
            focusedTextColor = AppTheme.colors.primary,
            unfocusedTextColor = AppTheme.colors.primary,
            cursorColor = AppTheme.colors.primary,
            selectionColors = TextSelectionColors(
                handleColor = AppTheme.colors.primary,
                backgroundColor = Color.Unspecified
            )
        )
    )

}

@Preview
@Composable
fun AppTextFieldPreview(){

    var value by remember { mutableStateOf("") }
    ProvideAppTheme(darkTheme = true) {

        Surface(
            color = AppTheme.colors.background
        ) {
            AppTextField(
                modifier = Modifier.padding(AppTheme.spacing.small),
                value = value,
                placeholder = "Enter name",
                onValueChange = {
                    value = it
                }
            )
        }
    }
}