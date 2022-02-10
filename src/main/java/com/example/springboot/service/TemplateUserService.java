package com.example.springboot.service;

import com.example.springboot.dao.TemplateMessageDao;
import com.example.springboot.dao.TemplateUserDao;
import com.example.springboot.model.Message;
import com.example.springboot.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TemplateUserService implements UserService {
  private TemplateUserDao templateUserDao;
  private TemplateMessageDao templateMessageDao;

  public TemplateUserService(TemplateUserDao templateUserDao, TemplateMessageDao templateMessageDao) {
    this.templateUserDao = templateUserDao;
    this.templateMessageDao = templateMessageDao;
  }

  @Override
  public List<User> getAll() {
    List<User> users = templateUserDao.findAll();
    users.forEach(user -> {
      List<Message> messages = templateMessageDao.findByUserId(user.getId());
      user.setMessages(messages);
    });
    return users;
  }

  @Override
  public User findById(Long id) {
    User user = templateUserDao.findById(id);
    List<Message> messages = templateMessageDao.findByUserId(id);
    user.setMessages(messages);
    return user;
  }

  @Override
  public void create(User user) {
    templateUserDao.create(user);
  }

  @Override
  public void update(User user, Long id) {
    templateUserDao.update(user, id);
  }

  @Override
  public void delete(Long id) {
    templateUserDao.delete(id);
  }
}
