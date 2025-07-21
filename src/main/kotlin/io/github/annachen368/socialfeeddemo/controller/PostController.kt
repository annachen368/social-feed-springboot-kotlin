package io.github.annachen368.socialfeeddemo.controller

import io.github.annachen368.socialfeeddemo.model.Post
import io.github.annachen368.socialfeeddemo.repository.PostRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(private val postRepo: PostRepository) {

    @GetMapping
    fun getFeed(): List<Post> = postRepo.findAllByOrderByCreatedAtDesc()

    @PostMapping
    fun createPost(@RequestBody post: Post): Post = postRepo.save(post)
}
