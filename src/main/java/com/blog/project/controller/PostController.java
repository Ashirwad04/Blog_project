package com.blog.project.controller;

import com.blog.project.payload.ApiResponse;
import com.blog.project.payload.PostDto;
import com.blog.project.payload.PostResponse;
import com.blog.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;



    //create post
    //      /api//userId/{userId}/category/{categoryId}/posts
    @PostMapping("/userId/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable String userId,
            @PathVariable String categoryId) {

        PostDto createPost= this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    //Get all posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber",defaultValue ="0",required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue ="5",required = false)Integer pageSize
            ){
        PostResponse postResponse = this.postService.getAllPosts(pageNumber,pageSize);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

    //get post by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable String postId){
        PostDto postById = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
    }

    //delete post by id
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable String postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post successfully deleted",true);
    }

    //update post by id
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable String postId, @RequestBody PostDto postDto){
        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }


    //get by User
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(
            @PathVariable String userId)
    {
        List<PostDto> postsByUser = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(postsByUser,HttpStatus.OK);
    }

    //get by Category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(
            @PathVariable String categoryId)
    {
        List<PostDto> postsByUser = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(postsByUser,HttpStatus.OK);
    }

}
