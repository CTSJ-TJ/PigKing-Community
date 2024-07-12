package com.example.ctsjmain.mapper;

import com.example.ctsjmain.entity.Friends;
import com.example.ctsjmain.entity.User;

import java.util.List;

public interface UserMapper {
    User login(User user);
    List<Friends> findfriend(String myid);

    int add(User user);
}
