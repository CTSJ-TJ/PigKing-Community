package com.example.ctsjamuse.service.ipml;

import com.example.ctsjamuse.entity.Friends;
import com.example.ctsjamuse.mapper.FriendMapper;
import com.example.ctsjamuse.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceimpl implements IFriendService {
    @Autowired
    FriendMapper friendMapper;
    @Override
    public List<Friends> findfriend(String myid) {
        return friendMapper.findfriend(myid);
    }

    @Override
    public int addfriend(Friends friends){
        int a=-1;
        Friends friends1=friendMapper.friendship(friends);
        if(friends1==null){
             a=friendMapper.addfriend(friends);
        }
        return a;
    }
}
