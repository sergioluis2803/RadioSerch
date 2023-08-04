package com.example.radioserch.features.login.presentation.component

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.radioserch.R
import com.example.radioserch.features.login.presentation.LoginViewModel
import com.example.radioserch.features.navigation.Screen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun LoginWithGoogle(navController: NavController, viewModel: LoginViewModel) {
    val token = stringResource(id = R.string.default_web_client_id)
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            if (account != null) {
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                viewModel.userLoginWithGoogleCredential(credential) {
                    navController.popBackStack()
                    navController.navigate(Screen.HomeScreen.route)
                }
            }
        } catch (error: Exception) {
            Log.d("MENSAJE", "google fallo: ${error.message} - ${error.localizedMessage}")
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.continue_login),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

        Image(
            painter = painterResource(id = R.drawable.icon_google),
            contentDescription = "login_with_google",
            modifier = Modifier
                .padding(9.dp)
                .size(40.dp)
                .clickable {
                    val options = GoogleSignInOptions
                        .Builder(
                            GoogleSignInOptions.DEFAULT_SIGN_IN
                        )
                        .requestIdToken(token)
                        .requestEmail()
                        .build()
                    val googleClient = GoogleSignIn.getClient(context, options)
                    googleClient.signOut()
                    launcher.launch(googleClient.signInIntent)
                }
        )
    }
}