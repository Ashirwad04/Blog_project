package com.blog.project.payload;

import com.blog.project.model.Category;
import com.blog.project.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {

    private String postId;
    private String title;
    private String content;
    private String image;
    private Date addedDate;

    private UserDto user;
    private CategoryDto category;

}
