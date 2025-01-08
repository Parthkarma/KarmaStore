package com.ecommerce.project.service;


import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ProductService {
 ProductDTO addProduct(Long categoryId, ProductDTO product) throws APIException;
 ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) throws APIException;

 ProductResponse searchByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) throws APIException;

 ProductResponse searchProductByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) throws APIException;

 ProductDTO updateProduct(Long productId, ProductDTO product);

 ProductDTO deleteProduct(Long productId);

 ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}