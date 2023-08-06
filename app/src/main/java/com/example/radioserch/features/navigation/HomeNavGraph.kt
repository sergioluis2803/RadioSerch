package com.example.radioserch.features.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.radioserch.features.home.presentation.component.Home
import com.example.radioserch.features.home.presentation.component.LibraryMusic
import com.example.radioserch.features.home.presentation.component.SearchApp
import com.example.radioserch.features.navigation.util.ItemsMenu
import com.example.radioserch.features.navigation.util.Graph

@Composable
fun HomeNavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME,
        startDestination = ItemsMenu.ItemHome.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(ItemsMenu.ItemHome.route) {
            Home(navHostController)
        }
        composable(ItemsMenu.ItemSearch.route) {
            SearchApp()
        }
        composable(ItemsMenu.ItemLibraryMusic.route) {
            LibraryMusic()
        }
    }
}