package com.example.testProject

sealed class NetworkResult<out T, out E: Exception>() {
    data class Success<out T>(val data: T): NetworkResult<T, Nothing>()
    data class Error<out E : Exception>(val error: E, val message: String): NetworkResult<Nothing, E>()
}