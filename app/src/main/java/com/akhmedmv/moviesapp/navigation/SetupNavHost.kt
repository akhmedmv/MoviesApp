package com.akhmedmv.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akhmedmv.moviesapp.MainViewModel
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
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.Details.route + "/{Id}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("Id") ?: "1"
            DetailsScreen(viewModel = viewModel, itemId = itemId)
        }
    }
}