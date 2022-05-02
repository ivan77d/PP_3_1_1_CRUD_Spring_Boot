package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> userList();

    User userById(int id);

    void save(User user);

    void update(User updateUser);

    void delete(int id);
}
