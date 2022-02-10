package com.example.springboot.controller;

import com.example.springboot.model.Message;
import com.example.springboot.model.User;
import com.example.springboot.service.TemplateMessageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
  private final TemplateMessageService templateMessageService;

  public MessageController(TemplateMessageService templateMessageService) {
    this.templateMessageService = templateMessageService;
  }

  @GetMapping("/messages")
  public List<Message> getMessages() {
    return templateMessageService.getAll();
  }

  @GetMapping("/messages/{id}")
  public Message getMessageById(@PathVariable("id") String id) {
    return templateMessageService.findById(Long.parseLong(id));
  }

  @GetMapping("/messages/users/{id}")
  public List<Message> getMessageByUserId(@PathVariable("id") String id) {
    return templateMessageService.findByUserId(Long.parseLong(id));
  }

}
