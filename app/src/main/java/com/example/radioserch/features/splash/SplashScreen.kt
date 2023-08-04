package com.example.radioserch.features.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.radioserch.features.navigation.Screen
import com.example.radioserch.features.splash.component.Splash
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = true) {
        delay(1000)

        val route = if (FirebaseAuth.getInstance().currentUser?.email.isNullOrBlank()) {
            Screen.LoginScreen.route
        } else {
            Screen.HomeScreen.route
        }
        navController.popBackStack()
        navController.navigate(route)
    }

    Splash()
}