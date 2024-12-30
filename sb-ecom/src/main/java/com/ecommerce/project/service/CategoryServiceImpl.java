package com.ecommerce.project.service;

import org.modelmapper.ModelMapper;
import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// An Optional is used to represent a value that might or might not be present, making it a safe way to handle potential null values.
@Service
//@Service Annotation:
//Marks CategoryServiceImpl as a Spring-managed bean.
//Spring will create an instance of this class when needed.
public class CategoryServiceImpl implements CategoryService{
//    private List<Category> categories = new ArrayList<>();
//    private Long nextId = 1L;
    @Autowired
    private CategoryRepositories categoryRepository;
    @Autowired
    private ModelMapper modelMapper ;
    @Override
    public CategoryResponse getAllCategories() throws APIException {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw new APIException("No category created till now.") ;
//        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> (CategoryDTO) modelMapper.map(category, CategoryDTO.class )).toList() ;
        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> (CategoryDTO) modelMapper.map(category , CategoryDTO.class )).toList();
             CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }
    @Override
    public void createCategory(Category category) throws APIException {
        Category savedCategory = categoryRepository.findByCategoryName((category.getCategoryName()));
       if(savedCategory != null)
           throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!! ") ;
//        category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }
    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" , "categoryId" , categoryId));

        categoryRepository.delete(category);
        return "Category with categoryId " + categoryId + " deleted successfully" ;

    }
    @Override
    public Category updateCategory(Category category, Long categoryId){
        Optional<Category> savedCategoryOptional  = categoryRepository.findById(categoryId);
        Category savedCategory = savedCategoryOptional.orElseThrow(()-> new ResourceNotFoundException("Category" , "categoryId" , categoryId));
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return savedCategory;
//      Optional<Category> optionalCategory = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst();

//      if(optionalCategory.isPresent()){
//          Category existingCategory = optionalCategory.get();
//          existingCategory.setCategoryName(category.getCategoryName());
//         Category savedCategory = categoryRepository.save(existingCategory) ;
//
//          return savedCategory;
//      } else{
//         throw new   ResponseStatusException(HttpStatus.NOT_FOUND , "category not found  ! ") ;
//      }

    }
}
