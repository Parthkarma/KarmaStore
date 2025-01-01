package com.ecommerce.project.controller;

import com.ecommerce.project.config.AppConstants;
import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
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

 @GetMapping("/echo")
public ResponseEntity<String> echoMessage(@RequestParam(name = "message" ,  defaultValue = "Hello world")String message ){
 return new ResponseEntity<>("Echoed message : " + message, HttpStatus.OK);
}
//    @GetMapping("/api/public/categories")
    @RequestMapping(value = "/categories" , method = RequestMethod.GET)

    public ResponseEntity<CategoryResponse> getAllCategories(
         @RequestParam(name = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER , required = false) Integer pageNumber  ,
         @RequestParam(name = "pageSize" , defaultValue = AppConstants.PAGE_SIZE , required = false) Integer pageSize  ,
         @RequestParam(name = "sortBy" ,defaultValue = AppConstants.SORT_CATEGORIES_BY ,required = false) String sortBy ,
         @RequestParam(name = "sortOrder" ,defaultValue = AppConstants.SORT_DIR  , required = false ) String sortOrder
         ) throws APIException {
        CategoryResponse categoryResponse =  categoryService.getAllCategories( pageNumber, pageSize , sortBy , sortOrder );
        return new ResponseEntity<>(categoryResponse , HttpStatus.OK);
    }
//    @PostMapping("/api/public/categories")
    @RequestMapping(value = "/categories" , method = RequestMethod.POST)
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) throws APIException {
       CategoryDTO savedCategoryDTO  =  categoryService.createCategory(categoryDTO);

        return new ResponseEntity<>(  HttpStatus.CREATED);
    }
//    @DeleteMapping("/api/public/categories/{categoryId}")
    @RequestMapping(value = "/categories/{categoryId}" , method = RequestMethod.DELETE)
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId){

        CategoryDTO deleteCategory  = categoryService.deleteCategory(categoryId) ;
          return new ResponseEntity<>(deleteCategory , HttpStatus.OK) ;

      }

 //@PutMapping("/categories/{categoryId}")
 @RequestMapping(value = "/categories/{categoryId}" , method = RequestMethod.PUT)
 public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO , @PathVariable Long categoryId){

     CategoryDTO  savedCategoryDTO   = categoryService.updateCategory(categoryDTO , categoryId) ;
               return new ResponseEntity<>(savedCategoryDTO ,  HttpStatus.OK) ;

 }

    }
