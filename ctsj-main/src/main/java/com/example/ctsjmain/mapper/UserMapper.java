package com.example.ctsjmain.mapper;


import com.example.ctsjmain.entity.User;

import java.util.List;

public interface UserMapper {
    User login(User user);

    int add(User user);
    List<User> find(String values);
}
