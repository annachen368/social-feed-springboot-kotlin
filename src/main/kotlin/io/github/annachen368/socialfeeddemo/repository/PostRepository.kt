package io.github.annachen368.socialfeeddemo.repository

import io.github.annachen368.socialfeeddemo.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<Post>
}
