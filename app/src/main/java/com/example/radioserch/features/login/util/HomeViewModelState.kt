package com.example.radioserch.features.login.util

data class HomeViewModelState(
    val loginCredential: Boolean = true,
    val loginEnabled: Boolean = false,
    val isButtonLoading: Boolean = false,
    val emailInput: String = "",
    val passwordInput: String = ""
) {
    fun toUiState(): HomeUiState = if (loginCredential) {
        HomeUiState.HomeLogin(
            loginCredential = loginCredential,
            loginEnabled = loginEnabled,
            isButtonLoading = isButtonLoading,
            emailInput = emailInput,
            passwordInput = passwordInput
        )
    } else {
        HomeUiState.HomeRegister(
            loginEnabled = loginEnabled,
            isButtonLoading = isButtonLoading,
            emailInput = emailInput,
            passwordInput = passwordInput
        )
    }
}
