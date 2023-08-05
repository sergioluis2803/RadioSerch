package com.example.radioserch.features.login.domain.use_case

import com.example.radioserch.features.login.domain.repository.AuthRepository
import com.example.radioserch.features.login.util.ResultState
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLoginGoogleCredential @Inject constructor(
    private val repository: AuthRepository
) {

    fun invoke(credential: AuthCredential): Flow<ResultState<String>> {
        return repository.signInCredentialGoogle(credential)
    }
}