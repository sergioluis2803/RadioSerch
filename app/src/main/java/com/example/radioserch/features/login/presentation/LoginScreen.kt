package com.example.radioserch.features.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.radioserch.R
import com.example.radioserch.features.login.presentation.component.Login

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Login(
            viewModel,
            navController,
            Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.color_app))
        )
    }
}