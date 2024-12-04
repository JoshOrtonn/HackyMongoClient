package com.example.testProject

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface Repo: MongoRepository<Message, String> {}