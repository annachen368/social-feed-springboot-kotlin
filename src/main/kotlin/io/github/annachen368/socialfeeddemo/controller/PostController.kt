package io.github.annachen368.socialfeeddemo.controller

import io.github.annachen368.socialfeeddemo.dto.CreatePostRequestDto
import io.github.annachen368.socialfeeddemo.model.Post
import io.github.annachen368.socialfeeddemo.repository.PostRepository
import org.springframework.http.ResponseEntity
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

    // Read single post
    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<Post> =
        postRepo.findById(id).map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
}
