package com.ecommerce.project.model;


import jakarta.persistence.*;

@Entity

public class Address {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long addressId;
}
