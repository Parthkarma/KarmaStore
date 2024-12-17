package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
//     @Autowired is a Spring annotation that performs Dependency Injection.
//It tells the Spring container to automatically inject an instance of the CategoryService
// class (or its implementation) into the categoryService variable.
//Spring finds the appropriate bean (a managed object) and provides it.


    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category added successfully";
    }
    @DeleteMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){

      try{
          String status = categoryService.deleteCategory(categoryId) ;
          return   new ResponseEntity<>(status , HttpStatus.OK) ;
      } catch (ResponseStatusException e ){
          return new ResponseEntity<>(e.getReason() , e.getStatusCode());
      }
    }
}
