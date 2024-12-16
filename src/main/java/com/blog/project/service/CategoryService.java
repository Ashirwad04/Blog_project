package com.blog.project.service;

import com.blog.project.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
     CategoryDto createCategory( CategoryDto categoryDto );

    //update
     CategoryDto updateCategory(CategoryDto categoryDto,String categoryId);

    //delete
     void deleteCategoryById(String categoryId);

    //get by id
     CategoryDto getCategoryById(String categoryId);

    //get all
    List<CategoryDto> getCategory();

}
