package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    @GetMapping("/public/categories")
    //@RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    private ResponseEntity<CategoryResponse> getAllCategories(){
        CategoryResponse categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    //@RequestMapping(value = "/public/categories", method = RequestMethod.POST)
    private ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO,HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    private ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId){
//     When Learning    try {
//            String status = categoryService.deleteCategory(categoryId);
//            //return new ResponseEntity<>(status, HttpStatus.OK);  --> Most Common One
//            //return ResponseEntity.ok(status);
//            return ResponseEntity.status(HttpStatus.OK).body(status);
//        }catch (ResponseStatusException e){
//            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
//        }
        CategoryDTO categoryDTO = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PutMapping("/public/categories/{categoryId}")
    private ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId){
//        try{
//            Category savedCategory = categoryService.updateCategory(category,categoryId);
//            return new ResponseEntity<>(" Category with id "+ categoryId,HttpStatus.OK);
//
//        }catch (ResponseStatusException e){
//            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
//        }
        CategoryDTO deletedCategoryDTO = categoryService.updateCategory(categoryDTO,categoryId);
        return new ResponseEntity<>(deletedCategoryDTO,HttpStatus.OK);
    }


}
