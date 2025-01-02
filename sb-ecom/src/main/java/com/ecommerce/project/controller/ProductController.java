package com.ecommerce.project.controller;


import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ProductController {
 @Autowired
 ProductService productService;
 @PostMapping("/admin/categories/{categoryId}/product")
 public ResponseEntity<ProductDTO> addProduct (@RequestBody ProductDTO productDTO , @PathVariable Long categoryId){

  ProductDTO savedProductDTO = productService.addProduct(categoryId, productDTO);
  return new ResponseEntity<>( savedProductDTO, HttpStatus.CREATED);
 }
 @GetMapping("/public/products")
 public ResponseEntity<ProductResponse> getAllProducts(){
  ProductResponse productResponse = productService.getAllProducts() ;
 return new ResponseEntity<>(productResponse, HttpStatus.OK);
 }
 @GetMapping("/public/categories/{categoriesId}/products")
 public ResponseEntity<ProductResponse> getProductByCategory(@PathVariable Long categoriesId){
        ProductResponse productResponse  =  productService.searchByCategory(categoriesId) ;
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
 }
 @GetMapping("/public/products/Keyword/{keyword}")
 public ResponseEntity<ProductResponse> getProductsByKeyword(@PathVariable String keyword){
 ProductResponse productResponse =  productService.searchProductByKeyword(keyword) ;
  return new ResponseEntity<>(productResponse , HttpStatus.FOUND) ;
 }
@PutMapping("/admin/product/{productId}")
 public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO  , @PathVariable Long productId){

 ProductDTO updatedProductDTO = productService.updateProduct(productId , productDTO) ;
  return new ResponseEntity<>(updatedProductDTO , HttpStatus.OK);
 }
 @DeleteMapping("/admin/products/{productId}")
 public ResponseEntity<ProductDTO>deleteProduct(@PathVariable Long productId){
 ProductDTO deletedProduct =  productService.deleteProduct(productId) ;
  return new ResponseEntity<>(deletedProduct , HttpStatus.OK);
 }
 @PutMapping("/products/{productId}/image")
 public ResponseEntity<ProductDTO> updateProductImage(@PathVariable Long productId, @RequestParam("image") MultipartFile image) throws IOException {
  ProductDTO updatedProduct = productService.updateProductImage(productId , image) ;
  return new ResponseEntity<>(updatedProduct , HttpStatus.OK);
 }
}
