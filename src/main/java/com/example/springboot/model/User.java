package com.example.springboot.model;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
//  final private double id;
//  final private String first_name;
//  final private String last_name;
//  final private String email;
  final private String login;
  final private String password;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(login, user.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login);
  }
}
