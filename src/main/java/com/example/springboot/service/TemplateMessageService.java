package com.example.springboot.service;

import com.example.springboot.dao.MessageDao;
import com.example.springboot.dao.TemplateMessageDao;
import com.example.springboot.dao.TemplateUserDao;
import com.example.springboot.model.Message;
import com.example.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateMessageService implements MessageService {
  private final TemplateMessageDao templateMessageDao;
  private TemplateUserDao templateUserDao;

  public TemplateMessageService(TemplateMessageDao templateMessageDao, TemplateUserDao templateUserDao) {
    this.templateMessageDao = templateMessageDao;
    this.templateUserDao = templateUserDao;
  }

  @Override
  public List<Message> getAll() {
    return templateMessageDao.findAll();
  }

  @Override
  public List<Message> findByUserId(Long id) {
    List<Message> messages = templateMessageDao.findByUserId(id);
    messages.forEach(message -> {
      User user = templateUserDao.findById(id);
      message.setUser(user);
    });

    return messages;
  }

  @Override
  public Message findById(Long id) {
    return templateMessageDao.findById(id);
  }

  @Override
  public void create(Message message) {

  }

  @Override
  public void update(Message message, Long id) {

  }

  @Override
  public void delete(Long id) {

  }
}
