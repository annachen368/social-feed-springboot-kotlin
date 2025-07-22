package io.github.annachen368.socialfeeddemo.controller

import io.github.annachen368.socialfeeddemo.dto.CreatePostRequestDto
import io.github.annachen368.socialfeeddemo.model.Post
import io.github.annachen368.socialfeeddemo.repository.PostRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(private val postRepo: PostRepository) {

    // Get all posts
    @GetMapping
    fun getAllPosts(): List<Post> = postRepo.findAll()

    // Create a new post
    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequestDto): Post {
        val post = Post(
            author = request.author,
            content = request.content
        )
        return postRepo.save(post)
    }
}
