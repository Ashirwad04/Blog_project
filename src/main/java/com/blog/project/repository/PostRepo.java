package com.blog.project.repository;

import com.blog.project.model.Category;
import com.blog.project.model.Post;
import com.blog.project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface PostRepo extends MongoRepository<Post,String> {

    List<Post> findByCategory(Category cat);

    List<Post> findByUser(User user);
}
