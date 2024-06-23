package com.example.ctsjmain.service.impl;

import com.example.ctsjmain.entity.Posts;
import com.example.ctsjmain.mapper.PostMapper;
import com.example.ctsjmain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public List<Posts> findall(){
        return postMapper.findall();
    }

}
