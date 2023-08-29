package com.example.radioserch.features.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.radioserch.features.login.presentation.LoginScreen
import com.example.radioserch.features.navigation.util.AuthScreen
import com.example.radioserch.features.navigation.util.Graph
import com.example.radioserch.features.register.presentation.RegisterScreen
import com.example.radioserch.features.splash.SplashScreen
import com.example.radioserch.util.AppPreferences
import com.example.radioserch.util.Constant

fun NavGraphBuilder.authNavGraph(
    navHostController: NavHostController,
    preferences: AppPreferences
) {

    val userLogin = preferences.retrievePreference(Constant.USER_LOGIN, false)

    val startDestination = if (userLogin as Boolean) AuthScreen.LoginAuthScreen.route
    else AuthScreen.SplashAuthScreen.route

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = startDestination
    ) {
        composable(route = AuthScreen.SplashAuthScreen.route) {
            SplashScreen(navController = navHostController)
        }

        composable(route = AuthScreen.LoginAuthScreen.route) {
            LoginScreen(navController = navHostController)
        }

        composable(route = AuthScreen.RegisterAuthScreen.route) {
            RegisterScreen(navController = navHostController)
        }
    }
}