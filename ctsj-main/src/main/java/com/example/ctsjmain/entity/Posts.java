package com.example.ctsjmain.entity;

import lombok.Data;

@Data
public class Posts {
    private Integer postid;
    private String posttitle;
    private String postpassege;
    private Integer userid;
    private Integer postlikes;
    private Integer collections;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getPosttile() {
        return posttitle;
    }

    public void setPosttile(String posttile) {
        this.posttitle = posttile;
    }

    public String getPostpassege() {
        return postpassege;
    }

    public void setPostpassege(String postpassege) {
        this.postpassege = postpassege;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPostlikes() {
        return postlikes;
    }

    public void setPostlikes(Integer postlikes) {
        this.postlikes = postlikes;
    }

    public Integer getCollections() {
        return collections;
    }

    public void setCollections(Integer collections) {
        this.collections = collections;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postid=" + postid +
                ", posttile='" + posttitle + '\'' +
                ", postpassege='" + postpassege + '\'' +
                ", userid=" + userid +
                ", postlikes=" + postlikes +
                ", collections=" + collections +
                '}';
    }
}
