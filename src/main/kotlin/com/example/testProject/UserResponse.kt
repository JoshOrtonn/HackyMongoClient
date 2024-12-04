package com.example.testProject

sealed class UserResponse {
    data class MessagesSuccess(val userMessages: List<Message>): UserResponse()
    data class NestedMessageSuccess(val message: NestedMessage): UserResponse()
    data class Failure(val errorMessage: String? = null): UserResponse()
}
