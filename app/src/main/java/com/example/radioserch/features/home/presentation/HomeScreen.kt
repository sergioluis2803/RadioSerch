package com.example.radioserch.features.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.radioserch.features.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(topBar = { Text(text = "HOME") }) { paddingValues ->
        Home(paddingValues, navController)
    }
}

@Composable
fun Home(paddingValues: PaddingValues, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Button(onClick = {
            FirebaseAuth.getInstance().signOut()
            navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
        }) {
            Text(text = "Exit")
        }
    }
}