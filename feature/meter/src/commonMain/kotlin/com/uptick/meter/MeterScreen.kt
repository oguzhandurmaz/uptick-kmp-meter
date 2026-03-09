package com.uptick.meter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uptick.meter.components.AnimatedMeterText
import com.uptick.shared.components.MeterEngine
import com.uptick.shared.components.rememberMeterState
import com.uptick.shared.designsystem.theme.AppTheme
import com.uptick.shared.domain.MeterSpeed
import com.uptick.shared.system.keepScreenOn
import org.jetbrains.compose.resources.stringResource
import uptick.shared.generated.resources.Res
import uptick.shared.generated.resources.reset
import uptick.shared.generated.resources.start
import uptick.shared.generated.resources.stop

@Composable
fun MeterScreen(
    name: String,
    speed: MeterSpeed
) {

    val meterState = rememberMeterState(
        speed = speed
    )

    var showUi by remember {
        mutableStateOf(true)
    }

    DisposableEffect(Unit) {

        keepScreenOn(true)

        onDispose {
            keepScreenOn(false)
        }
    }

    Scaffold(
        containerColor = AppTheme.colors.background
    ) { padding ->
        Column(
            modifier = Modifier
                .clickable{
                    showUi = !showUi
                }
                .padding(AppTheme.spacing.large)
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            MeterEngine(state = meterState)

            LaunchedEffect(Unit) {
                meterState.start()
            }

            AnimatedVisibility(
                visible = showUi
            ){
                Column {
                    Spacer(modifier = Modifier.height(AppTheme.spacing.medium))
                    Text(
                        text = name.uppercase(),
                        style = AppTheme.typography.body,
                        color = AppTheme.colors.textSecondary,
                        fontWeight = FontWeight.Normal
                    )
                }
            }


            Box(
                modifier = Modifier.fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){

                AnimatedMeterText(
                    value = meterState.progress.toInt(),
                    animationSpeed = when (speed) {
                        MeterSpeed.SLOW -> 1950
                        MeterSpeed.MEDIUM -> 950
                        MeterSpeed.FAST -> 50
                    }
                )
            }

            AnimatedVisibility(
                visible = showUi
            ){
                Column {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.clickable{
                                if(meterState.running){
                                    meterState.stop()
                                } else {
                                    meterState.start()
                                }
                            },
                            text = if(meterState.running) stringResource(Res.string.stop) else stringResource(Res.string.start),
                            style = AppTheme.typography.label,
                            color = AppTheme.colors.textSecondary
                        )
                        Text(
                            modifier = Modifier.clickable{
                                meterState.reset()
                            },
                            text = stringResource(Res.string.reset),
                            style = AppTheme.typography.label,
                            color = AppTheme.colors.textSecondary
                        )
                    }
                    Spacer(modifier = Modifier.height(AppTheme.spacing.small))
                }


            }

        }
    }
}

@Preview
@Composable
fun MeterScreenPreview() {
    MeterScreen(
        name = "Test Meter",
        speed = MeterSpeed.MEDIUM
    )
}