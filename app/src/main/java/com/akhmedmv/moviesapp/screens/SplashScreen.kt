package com.akhmedmv.moviesapp.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akhmedmv.moviesapp.MainViewModel
import com.akhmedmv.moviesapp.navigation.Screens
import com.akhmedmv.moviesapp.ui.theme.MoviesAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, viewModel: MainViewModel) {
    var startAnimate by remember { mutableStateOf(false) }

    val alphaAnimation =
        animateFloatAsState(
            targetValue = if (startAnimate) 1f else 0f,
            animationSpec = tween(durationMillis = 1500),
            label = ""
        )

    LaunchedEffect(key1 = true) {
        startAnimate = true
        viewModel.getAllMovies()
        delay(2000)
        navController.navigate(Screens.Main.route) {
            popUpTo(Screens.Splash.route) {
                inclusive = true
            }
        }
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Splash icon",
            tint = Color.Black
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PrevSplash() {
    MoviesAppTheme {
//        Splash()
    }
}