package com.ecommerce.project.service;

import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
   CategoryResponse getAllCategories() throws APIException;
    void createCategory(Category category) throws APIException;

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
