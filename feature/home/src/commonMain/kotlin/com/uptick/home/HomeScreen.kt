package com.uptick.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uptick.shared.components.AppTab
import com.uptick.shared.components.AppTextField
import com.uptick.shared.components.PrimaryButton
import com.uptick.shared.designsystem.fonts.playFairDisplayFont
import com.uptick.shared.designsystem.theme.AppTheme
import com.uptick.shared.designsystem.theme.ProvideAppTheme
import com.uptick.shared.domain.MeterSpeed
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import uptick.shared.generated.resources.Res
import uptick.shared.generated.resources.ic_uptick
import uptick.shared.generated.resources.label_enter_name
import uptick.shared.generated.resources.label_select_speed
import uptick.shared.generated.resources.label_setup_meter
import uptick.shared.generated.resources.label_speed_fast
import uptick.shared.generated.resources.label_speed_medium
import uptick.shared.generated.resources.label_speed_slow
import uptick.shared.generated.resources.start

@Composable
fun HomeScreen(
    navigateToMeter: (name: String, speed: MeterSpeed) -> Unit
) {

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var selectedSpeed by rememberSaveable {
        mutableStateOf(MeterSpeed.MEDIUM)
    }

    Scaffold(
        containerColor = AppTheme.colors.background
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(AppTheme.spacing.large)
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_uptick),
                    contentDescription = "UpTick Icon",
                    tint = AppTheme.colors.primary,
                    modifier = Modifier.size(42.dp)
                )
                Text(
                    text = "UpTick",
                    style = AppTheme.typography.headline,
                    color = AppTheme.colors.textPrimary,
                    fontFamily = playFairDisplayFont()
                )

                Spacer(modifier = Modifier.height(AppTheme.spacing.medium))

                Text(
                    text = stringResource(Res.string.label_setup_meter),
                    style = AppTheme.typography.caption,
                    color = AppTheme.colors.textSecondary,
                )
            }


            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { newValue ->
                    name = newValue
                },
                placeholder = stringResource(Res.string.label_enter_name)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.label_select_speed),
                    style = AppTheme.typography.caption,
                    color = AppTheme.colors.textSecondary
                )
                Spacer(modifier = Modifier.height(AppTheme.spacing.medium))

                Row {
                    MeterSpeed.entries.forEach { speed ->
                        val selected = speed == selectedSpeed
                        val icon = (0..speed.ordinal)
                            .joinToString(separator = " ") { "\u2022" }
                        AppTab(
                            modifier = Modifier.padding(end = AppTheme.spacing.medium),
                            text = stringResource(speed.labelRes()),
                            selected = selected,
                            icon = {
                                Text(
                                    text = icon,
                                    style = AppTheme.typography.label,
                                    color = if (selected) AppTheme.colors.textPrimary else AppTheme.colors.textSecondary
                                )
                            },
                            onClick = {
                                selectedSpeed = speed
                            }
                        )
                    }
                }
            }


            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(Res.string.start),
                onClick = {
                    if(name.isNotBlank()) {
                        navigateToMeter(name, selectedSpeed)
                    }
                }
            )
        }
    }
}

private fun MeterSpeed.labelRes(): StringResource {
    return when (this) {
        MeterSpeed.SLOW -> Res.string.label_speed_slow
        MeterSpeed.MEDIUM -> Res.string.label_speed_medium
        MeterSpeed.FAST -> Res.string.label_speed_fast
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    ProvideAppTheme(darkTheme = true) {
        HomeScreen(
            navigateToMeter = { _, _ -> }
        )
    }
}