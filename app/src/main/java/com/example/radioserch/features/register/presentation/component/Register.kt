package com.example.radioserch.features.register.presentation.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.radioserch.R
import com.example.radioserch.features.login.presentation.component.EmailField
import com.example.radioserch.features.login.presentation.component.IconApp
import com.example.radioserch.features.login.presentation.component.LoginButton
import com.example.radioserch.features.login.presentation.component.PasswordField
import com.example.radioserch.features.login.presentation.component.TextQuestion
import com.example.radioserch.features.navigation.Screen
import com.example.radioserch.features.register.presentation.RegisterViewModel

@Composable
fun Register(
    viewModel: RegisterViewModel,
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
        ModelFormRegister(viewModel, navController, Modifier.fillMaxSize())
    }

}

@Composable
fun ModelFormRegister(
    viewModel: RegisterViewModel,
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
        FormUserRegister(
            viewModel,
            navController,
            Modifier.padding(top = 40.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun FormUserRegister(
    viewModel: RegisterViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val email by viewModel.email.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()
    val loginEnabled by viewModel.loginEnabled.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    val passwordVisibility = mutableStateOf(false)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.button_register).uppercase(),
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.padding(5.dp))

        TextQuestion(
            navController = navController,
            text1 = stringResource(id = R.string.text_login),
            text2 = stringResource(id = R.string.text_login_here),
            routeScreen = Screen.LoginScreen.route
        )
        Spacer(modifier = Modifier.padding(20.dp))

        EmailField(email) { viewModel.onLoginChanged(it, password) }
        Spacer(modifier = Modifier.padding(8.dp))

        PasswordField(password, passwordVisibility) { viewModel.onLoginChanged(email, it) }
        Spacer(modifier = Modifier.padding(20.dp))

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LoginButton(
                loginEnabled = loginEnabled,
                textButton = stringResource(id = R.string.button_register)
            ) {
                viewModel.userOnRegister(
                    email,
                    password
                ) {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.RegisterScreen.route) {
                            inclusive = true
                        }
                        popUpTo(Screen.LoginScreen.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
}
