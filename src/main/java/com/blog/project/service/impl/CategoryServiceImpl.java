package com.blog.project.service.impl;

import com.blog.project.Exception.ResourseNotFoundException;
import com.blog.project.model.Category;
import com.blog.project.payload.CategoryDto;
import com.blog.project.repository.CategoryRepo;
import com.blog.project.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category saved = this.categoryRepo.save(cat);
        return this.modelMapper.map(saved,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto,String categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourseNotFoundException("category","CategoryId",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat,CategoryDto.class);
    }

    @Override
    public void deleteCategoryById(String categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourseNotFoundException("category","CategoryId",categoryId));
        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto getCategoryById(String categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourseNotFoundException("category","CategoryId",categoryId));
        return this.modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategory() {
        List<Category> cats=this.categoryRepo.findAll();
        List<CategoryDto> catDtos = cats.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
