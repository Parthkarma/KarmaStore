package com.ecommerce.project.service;

import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import com.ecommerce.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepository productRepository;
@Autowired
private CategoryRepository categoryRepository ;
 @Autowired
 private ModelMapper modelMapper;

 @Autowired
 private FileService fileService;
 @Value("${project.image}")
 private  String path;
 @Override
 public ProductDTO addProduct(Long categoryId , ProductDTO productDTO){
  Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "categoryId" , categoryId));
//product.setImage("default.png");
  Product product  = modelMapper.map(productDTO , Product.class) ;
 if(product.getImage() == null || product.getImage().isEmpty()) {
  product.setImage("default.png");
 }
 product.setCategory(category);
 double specialPrice = product.getPrice() -  ((product.getDiscount()* 0.01) * product.getPrice());
   product.setSpecialPrice(specialPrice);
    Product savedProduct = productRepository.save(product);
      return modelMapper.map(savedProduct, ProductDTO.class)  ;
 }

 @Override
 public ProductResponse getAllProducts() {
    List<Product> products =  productRepository.findAll() ;
    List<ProductDTO> productDTOS =  products.stream().
         map(product -> modelMapper.map(product , ProductDTO.class)).toList();
    ProductResponse productResponse = new ProductResponse();
    productResponse.setContent(productDTOS) ;
  return productResponse;
 }

 @Override
 public ProductResponse searchByCategory(Long categoryId) {
  Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category" , "categoryId" , categoryId));
  List<Product> products =  productRepository.findByCategoryOrderByPriceAsc(category) ;

  List<ProductDTO> productDTOS =  products.stream().
       map(product -> modelMapper.map(product , ProductDTO.class)).toList();
  ProductResponse productResponse = new ProductResponse();
  productResponse.setContent(productDTOS) ;
  return productResponse;
 }

 @Override
 public ProductResponse searchProductByKeyword(String keyword) {

  List<Product> products =  productRepository.findByProductNameLikeIgnoreCase('%'+keyword + '%') ;

  List<ProductDTO> productDTOS =  products.stream().
       map(product -> modelMapper.map(product , ProductDTO.class)).toList();
  ProductResponse productResponse = new ProductResponse();
  productResponse.setContent(productDTOS) ;
  return productResponse;
 }

 @Override
 public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
// logic : get the existing product from DB
  Product productFromDb = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product" , "productId" , productId));
  // Update the product info with user shared
  Product product = modelMapper.map(productDTO , Product.class) ;
  productFromDb.setProductName(product.getProductName());
  productFromDb.setDescription(product.getDescription());
  productFromDb.setQuantity(product.getQuantity());
  productFromDb.setDiscount(product.getDiscount());
  productFromDb.setPrice(product.getPrice());
  productFromDb.setSpecialPrice(product.getSpecialPrice());
  //save to database
  Product savedProduct = productRepository.save(productFromDb);
  return modelMapper.map(savedProduct, ProductDTO.class) ;
 }

 @Override
 public ProductDTO deleteProduct(Long productId) {
  Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId" , productId));
 productRepository.delete(product);
 return modelMapper.map(product, ProductDTO.class) ;
 }

 @Override
 public ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException {
  // get the product from db
  Product productFromDb = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId" , productId));
  
  // upload the image to server
  // get the file name of uploaded image

  String fileName = fileService.uploadImage(path , image) ;
   // updating the new file name  to the product
  productFromDb.setImage(fileName);
  // save updated product 
  Product updatedProduct = productRepository.save(productFromDb);
  // return DTO after mapping product to DTO 
  return modelMapper.map(updatedProduct , ProductDTO.class) ; 

 }
}
