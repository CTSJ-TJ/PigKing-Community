package com.example.ctsjmain.service;

import com.example.ctsjmain.entity.User;

import java.util.List;

public interface UserService {
    User login(User user);

    int add(User user);

    List<User> find(String values);
}
