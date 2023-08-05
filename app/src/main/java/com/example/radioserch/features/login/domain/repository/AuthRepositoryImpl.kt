package com.example.radioserch.features.login.domain.repository

import com.example.radioserch.features.login.util.ResultState
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override fun createUser(email: String, password: String): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    trySend(ResultState.Success("Login successfully"))
                }.addOnFailureListener {
                    trySend(ResultState.Error(it))
                }
            awaitClose {
                close()
            }
        }

    override fun signInUser(email: String, password: String): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    trySend(ResultState.Success("Login successfully"))
                }.addOnFailureListener {
                    trySend(ResultState.Error(it))
                }
            awaitClose {
                close()
            }
        }

    override fun signInCredentialGoogle(credential: AuthCredential): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            auth.signInWithCredential(credential)
                .addOnCompleteListener {
                    trySend(ResultState.Success("Login with google successfully"))
                }.addOnFailureListener {
                    trySend(ResultState.Error(it))
                }
            awaitClose {
                close()
            }
        }
}