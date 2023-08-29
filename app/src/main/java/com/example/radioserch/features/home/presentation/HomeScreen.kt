package com.example.radioserch.features.home.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.radioserch.features.navigation.HomeNavGraph
import com.example.radioserch.util.AppPreferences

@Composable
fun HomeScreen(
    preferences: AppPreferences,
    navController: NavHostController = rememberNavController()
) {
    HomeNavGraph(
        navHostController = navController, preferences
    )
}