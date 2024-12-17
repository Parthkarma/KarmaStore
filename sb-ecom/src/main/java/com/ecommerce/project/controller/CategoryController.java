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
@RequestMapping("/api/public")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
//     @Autowired is a Spring annotation that performs Dependency Injection.
//It tells the Spring container to automatically inject an instance of the CategoryService
// class (or its implementation) into the categoryService variable.
//Spring finds the appropriate bean (a managed object) and provides it.


//    @GetMapping("/api/public/categories")
    @RequestMapping(value = "/categories" , method = RequestMethod.GET)

    public ResponseEntity<List<Category>> getAllCategories(){

        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories , HttpStatus.OK);
    }

//    @PostMapping("/api/public/categories")
    @RequestMapping(value = "/categories" , method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully" , HttpStatus.CREATED);
    }
//    @DeleteMapping("/api/public/categories/{categoryId}")
    @RequestMapping(value = "/api/public/categories/{categoryId}" , method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){

      try{
          String status = categoryService.deleteCategory(categoryId) ;
          //return   new ResponseEntity<>(status , HttpStatus.OK) ;
          // return ResponseEntity.ok(status) ;
          return new ResponseEntity<>(status , HttpStatus.OK) ;
      } catch (ResponseStatusException e ){
          return new ResponseEntity<>(e.getReason() , e.getStatusCode());
      }
    }

//    @PutMapping("/api/public/categories/{categoryId}")
    @RequestMapping(value = "/api/public/categories/{categoryId}" , method = RequestMethod.PUT)
    public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable Long categoryId){
        try{
                  Category savedCategory  = categoryService.updateCategory(category , categoryId) ;
                  return new ResponseEntity<>("Category updated successfully" + category , HttpStatus.OK) ;
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }


}
