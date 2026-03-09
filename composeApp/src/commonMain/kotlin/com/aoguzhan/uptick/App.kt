package com.aoguzhan.uptick

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.uptick.navigation.SetupNavGraph
import com.uptick.shared.designsystem.theme.ProvideAppTheme
import com.uptick.shared.navigation.Screen

@Composable
@Preview
fun App() {
    MaterialTheme {

        val startDestination by remember {
            mutableStateOf(Screen.Home)
        }

        ProvideAppTheme(
            darkTheme = isSystemInDarkTheme()
        ) {

            SetupNavGraph(
                startDestination = startDestination
            )
        }


    }
}