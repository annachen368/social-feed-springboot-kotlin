package io.github.annachen368.socialfeeddemo.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Attachment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val type: String,
    val url: String,
    val caption: String?
)
