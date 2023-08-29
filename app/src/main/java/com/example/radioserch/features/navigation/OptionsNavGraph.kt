package com.example.radioserch.features.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.radioserch.features.home.presentation.component.Home
import com.example.radioserch.features.home.presentation.component.LibraryMusic
import com.example.radioserch.features.home.presentation.component.SearchApp
import com.example.radioserch.features.navigation.util.Graph
import com.example.radioserch.features.navigation.util.ItemsMenu

fun NavGraphBuilder.optionsNavGraph(
    navHostController: NavHostController
) {
    navigation(
        route = Graph.OPTIONS,
        startDestination = ItemsMenu.ItemHome.route
    ) {
        composable(ItemsMenu.ItemHome.route) {
            Home(navHostController)
        }
        composable(ItemsMenu.ItemSearch.route) {
            SearchApp(navHostController)
        }
        composable(ItemsMenu.ItemLibraryMusic.route) {
            LibraryMusic(navHostController)
        }
    }
}