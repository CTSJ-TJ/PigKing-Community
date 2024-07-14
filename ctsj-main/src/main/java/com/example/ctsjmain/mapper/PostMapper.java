package com.example.ctsjmain.mapper;



import com.example.ctsjmain.entity.Posts;

import java.util.List;

public interface PostMapper{
    List<Posts> findall(String status);
    List<Posts> findlike(String status,String likestring);
    Posts findId(String postid);
    int addpost(Posts posts);
}

