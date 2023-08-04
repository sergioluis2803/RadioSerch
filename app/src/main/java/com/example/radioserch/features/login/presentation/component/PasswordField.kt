package com.example.radioserch.features.login.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.radioserch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    password: String,
    passwordVisible: MutableState<Boolean>,
    onValueChanged: (String) -> Unit,
) {

    val visualTransformation =
        if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    TextField(
        value = password, onValueChange = { onValueChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = R.string.text_field_password), fontFamily = FontFamily.SansSerif) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor = colorResource(id = R.color.background_text_field),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (password.isNotBlank()) {
                PasswordVisibleIcon(passwordVisible)
            }
        }
    )
}

@Composable
fun PasswordVisibleIcon(passwordVisible: MutableState<Boolean>) {
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility

    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
        Icon(imageVector = image, contentDescription = "icon_password_visibility")
    }
}
