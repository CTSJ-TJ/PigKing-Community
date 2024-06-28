package com.example.ctsjmain.service.impl;

import com.example.ctsjmain.entity.User;
import com.example.ctsjmain.mapper.UserMapper;
import com.example.ctsjmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user){
        return userMapper.login(user);
    }
}
