package com.example.springboot.dao;

import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {

  public List<User> findAll();

  public User findById(Long id);

  public void create(User user);

  public void update(User user, Long id);

}
