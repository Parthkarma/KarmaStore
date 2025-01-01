package com.ecommerce.project.service;

import org.modelmapper.ModelMapper;
import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public CategoryResponse getAllCategories(Integer pageNumber , Integer pageSize  , String sortBy , String sortOrder) throws APIException {
        Sort  sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
     Pageable pagedetails = PageRequest.of(pageNumber , pageSize , sortByAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pagedetails);
     List<Category> categories = categoryPage.getContent();
        if(categories.isEmpty())
            throw new APIException("No category created till now.") ;
//        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> (CategoryDTO) modelMapper.map(category, CategoryDTO.class )).toList() ;
        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> (CategoryDTO) modelMapper.map(category , CategoryDTO.class )).toList();
             CategoryResponse categoryResponse = new CategoryResponse();
             categoryResponse.setContent(categoryDTOS);
             categoryResponse.setPageNumber(categoryPage.getNumber());
             categoryResponse.setPageSize(categoryPage.getSize());
             categoryResponse.setTotalPages((long) categoryPage.getTotalPages());
             categoryResponse.setTotalElements(categoryPage.getTotalElements());
             categoryResponse.setLastPage(categoryPage.isLast());

        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws APIException {
        Category category = modelMapper.map(categoryDTO , Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName((category.getCategoryName()));
       if(categoryFromDb != null)
           throw new APIException("Category with the name " + category.getCategoryName() + " already exists !!! ") ;
//        category.setCategoryId(nextId++);
        Category savedCategory = categoryRepository.save(category);

     return modelMapper.map(savedCategory , CategoryDTO.class );
    }
    @Override
    public CategoryDTO deleteCategory(Long categoryId) {
        Category category  = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category" , "categoryId" , categoryId));

        categoryRepository.delete(category);
        return modelMapper.map(category , CategoryDTO.class ) ;

    }
    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId){
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(()->  new ResourceNotFoundException("Category", "CategoryId" , categoryId));
       Category category = modelMapper.map(categoryDTO , Category.class);
        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory , CategoryDTO.class );
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
