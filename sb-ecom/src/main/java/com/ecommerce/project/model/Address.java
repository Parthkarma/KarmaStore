package com.ecommerce.project.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long addressId;

 @NotBlank
 @Size(min = 5 , message =  "string name must be atleast  5 characters ")
 private String street ;


 @NotBlank
 @Size(min = 5 , message =  "string name must be atleast  5 characters ")
 private  String buildingName ;

 @NotBlank
 @Size(min = 4  , message =  "sting name must be atleast  5 characters ")
 private  String city;
 @NotBlank
 @Size(min = 2 , message =  "sting name must be atleast  2 characters ")
 private  String country  ;
 @NotBlank
 @Size(min = 6 , message =  "sting name must be atleast  6 characters ")
 private  String pincode ;

 @ToString.Exclude
 @ManyToMany(mappedBy =  "adressess")
 private List<User> users = new ArrayList<>();

 public Address(String street, String buildingName, String city, String country, String pincode) {
  this.street = street;
  this.buildingName = buildingName;
  this.city = city;
  this.country = country;
  this.pincode = pincode;
 }

 ;
}
