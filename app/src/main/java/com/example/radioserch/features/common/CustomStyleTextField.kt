package com.example.radioserch.features.common

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.radioserch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomStyleTextField(
    text: String,
    onValueChanged: (String) -> Unit,
    labelText: String,
    keyboardType: KeyboardType,
    iconTextField: ImageVector,
    isTextPassword: Boolean,
    passwordVisible: MutableState<Boolean>
) {

    val visualTransformation =
        if (isTextPassword) {
            if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }

    TextField(
        value = text,
        onValueChange = { onValueChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                text = labelText,
                fontFamily = FontFamily.SansSerif
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor = colorResource(id = R.color.background_text_field),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        leadingIcon = {
            Icon(
                imageVector = iconTextField,
                contentDescription = "icon_text_field",
                tint = colorResource(id = R.color.color_app)
            )
        },
        trailingIcon = {
            if (isTextPassword && text.isNotBlank()) {
                PasswordVisibleIcon1(passwordVisible)
            }
        },
        visualTransformation = visualTransformation,
    )
}

@Composable
fun PasswordVisibleIcon1(passwordVisible: MutableState<Boolean>) {
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility

    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
        Icon(imageVector = image, contentDescription = "icon_password_visibility")
    }
}