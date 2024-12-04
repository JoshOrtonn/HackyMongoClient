package com.example.testProject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
class TestProjectApplication

fun main(args: Array<String>) {
	runApplication<TestProjectApplication>(*args)
}
