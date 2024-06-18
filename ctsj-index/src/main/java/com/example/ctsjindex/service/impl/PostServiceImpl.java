package com.example.ctsjindex.service.impl;

import com.example.ctsjindex.entity.Posts;
import com.example.ctsjindex.mapper.PostMapper;
import com.example.ctsjindex.service.PostService;
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
