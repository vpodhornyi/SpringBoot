package com.example.springboot.dao;

import com.example.springboot.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateUserDao implements UserDao {
  private JdbcTemplate jdbcTemplate;

  public TemplateUserDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<User> findAll() {
    String sql = "SELECT * FROM USERS";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
  }

  @Override
  public User findById(Long id){
    String sql = "SELECT * FROM USERS WHERE id=?";
//    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
  }

  @Override
  public void create(User user) {
      String sql = "INSERT INTO USERS(first_name, last_name, email) VALUES (?, ?, ?)";
      jdbcTemplate.update(sql, user.getFirst_name(), user.getLast_name(), user.getEmail());
  }

  @Override
  public void update(User user, Long id) {
    String sql = "UPDATE USERS SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
    jdbcTemplate.update(sql, user.getFirst_name(), user.getLast_name(), user.getEmail(), id);
  }

  @Override
  public void delete(Long id) {
    String sql = "DELETE FROM USERS WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }
}
