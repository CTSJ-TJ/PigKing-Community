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
    public List<Posts> findall(String status){
        return postMapper.findall(status);
    }

    @Override
    public List<Posts> finduser(String userid){
        return postMapper.finduser(userid);
    }

    @Override
    public List<Posts> findlike(String status,String likestring){
        return postMapper.findlike(status,likestring);
    }

    @Override
    public Posts findId(String postid){
        return postMapper.findId(postid);
    }

    @Override
    public int addpost(Posts posts){
        return postMapper.addpost(posts);
    }

    @Override
    public int modify(Posts posts){
        if(posts.getPostlikes()!=null){
             return postMapper.modifylike(posts);
        }else if(posts.getCollections()!=null){
              return postMapper.modifycollect(posts);
        }else {
            return -1;
        }
    }

    @Override
    public int modstatus(Posts posts){
        return postMapper.modstatus(posts);
    }

}
