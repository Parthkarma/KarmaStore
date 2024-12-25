package com.ecommerce.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
//@ExceptionHandler
public class MyGlobalExceptionHandler {

 @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> myResourceNotFoundException(ResourceNotFoundException e) {
  String message = e.getMessage() ;
  return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
 }
 @ExceptionHandler(APIException.class)
 public ResponseEntity<String> myAPIException(APIException e) {
  String message = e.getMessage() ;
  return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
 }
}
