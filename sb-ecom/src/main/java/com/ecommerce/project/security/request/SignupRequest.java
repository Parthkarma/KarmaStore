package com.ecommerce.project.security.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Setter
    @Getter
    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}