package com.example.springboot.service;

import com.example.springboot.dao.TemplateUserDao;
import com.example.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateUserService implements UserService{
  private TemplateUserDao templateUserDao;

  public TemplateUserService(TemplateUserDao templateUserDao) {
    this.templateUserDao = templateUserDao;
  }

  @Override
  public List<User> getAll() {
    return templateUserDao.findAll();
  }

  @Override
  public User findById(Long id) {
    return templateUserDao.findById(id);
  }

  @Override
  public void create(User user) {
    templateUserDao.create(user);
  }

  @Override
  public void update(User user, Long id) {
    templateUserDao.update(user, id);
  }
}
