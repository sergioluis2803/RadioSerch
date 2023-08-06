package com.example.radioserch.features.login.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.radioserch.R
import com.example.radioserch.features.common.CustomStyleButton
import com.example.radioserch.features.common.CustomStyleProgressIndicator
import com.example.radioserch.features.common.CustomStyleTextField
import com.example.radioserch.features.common.IconApp
import com.example.radioserch.features.common.TextQuestion
import com.example.radioserch.features.dialog.DialogApp
import com.example.radioserch.features.login.presentation.LoginViewModel
import com.example.radioserch.features.navigation.util.AuthScreen
import com.example.radioserch.features.navigation.util.Graph

@Composable
fun Login(
    viewModel: LoginViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        IconApp(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(40.dp))
        ModelFormUserLogin(viewModel, navController, Modifier.fillMaxSize())
    }
}

@Composable
fun ModelFormUserLogin(
    viewModel: LoginViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp)
    ) {
        FormUserLoginIn(
            viewModel,
            navController,
            Modifier.padding(top = 40.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun FormUserLoginIn(
    viewModel: LoginViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val loginEnabled by viewModel.loginEnabled.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val showErrorDialog = viewModel.showErrorDialog.collectAsStateWithLifecycle()

    val passwordVisibility = mutableStateOf(false)

    if (showErrorDialog.value) {
        DialogApp { viewModel.dismissErrorDialog() }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.button_login).uppercase(),
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(5.dp))

        TextQuestion(
            navController = navController,
            text1 = stringResource(id = R.string.text_register),
            text2 = stringResource(id = R.string.text_register_here),
            routeScreen = AuthScreen.RegisterAuthScreen.route
        )
        Spacer(modifier = Modifier.padding(20.dp))

        CustomStyleTextField(
            text = email,
            labelText = stringResource(id = R.string.text_field_email),
            onValueChanged = { viewModel.onLoginChanged(it, password) },
            keyboardType = KeyboardType.Email,
            iconTextField = Icons.Default.Email,
            isTextPassword = false,
            passwordVisible = passwordVisibility
        )
        Spacer(modifier = Modifier.padding(8.dp))

        CustomStyleTextField(
            text = password,
            labelText = stringResource(id = R.string.text_field_password),
            onValueChanged = { viewModel.onLoginChanged(email, it) },
            keyboardType = KeyboardType.Password,
            iconTextField = Icons.Default.Lock,
            isTextPassword = true,
            passwordVisible = passwordVisibility
        )
        Spacer(modifier = Modifier.padding(20.dp))

        if (isLoading) {
            CustomStyleProgressIndicator()
        } else {
            CustomStyleButton(
                loginEnabled = loginEnabled,
                textButton = stringResource(id = R.string.button_login)
            ) {
                viewModel.userOnLogin(
                    email = email,
                    password = password,
                    success = {
                        navController.popBackStack()
                        navController.navigate(Graph.HOME)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.padding(20.dp))

        LoginWithGoogle(navController, viewModel)
    }
}