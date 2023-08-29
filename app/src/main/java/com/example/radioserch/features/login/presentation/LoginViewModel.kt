package com.example.radioserch.features.login.presentation

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.radioserch.features.login.domain.use_case.CreateUser
import com.example.radioserch.features.login.domain.use_case.UserLoginEmailPassword
import com.example.radioserch.features.login.domain.use_case.UserLoginGoogleCredential
import com.example.radioserch.features.login.util.HomeViewModelState
import com.example.radioserch.features.login.util.ResultState
import com.example.radioserch.util.AppPreferences
import com.example.radioserch.util.Constant
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val sigInEmailPasswordUseCase: UserLoginEmailPassword,
    private val signInGoogleUseCase: UserLoginGoogleCredential,
    private val createUserUseCase: CreateUser,
    private val preferences: AppPreferences
) : ViewModel() {

    private val viewModelState = MutableStateFlow(HomeViewModelState())
    val uiState = viewModelState
        .map(HomeViewModelState::toUiState)
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    private fun isValidPassword(password: String): Boolean = password.length >= 6

    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun onLoginChanged(email: String, password: String) {
        viewModelState.update {
            it.copy(
                emailInput = email,
                passwordInput = password,
                loginEnabled = isValidEmail(email) && isValidPassword(password)
            )
        }
    }

    fun dismissErrorDialog() {
        viewModelState.update { it.copy(showError = false) }
    }

    fun createUserEmailPassword(email: String, password: String, success: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            createUserUseCase.invoke(email, password).collect { resultState ->
                when (resultState) {
                    is ResultState.Success -> {
                        viewModelState.update { it.copy(isButtonLoading = true) }
                        success()
                        preferences.savePreference(Constant.USER_LOGIN, true)
                    }

                    is ResultState.Error -> viewModelState.update { it.copy(showError = true) }
                    is ResultState.Loading -> viewModelState.update { it.copy(isButtonLoading = true) }
                }
            }
        }
    }

    fun userOnLogin(email: String, password: String, success: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            sigInEmailPasswordUseCase.invoke(email, password).collect { resultState ->
                when (resultState) {
                    is ResultState.Success -> {
                        success()
                        preferences.savePreference(Constant.USER_LOGIN, true)
                    }

                    is ResultState.Error ->
                        viewModelState.update { it.copy(showError = true, isButtonLoading = false) }

                    is ResultState.Loading ->
                        viewModelState.update { it.copy(isButtonLoading = true) }
                }
            }
        }
    }

    fun userLoginWithGoogleCredential(credential: AuthCredential, home: () -> Unit) {
        viewModelScope.launch(Dispatchers.Main) {
            signInGoogleUseCase.invoke(credential).collect { resultState ->
                when (resultState) {
                    is ResultState.Success -> {
                        viewModelState.update { it.copy(isButtonLoading = true) }
                        home()
                    }

                    is ResultState.Error -> viewModelState.update { it.copy(showError = true) }
                    is ResultState.Loading -> viewModelState.update { it.copy(isButtonLoading = true) }
                }
            }
        }
    }
}