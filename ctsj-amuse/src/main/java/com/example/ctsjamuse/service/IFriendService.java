package com.example.ctsjamuse.service;

import com.example.ctsjamuse.entity.Friends;

import java.util.List;

public interface IFriendService {
    List<Friends> findfriend(String myid);
    int addfriend(Friends friends);
}
