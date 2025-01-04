package com.ecommerce.project.payload;


import com.ecommerce.project.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
 private Long productId;
 private String productName;
 private String image ;
 private Integer quantity ;
 private double price ;
 private double discount ;
 private double specialPrice ;

 @ManyToOne
 @JoinColumn(name = "category_id")
 private Category category;
}
