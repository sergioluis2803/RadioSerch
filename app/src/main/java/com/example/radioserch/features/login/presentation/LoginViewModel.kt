package com.example.radioserch.features.login.presentation

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginEnabled = MutableStateFlow(false)
    val loginEnabled: StateFlow<Boolean> = _loginEnabled

    private val auth: FirebaseAuth = Firebase.auth
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun userOnLogin(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            try {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        home()
                    } else {
                        Log.d("MENSAJE", "${task.result}")
                    }
                    _isLoading.value = !_isLoading.value
                }
            } catch (error: Exception) {
                Log.d("MENSAJE", "${error.message}")
                _isLoading.value = !_isLoading.value
            }
        }
    }

    fun userLoginWithGoogleCredential(credential: AuthCredential, home: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            home()
                        }
                    }
                    .addOnFailureListener {
                        Log.d("MENSAJE2", "Fallo al logeuar con google")
                    }
            } catch (error: Exception) {
                Log.d("MENSAJE3", error.localizedMessage ?: "error")
            }
        }
    }
}