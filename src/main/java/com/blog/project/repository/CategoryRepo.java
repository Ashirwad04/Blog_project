package com.blog.project.repository;

import com.blog.project.model.Category;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepo extends MongoRepository<Category,String> {

}
