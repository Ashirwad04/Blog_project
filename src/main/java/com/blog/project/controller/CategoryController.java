package com.blog.project.controller;


import com.blog.project.payload.ApiResponse;
import com.blog.project.payload.CategoryDto;
import com.blog.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



    //create category
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    //update Category
    @PutMapping("{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable String catId){
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    //delete category
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable String catId){
        this.categoryService.deleteCategoryById(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }


    //get category by id
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable String catId){
        CategoryDto categoryById = this.categoryService.getCategoryById(catId);
        return new ResponseEntity<CategoryDto>(categoryById, HttpStatus.OK);
    }



    //get all categories
    @GetMapping("/")
    public ResponseEntity<Iterable<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories= this.categoryService.getCategory();
        return ResponseEntity.ok(categories);
    }

}
