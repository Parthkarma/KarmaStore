package com.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "roles")
public class Role {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "role_id")
 private Integer roleid;
 @Enumerated(EnumType.STRING)
 @Column(length = 20 , name = "role_name")
private AppRole  rolename;
 public Role(AppRole rolename) {
  this.rolename = rolename;
 }

}
