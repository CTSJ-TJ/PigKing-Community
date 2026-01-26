package com.example.ctsjamuse.web;

import com.example.ctsjamuse.entity.Friends;
import com.example.ctsjamuse.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("friend")
public class FriendsAction {
    @Autowired
    IFriendService service;
    @RequestMapping("findfriend")
    @ResponseBody
    public Object FrindFriend(@RequestParam("myid") String myId){
        System.out.println("myid="+myId);
        return service.findfriend(myId);
    }
    @RequestMapping("addfriend")
    @ResponseBody
    public Object AddFriend(@RequestParam("myid") String myId,@RequestParam("myname") String myname,
                            @RequestParam("otherid") String otherId,@RequestParam("othername") String othername){
        Friends friends=new Friends();
        friends.setFriendxid(Integer.valueOf(myId));
        friends.setFriendxname(myname);
        friends.setFriendyid(Integer.valueOf(otherId));
        friends.setFriendyname(othername);
        return service.addfriend(friends);
    }


}
