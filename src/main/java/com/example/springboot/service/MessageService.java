package com.example.springboot.service;

import com.example.springboot.model.Message;
import com.example.springboot.model.User;

import java.util.List;

public interface MessageService {
  List<Message> getAll();

  List<Message> findByUserId(Long id);

  Message findById(Long id);

  void create(Message message);

  void update(Message message, Long id);

  void delete(Long id);
}
