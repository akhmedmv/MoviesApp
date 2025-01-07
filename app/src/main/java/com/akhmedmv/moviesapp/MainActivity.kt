package com.akhmedmv.moviesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.akhmedmv.moviesapp.navigation.SetupNavHost
import com.akhmedmv.moviesapp.screens.MainScreen
import com.akhmedmv.moviesapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Log.d("MoviesAppDebug", "MainActivity onCreate() called")
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()
                SetupNavHost(navController, viewModel = viewModel)
                Log.d("MoviesAppDebug", "MainScreen composable is called")
                MainScreen(navController, viewModel)
            }
        }
    }
}
