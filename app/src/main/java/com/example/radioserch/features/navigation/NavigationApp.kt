package com.example.radioserch.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.radioserch.features.home.presentation.HomeScreen
import com.example.radioserch.features.login.presentation.LoginScreen
import com.example.radioserch.features.login.presentation.LoginViewModel
import com.example.radioserch.features.register.presentation.RegisterScreen
import com.example.radioserch.features.register.presentation.RegisterViewModel
import com.example.radioserch.features.splash.SplashScreen

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController, LoginViewModel())
        }

        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController, RegisterViewModel())
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
    }
}