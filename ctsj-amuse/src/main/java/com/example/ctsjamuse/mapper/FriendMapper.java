package com.example.ctsjamuse.mapper;

import com.example.ctsjamuse.entity.Friends;

import java.util.List;

public interface FriendMapper {
    List<Friends> findfriend(String myid);
    int addfriend(Friends friends);
    Friends friendship(Friends friends);
}
