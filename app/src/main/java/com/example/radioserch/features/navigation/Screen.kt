package com.example.radioserch.features.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splashScreen")
    object LoginScreen : Screen("loginScreen")
    object RegisterScreen : Screen("registerScreen")
    object HomeScreen : Screen("homeScreen")
}