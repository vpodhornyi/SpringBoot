package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.List;

public interface UserService {
  List<User> getAll();

  User findById(Long id);

  void create(User user);

  void update(User user, Long id);

  void delete(Long id);
}
