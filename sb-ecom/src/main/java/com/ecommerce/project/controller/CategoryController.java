package com.ecommerce.project.controller;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public ResponseEntity<CategoryResponse> getAllCategories() throws APIException {

        CategoryResponse categoryResponse =  categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse , HttpStatus.OK);
    }

//    @PostMapping("/api/public/categories")
    @RequestMapping(value = "/categories" , method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) throws APIException {
        categoryService.createCategory(category);

        return new ResponseEntity<>("Category added successfully" , HttpStatus.CREATED);
    }
//    @DeleteMapping("/api/public/categories/{categoryId}")
    @RequestMapping(value = "/categories/{categoryId}" , method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){

        String status = categoryService.deleteCategory(categoryId) ;
          return new ResponseEntity<>(status , HttpStatus.OK) ;

      }

 //@PutMapping("/categories/{categoryId}")
 @RequestMapping(value = "/categories/{categoryId}" , method = RequestMethod.PUT)
 public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable Long categoryId){

     Category savedCategory  = categoryService.updateCategory(category , categoryId) ;
               return new ResponseEntity<>("Category updated successfully to " + category.getCategoryName() , HttpStatus.OK) ;

 }

    }
