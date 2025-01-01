package com.ecommerce.project.exceptions;

public class ResourceNotFoundException extends RuntimeException {
 String resourceName;
 String field ;
 String fieldName ;
 Long fieldId ;

 public ResourceNotFoundException(String resourceName, String field, String fieldName ) {
  super(String.format("Resource %s not found for field %s.", resourceName, field));
  this.resourceName = resourceName;
  this.field = field;
  this.fieldName = fieldName;
 }

 public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
  super(String.format("Resource %s not found for field %s : %d", resourceName, field , fieldId));
  this.resourceName = resourceName;
  this.field = field;
  this.fieldId = fieldId;
 }
}
