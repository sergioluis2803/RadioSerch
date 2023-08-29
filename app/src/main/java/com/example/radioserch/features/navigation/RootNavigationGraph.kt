package com.example.radioserch.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.radioserch.features.home.presentation.HomeScreen
import com.example.radioserch.features.navigation.util.Graph
import com.example.radioserch.util.AppPreferences

@Composable
fun RootNavigationGraph(navController: NavHostController, preferences: AppPreferences) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navHostController = navController, preferences)
        composable(route = Graph.HOME) {
            HomeScreen(preferences)
        }
    }
}