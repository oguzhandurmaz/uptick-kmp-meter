package com.uptick.shared.components

import androidx.compose.runtime.*
import com.uptick.shared.domain.MeterSpeed
import kotlinx.coroutines.isActive
import kotlinx.coroutines.delay

class MeterState(
    speed: MeterSpeed = MeterSpeed.MEDIUM,
) {

    var progress by mutableStateOf(0f)
        private set

    var speed by mutableStateOf(speed)

    var running by mutableStateOf(false)
        private set

    fun start() {
        running = true
    }

    fun stop() {
        running = false
    }

    fun reset() {
        progress = 0f
    }

    fun tick() {
        if (!running) return
        progress += 1
    }
}

@Composable
fun rememberMeterState(
    speed: MeterSpeed = MeterSpeed.MEDIUM
): MeterState {
    return remember { MeterState(speed) }
}

private fun MeterState.delayMillis(): Long {
    val delay = when (speed) {
        MeterSpeed.SLOW -> 2000L
        MeterSpeed.MEDIUM -> 1000L
        MeterSpeed.FAST -> 100L
    }

    return delay
}

@Composable
fun MeterEngine(
    state: MeterState
) {

    LaunchedEffect(state.running) {

        while (state.running && isActive) {

            state.tick()

            delay(state.delayMillis())
        }
    }
}