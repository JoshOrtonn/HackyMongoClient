package com.example.testProject

sealed class NetworkResult<out T, out E: Exception>() {
    data class Success<out T, out E : Exception>(val data: T): NetworkResult<T, E>()
    data class Error<out T, out E : Exception>(val error: E, val message: String): NetworkResult<T, E>()
}