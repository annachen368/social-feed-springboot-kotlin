package io.github.annachen368.socialfeeddemo.controller

import io.github.annachen368.socialfeeddemo.dto.CreatePostRequest
import io.github.annachen368.socialfeeddemo.model.Post
import io.github.annachen368.socialfeeddemo.repository.PostRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/posts")
class PostController(private val postRepo: PostRepository) {

    // Get all posts
    @GetMapping
    fun getAllPosts(): List<Post> = postRepo.findAll()

    // Create a new post
    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequest): Post {
        val post = Post(
            author = request.author,
            content = request.content,
            imageUrl = request.imageUrl
        )
        return postRepo.save(post)
    }

    // Read single post
    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<Post> =
        postRepo.findById(id).map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())

    // Update post
    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody request: CreatePostRequest): ResponseEntity<Post> {
        val updated = postRepo.findById(id).map {
            val post = it.copy(author = request.author, content = request.content, imageUrl = request.imageUrl)
            ResponseEntity.ok(postRepo.save(post))
        }
        return updated.orElse(ResponseEntity.notFound().build())
    }

    // Delete post
    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Void> {
        return if (postRepo.existsById(id)) {
            postRepo.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
