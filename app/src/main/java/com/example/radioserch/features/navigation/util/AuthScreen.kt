package com.example.radioserch.features.navigation.util

sealed class AuthScreen(val route: String) {
    object SplashAuthScreen : AuthScreen("SPLASH")
    object LoginAuthScreen : AuthScreen("LOGIN")
    object RegisterAuthScreen : AuthScreen("REGISTER")
}