package com.example.radioserch.features.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.radioserch.features.home.presentation.component.NavigationBottomApp
import com.example.radioserch.features.home.presentation.component.TopApp
import com.example.radioserch.features.navigation.util.ItemsMenu
import com.example.radioserch.features.navigation.HomeNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    val navigationItem =
        listOf(ItemsMenu.ItemHome, ItemsMenu.ItemSearch, ItemsMenu.ItemLibraryMusic)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopApp()
        },
        bottomBar = {
            NavigationBottomApp(navController, navigationItem)
        }
    )
    { paddingValues ->
        HomeNavGraph(
            navHostController = navController,
            paddingValues
        )
    }

}