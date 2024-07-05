package com.example.ctsjmain.service.impl;

import com.example.ctsjmain.entity.Admin;
import com.example.ctsjmain.mapper.AdminMapper;
import com.example.ctsjmain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin){
        return adminMapper.login(admin);
    }

}
