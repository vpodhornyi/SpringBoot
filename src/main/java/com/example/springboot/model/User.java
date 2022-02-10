package com.example.springboot.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name="USERS")
public class User {
  @Id
  private Long id;
  private String first_name;
  private String last_name;
  private String email;
  private List<Message> messages;

  public User(Long id, String first_name, String last_name, String email, List<Message> messages) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.email = email;
    this.messages = messages;
  }

  public User() {
  }
}
