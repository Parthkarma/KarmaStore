package com.ecommerce.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
 @Table(name = "products")
@ToString
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO )
 private Long productId ;
 @NotBlank
 @Size(min = 3 , message =  "Product name must contain 3 characters" )
 private String productName ;
 private String image ;
 @Size(min =6 , message =  "Product name must contain 6 characters" )
 private String description;
 private Integer quantity ;
 private double price ;
 private double specialPrice ;
 private double discount ;

 @ManyToOne
 @JoinColumn(name = "categoryId")
 private Category category ;
 @ManyToOne
 @JoinColumn(name = "seller_id")
 private User user ;

}
