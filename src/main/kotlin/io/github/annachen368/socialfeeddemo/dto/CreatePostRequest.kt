package io.github.annachen368.socialfeeddemo.dto

import io.github.annachen368.socialfeeddemo.model.Attachment

data class CreatePostRequest(
    val author: String,
    val content: String,
    val attachments: List<Attachment>? = null
)