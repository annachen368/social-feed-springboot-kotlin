package io.github.annachen368.socialfeeddemo.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val author: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
