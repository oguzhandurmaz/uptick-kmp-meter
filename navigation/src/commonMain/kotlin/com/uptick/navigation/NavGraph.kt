package com.uptick.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.uptick.home.HomeScreen
import com.uptick.meter.MeterScreen
import com.uptick.shared.domain.MeterSpeed
import com.uptick.shared.navigation.Screen
import kotlin.reflect.typeOf

@Composable
fun SetupNavGraph(startDestination: Screen = Screen.Home){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<Screen.Home> {
            HomeScreen(
                navigateToMeter = { name,speed ->
                    navController.navigate(Screen.Meter(name,speed))
                }
            )
        }

        composable<Screen.Meter>(
            typeMap = mapOf(
                typeOf<MeterSpeed>() to MeterSpeedType
            )
        ) { backStackEntry ->
            val route = backStackEntry.toRoute<Screen.Meter>()
            MeterScreen(
                name = route.name,
                speed = route.speed,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}