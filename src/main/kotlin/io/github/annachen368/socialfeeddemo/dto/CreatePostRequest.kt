package io.github.annachen368.socialfeeddemo.dto

data class CreatePostRequest(
    val author: String,
    val content: String,
    val imageUrl: String? = null
)