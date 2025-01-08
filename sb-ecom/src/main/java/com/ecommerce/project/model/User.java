package com.ecommerce.project.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@Table(name = "Users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long userId;
 @NotBlank
 @Size(max = 20)
 private String userName;
@Email
 private String email;
 @NotBlank
 @Size(max = 120)
 private String password;
public User(String userName , String email, String password ) {
 this.userName = userName;
 this.email = email;
 this.password = password;
}
 @Setter
 @Getter
 @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,
     fetch = FetchType.EAGER)
@JoinTable(name="user_role" ,
     joinColumns = @JoinColumn(name = "user_id") ,
     inverseJoinColumns =  @JoinColumn(name = "role_id")
)
private Set<Role> roles = new HashSet<>();
}
