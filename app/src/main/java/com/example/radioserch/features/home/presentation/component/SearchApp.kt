package com.example.radioserch.features.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.radioserch.features.navigation.util.ItemsMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchApp(navController: NavHostController) {
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
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues), contentAlignment = Alignment.Center) {
            Text(text = "Search app")
        }
    }

}