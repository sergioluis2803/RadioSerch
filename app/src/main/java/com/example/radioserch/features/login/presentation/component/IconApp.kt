package com.example.radioserch.features.login.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.radioserch.R

@Composable
fun IconApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_app),
            contentDescription = "icon_app",
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(colorResource(id = R.color.black))
        )

        Spacer(modifier = Modifier.padding(bottom = 5.dp))

        Text(
            text = stringResource(id = R.string.app_name).uppercase(),
            fontFamily = FontFamily.Monospace,
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black),
            letterSpacing = 5.sp
        )
    }
}
