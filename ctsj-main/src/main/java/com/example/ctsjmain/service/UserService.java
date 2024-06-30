package com.example.ctsjmain.service;

import com.example.ctsjmain.entity.Friends;
import com.example.ctsjmain.entity.User;

import java.util.List;

public interface UserService {
    User login(User user);
    List<Friends> findfriend(String myid);
}
