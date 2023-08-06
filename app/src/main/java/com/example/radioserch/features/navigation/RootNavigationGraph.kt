package com.example.radioserch.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.radioserch.features.home.presentation.HomeScreen
import com.example.radioserch.features.navigation.util.Graph

@Composable
fun RootNavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navHostController = navController)
        composable(route = Graph.HOME) {
            HomeScreen()
        }
    }
}