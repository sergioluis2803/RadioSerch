package com.example.radioserch.features.login.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.radioserch.R

@Composable
fun LoginButton(loginEnabled: Boolean, textButton: String, onLoginSelected: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { onLoginSelected() },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            enabled = loginEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.activate_button),
                disabledContainerColor = colorResource(id = R.color.disabled_button),
                contentColor = Color.Black
            )
        ) {
            Text(text = textButton,fontSize = 15.sp,)
        }
    }

}
