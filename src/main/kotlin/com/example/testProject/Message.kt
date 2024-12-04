package com.example.testProject

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "messagesTestProject")
data class Message(
    @Id
    val id: String,
    val messages: List<NestedMessage>
)

data class NestedMessage(val messageId: String, val text: String)
