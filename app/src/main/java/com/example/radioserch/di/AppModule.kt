package com.example.radioserch.di

import com.example.radioserch.features.login.domain.repository.AuthRepository
import com.example.radioserch.features.login.domain.repository.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth): AuthRepository = AuthRepositoryImpl(auth)

}