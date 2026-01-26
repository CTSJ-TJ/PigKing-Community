package com.example.ctsjmain.service;

import com.example.ctsjmain.entity.Posts;
import java.util.List;

public interface PostService {
    List<Posts> findall(String status);
    List<Posts> finduser(String userid);
    List<Posts> findlike(String status,String likestring);
    Posts findId(String postid);
    int addpost(Posts posts);
    int modify(Posts posts);
    int modstatus(Posts posts);

}
