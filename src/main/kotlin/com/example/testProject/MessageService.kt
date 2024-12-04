package com.example.testProject

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MessageService(@Autowired val mongoRepo: Repo) {
    fun findMessages(): List<Message> {
        val messages = mongoRepo.findAll()

        return messages
    }

    fun findByMessageId(messageId: String): NetworkResult<NestedMessage, Exception> {
        val allMessages = mongoRepo.findAll()
        val nestedMessage = allMessages.flatMap {
            it.messages.filter { it.messageId == messageId }
        }.firstOrNull()

        return if(nestedMessage != null){
            NetworkResult.Success(nestedMessage)
        } else {
            NetworkResult.Error(NoSuchElementException(), "No such element loser")
        }
    }
    fun findById(id: String): Message? {
        return mongoRepo.findByIdOrNull(id)
    }
}