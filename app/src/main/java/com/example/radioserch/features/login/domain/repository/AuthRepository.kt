package com.example.radioserch.features.login.domain.repository

import com.example.radioserch.features.login.util.ResultState
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun createUser(
        email: String,
        password: String
    ): Flow<ResultState<String>>

    fun signInUser(
        email: String,
        password: String
    ): Flow<ResultState<String>>

    fun signInCredentialGoogle(
        credential: AuthCredential
    ): Flow<ResultState<String>>
}