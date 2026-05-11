package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Entity
@Entity(name = "Categories")  //--> Used in production grade applications to change table name as given as args
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

//    public Category() { --> We have used Lombok @Data @NoArgsConstructor AllArgsConstructor }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank   
    //@Size(min = 5) Default
    @Size(min=5,message = "Category name must contain atleast 5 characters")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

//    public Category(String categoryName, Long categoryId) {
//        this.categoryName = categoryName;
//        this.categoryId = categoryId;
//    }
//
//    public Long getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Long categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
}
