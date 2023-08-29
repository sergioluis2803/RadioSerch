package com.example.radioserch.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextQuestion(
    navController: NavController,
    text1: String,
    text2: String,
    routeScreen: String,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) {
        Text(
            text = text1,
            fontSize = 15.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = text2,
            fontSize = 15.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { navController.navigate(routeScreen) })
    }
}