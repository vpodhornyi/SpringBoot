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
    String sql = "SELECT * FROM TBL_EMPLOYEES";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
  }

  @Override
  public User findById(Long id){
    String sql = "SELECT * FROM TBL_EMPLOYEES WHERE id=?";
    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
  }

  @Override
  public void create(User user) {
      String sql = "INSERT INTO TBL_EMPLOYEES(first_name, last_name, email) VALUES (?, ?, ?)";
      jdbcTemplate.update(sql, user.getFirst_name(), user.getLast_name(), user.getEmail());
  }

  @Override
  public void update(User user, Long id) {
    String sql = "UPDATE TBL_EMPLOYEES SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
    jdbcTemplate.update(sql, user.getFirst_name(), user.getLast_name(), user.getEmail(), id);
  }
}
