package com.example.radioserch.features.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.radioserch.features.navigation.util.Graph
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Home(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            FirebaseAuth.getInstance().signOut()
            /*navController.popBackStack()
            navController.navigate(Graph.AUTHENTICATION)*/
        }) {
            Text(text = "Exit")
        }
    }
}