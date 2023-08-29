package com.example.radioserch.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.radioserch.R

@Composable
fun DialogApp(onClick: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onClick() },
        confirmButton = {
            TextButton(onClick = { onClick() }) {
                Text(text = stringResource(id = R.string.again))
            }
        },
        title = {
            Text(text = stringResource(id = R.string.title_dialog))
        },
        text = {
            Text(
                text = stringResource(id = R.string.body_dialog)
            )
        }
    )
}