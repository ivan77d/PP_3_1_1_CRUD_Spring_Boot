package com.example.demo.service;

import com.example.demo.model.User;


import java.util.List;

public interface UserService {

    List<User> allUsers();

    User userById(int id);

    void save(User user);

    void update(int id, User updateUser);

    void delete(int id);
}
