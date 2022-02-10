package com.example.springboot.dao;

import com.example.springboot.model.Message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TemplateMessageDao implements MessageDao {
  private JdbcTemplate jdbcTemplate;

  public TemplateMessageDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Message> findAll() {
    String sql = "SELECT * FROM MESSAGES";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Message.class));
  }

  @Override
  public List<Message> findByUserId(Long id) {
    String sql = "SELECT * FROM MESSAGES WHERE userId=?";
    return jdbcTemplate.query(sql,  new BeanPropertyRowMapper<>(Message.class), id);
  }

  @Override
  public Message findById(Long id) {
    String sql = "SELECT * FROM MESSAGES WHERE id=?";
//    return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Message.class));
    return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(Message.class), id);
  }

  @Override
  public void create(Message Message) {

  }

  @Override
  public void update(Message Message, Long id) {

  }

  @Override
  public void delete(Message id) {

  }
}
