package com.blog.project.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private String categoryId;
    @NotBlank
    @Size(min =3)
    private String categoryTitle;
    @NotBlank
    @Size(min =10)
    private String categoryDescription;


}
