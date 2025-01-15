package com.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_items")
public class CartItem {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long cartItemId ;
 @ManyToOne
 @JoinColumn(name = "card_id")
 private Cart cart ;
 @ManyToOne
 @JoinColumn(name = "product_id")
 private Product product ;
 private Integer quantity ;
 private double  discount ;
 private  double productPrice;
}
