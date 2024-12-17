package com.blog.project.service;

import com.blog.project.model.Post;
import com.blog.project.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,String userId,String categoryId);
    PostDto updatePost(PostDto postDto, String postId);
    PostDto getPostById(String postId);
    void deletePost(String postId);

    List<PostDto> getAllPosts();
    List<PostDto> getPostsByCategory(String categoryId);
    List<PostDto> getPostsByUser(String userId);

    List<PostDto> searchPosts(String keyword);



}
