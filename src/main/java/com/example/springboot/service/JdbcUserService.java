package com.example.springboot.service;

import com.example.springboot.dao.JdbcUserDao;
import com.example.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcUserService implements UserService{
  final private JdbcUserDao jdbcUserDao;

  public JdbcUserService(JdbcUserDao jdbcUserDao) {
    this.jdbcUserDao = jdbcUserDao;
  }

  @Override
  public List<User> getAll() {
    return jdbcUserDao.findAll();
  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public void create(User user) {

  }

  @Override
  public void update(User user, Long id) {

  }

  @Override
  public void delete(Long id) {

  }
}
