package com.example.mytestapplication.helper

import java.lang.Exception

sealed class ApiState<out T : Any> {
    data class Success<out T : Any>(val data: T) : ApiState<T>()
    data class ApiError(val string: String) : ApiState<Nothing>()
    data class Error(val exception: Exception) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
}