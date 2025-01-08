package com.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.net.ProtocolFamily;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "roles")
public class Role {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "role_id")
 private Integer roleid;
 @ToString.Exclude
 @Enumerated(EnumType.STRING)
 @Column(length = 20 , name = "role_name")
private AppRole  rolename;
 public Role(AppRole rolename) {
  this.rolename = rolename;
 }

 public ProtocolFamily getRoleName() {
  return null;
 }
}
