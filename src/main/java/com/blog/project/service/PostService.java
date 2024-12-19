package com.blog.project.service;

import com.blog.project.model.Post;
import com.blog.project.payload.PostDto;
import com.blog.project.payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,String userId,String categoryId);
    PostDto updatePost(PostDto postDto, String postId);
    PostDto getPostById(String postId);
    void deletePost(String postId);

    PostResponse getAllPosts(Integer pageNumber, Integer pageSize,String sortBy,String sortOrder);
    List<PostDto> getPostsByCategory(String categoryId);
    List<PostDto> getPostsByUser(String userId);
//search
    List<PostDto> searchPosts(String keyword);





}
