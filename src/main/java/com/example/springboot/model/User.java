package com.example.springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="TBL_EMPLOYEES")
public class User {
  @Id
  private Long id;
  private String first_name;
  private String last_name;
  private String email;

  public User(Long id, String first_name, String last_name, String email) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
  }

  public User() {
  }
}
