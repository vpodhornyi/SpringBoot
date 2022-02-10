package com.example.springboot.model;

import lombok.Data;
import javax.persistence.Table;
import javax.persistence.Id;

@Data
@Table(name="MESSAGES")
public class Message {
  @Id
  private Long id;
  private String body;
  private User user;
}
