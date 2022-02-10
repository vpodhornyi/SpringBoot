package com.example.springboot.dao;

import com.example.springboot.model.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcUserDao implements UserDao{
  private DataSource dataSource;

  public JdbcUserDao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public List<User> findAll() {
    Connection connection = null;
    List<User> users = new ArrayList<>();
    try {
      connection = dataSource.getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
      while(resultSet.next()) {
        long id = resultSet.getLong("id");
        String first_name = resultSet.getString(2);
        String last_name = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        users.add(new User(id, first_name, last_name, email, null));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return users;

  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public void create(User user) {

  }

  @Override
  public void update(User user, Long id) {

  }

  @Override
  public void delete(Long id) {

  }
}
