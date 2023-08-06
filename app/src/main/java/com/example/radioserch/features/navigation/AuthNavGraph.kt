package com.example.radioserch.features.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.radioserch.features.login.presentation.LoginScreen
import com.example.radioserch.features.navigation.util.Graph
import com.example.radioserch.features.navigation.util.AuthScreen
import com.example.radioserch.features.register.presentation.RegisterScreen
import com.example.radioserch.features.splash.SplashScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.SplashAuthScreen.route
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