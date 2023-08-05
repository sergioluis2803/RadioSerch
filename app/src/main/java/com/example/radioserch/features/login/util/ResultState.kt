package com.example.radioserch.features.login.util

sealed class ResultState<out T>{
    data class Success<out R>(val data: R) : ResultState<R>()
    data class Error(val message: Throwable) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
}
