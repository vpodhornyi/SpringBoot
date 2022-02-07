package com.example.springboot.controller;

import com.example.springboot.model.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
  List<User> users = new ArrayList<User>(List.of(new User("test", "test"), new User("test1", "test1")));

  @GetMapping("/users")
  public String getUsers(Model model) {
    model.addAttribute("users", users);
    return "users";
  }

  @GetMapping("/")
  public String getLogin(Model model) {
    return "login";
  }

  @PostMapping("/login")
  public String postLogin(
      @RequestParam(name = "login") String login,
      @RequestParam(name = "password") String password,
      Model model
      ) {
    boolean contains = users.contains(new User(login, password));
    model.addAttribute("login", login);
    model.addAttribute("password", password);
    model.addAttribute("contains", contains);
    return "users";
  }

  @PostMapping("/create")
  public String create(
      @RequestParam(name = "login") String login,
      @RequestParam(name = "password") String password,
      Model model
  ) {
    System.out.println(login);
    System.out.println(password);
    User newUser = new User(login, password);
    users.add(newUser);

    return "alert";
  }
}
