package com.example.radioserch.features.splash.component

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.radioserch.R
import com.example.radioserch.features.common.IconApp

@Composable
fun Splash() {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 1100,
                easing = { OvershootInterpolator(4f).getInterpolation(it) }
            )
        )
    }

    Surface(
        modifier = Modifier
            .padding(5.dp)
            .size(400.dp)
            .scale(scale.value),
        shape = CircleShape,
        border = BorderStroke(width = 5.dp, color = colorResource(id = R.color.black)),
        color = colorResource(id = R.color.color_app)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconApp(Modifier.fillMaxSize())
        }
    }
}