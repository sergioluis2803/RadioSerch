package com.example.radioserch.features.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.radioserch.R
import com.example.radioserch.features.login.presentation.component.Login

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val topColor = colorResource(id = R.color.color_app)
    val bottomColor = colorResource(id = R.color.color_app_gradient)

    val gradientBrush = Brush.verticalGradient(
        colors = listOf(topColor, bottomColor),
        tileMode = TileMode.Decal
    )

    Login(
        viewModel,
        navController,
        Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    )
}