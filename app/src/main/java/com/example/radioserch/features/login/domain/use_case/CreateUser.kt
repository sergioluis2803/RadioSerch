package com.example.radioserch.features.login.domain.use_case

import com.example.radioserch.features.login.domain.repository.AuthRepository
import com.example.radioserch.features.login.util.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUser@Inject constructor(
    private val repository: AuthRepository
) {

    fun invoke(email: String, password: String): Flow<ResultState<String>> {
        return repository.createUser(email, password)
    }
}