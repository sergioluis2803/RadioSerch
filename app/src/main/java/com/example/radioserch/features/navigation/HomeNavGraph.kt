package com.example.radioserch.features.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.radioserch.features.navigation.util.Graph
import com.example.radioserch.util.AppPreferences

@Composable
fun HomeNavGraph(
    navHostController: NavHostController,
    preferences: AppPreferences
) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME,
        startDestination = Graph.OPTIONS
    ) {
        authNavGraph(navHostController = navHostController, preferences)
        optionsNavGraph(navHostController)

    }
}
