package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class APIResponse {
 public String message;
 private boolean status;

}
