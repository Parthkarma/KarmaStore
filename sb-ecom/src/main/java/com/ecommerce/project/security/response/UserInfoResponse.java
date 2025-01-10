package com.ecommerce.project.security.response;

import lombok.Getter;

import java.util.List;

@Getter
public class UserInfoResponse {
    private Long id ;
    private String jwtToken;

    private String username;
    private List<String> roles;

    public UserInfoResponse(Long id , String username, List<String> roles, String jwtToken) {
     this.id = id;
     this.username = username;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }

 public void setId(Long id) {
        this.id = id;
    }

 public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

 public void setUsername(String username) {
        this.username = username;
    }

 public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}


