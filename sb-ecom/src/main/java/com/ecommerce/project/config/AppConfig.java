package com.ecommerce.project.config;


import com.ecommerce.project.service.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
 @Bean
 public ModelMapper modelMapper() {
  return new ModelMapper();
 }
}
