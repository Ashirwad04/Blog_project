package com.blog.project.service.impl;

import com.blog.project.Exception.ResourseNotFoundException;
import com.blog.project.model.Category;
import com.blog.project.model.Post;
import com.blog.project.model.User;
import com.blog.project.payload.PostDto;
import com.blog.project.repository.CategoryRepo;
import com.blog.project.repository.PostRepo;
import com.blog.project.repository.UserRepo;
import com.blog.project.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;




    @Override
    public PostDto createPost(PostDto postDto,String userId,String categoryId) {

        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("user","userId",userId));
        Category category =this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category","categoryId",categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImage("images/");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public void deletePost(String postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourseNotFoundException("post","postId",postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, String postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourseNotFoundException("post","postId",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImage(postDto.getImage());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public PostDto getPostById(String postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourseNotFoundException("post","postId",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = this.postRepo.findAll();
        List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByCategory(String categoryId) {
        Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category","categoryId",categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(String userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("user","userId",userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }

}
