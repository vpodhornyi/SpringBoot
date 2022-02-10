package com.example.springboot.dao;

import com.example.springboot.model.Message;
import com.example.springboot.model.User;

import java.util.List;

public interface MessageDao {
  public List<Message> findAll();

  public List<Message> findByUserId(Long id);

  public Message findById(Long id);

  public void create(Message Message);

  public void update(Message Message, Long id);

  public void delete(Message id);
}
