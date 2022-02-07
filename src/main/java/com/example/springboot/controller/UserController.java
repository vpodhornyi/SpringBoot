package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.JdbcUserService;
import com.example.springboot.service.TemplateUserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
 private TemplateUserService templateUserService;
 private JdbcUserService jdbcUserService;

  public UserController(TemplateUserService templateUserService, JdbcUserService jdbcUserService) {
    this.templateUserService = templateUserService;
    this.jdbcUserService = jdbcUserService;
  }

  @GetMapping("/users")
  public List<User> getUsers(Model model) {
    return templateUserService.getAll();
  }

  @GetMapping("/users/{id}")
  public User create(@PathVariable("id") String id) {
    return templateUserService.findById(Long.parseLong(id));
  }

  @PostMapping("/users")
  public void postUsers(@RequestBody User user) {
    templateUserService.create(user);
  }

  @PutMapping("/users/{id}")
  public void putUsers(@PathVariable("id") String id, @RequestBody User user) {
    templateUserService.update(user, Long.parseLong(id));
  }
}
