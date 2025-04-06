package com.hamzaazman.akaryakitfiyatlar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hamzaazman.akaryakitfiyatlar.navigation.Screen.Fuel
import com.hamzaazman.akaryakitfiyatlar.ui.fuel.FuelScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Fuel> {
            FuelScreen()
        }
    }
}