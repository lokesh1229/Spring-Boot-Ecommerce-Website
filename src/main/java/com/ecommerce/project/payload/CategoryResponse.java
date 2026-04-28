package com.ecommerce.project.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryResponse {
    private List<CategoryDTO> content;


}
