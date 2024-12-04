package com.example.testProject

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MessageController(@Autowired val messageService: MessageService) {
    @GetMapping
    fun listOfMessages(): List<Message> {
        return messageService.findMessages()
    }

    @GetMapping("findById")
    fun findById(@RequestParam("id") id: String): Message? {
        return messageService.findById(id)
    }

    @GetMapping("findByMessage")
    fun findByMessageId(@RequestParam("id") id: String): ResponseEntity<UserResponse> {
        // TODO actually move to some mapping file instead we would do some mapping to user friendly responses.
        return when(val messageById = messageService.findByMessageId(id)) {
            is NetworkResult.Error -> {
                ResponseEntity.status(404).body(UserResponse.Failure(messageById.message))
            }
            is NetworkResult.Success -> {
                ResponseEntity.ok(UserResponse.NestedMessageSuccess(messageById.data))
            }
        }
    }
}