package com.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
@Entity
@Data
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
<<<<<<< Updated upstream

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long orderItemId;

 @ManyToOne
 @JoinColumn(name = "product_id")
 private Product product;

 @ManyToOne
 @JoinColumn(name = "order_id")
 private Order order;

 private Integer quantity;
 private double discount;
 private double orderedProductPrice;

=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer quantity;
    private double discount;
    private double orderedProductPrice;
>>>>>>> Stashed changes
}