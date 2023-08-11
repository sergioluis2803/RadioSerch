package com.example.radioserch.features.login.util

sealed interface HomeUiState {
    val loginEnabled: Boolean
    val isButtonLoading: Boolean
    val emailInput: String
    val passwordInput: String

    data class HomeLogin(
        val loginCredential: Boolean,
        override val loginEnabled: Boolean,
        override val isButtonLoading: Boolean,
        override val emailInput: String,
        override val passwordInput: String
    ) : HomeUiState


    data class HomeRegister(
        override val loginEnabled: Boolean,
        override val isButtonLoading: Boolean,
        override val emailInput: String,
        override val passwordInput: String
    ) : HomeUiState
}