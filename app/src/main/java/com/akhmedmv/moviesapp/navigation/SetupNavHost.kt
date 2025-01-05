package com.akhmedmv.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akhmedmv.moviesapp.utils.Constants
import com.akhmedmv.moviesapp.screens.DetailsScreen
import com.akhmedmv.moviesapp.screens.MainScreen
import com.akhmedmv.moviesapp.screens.SplashScreen

sealed class Screens(val route: String) {
    object Splash : Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main : Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details : Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screens.Main.route) {
            MainScreen()
        }

        composable(route = Screens.Details.route) {
            DetailsScreen()
        }
    }
}