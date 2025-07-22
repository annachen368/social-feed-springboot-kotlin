package io.github.annachen368.socialfeeddemo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val author: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val imageUrl: String? = null,
)
