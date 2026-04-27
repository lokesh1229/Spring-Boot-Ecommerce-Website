package com.ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
