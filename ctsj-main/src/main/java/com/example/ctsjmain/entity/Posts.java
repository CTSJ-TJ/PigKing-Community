package com.example.ctsjmain.entity;

import lombok.Data;

@Data
public class Posts {
    private Integer postid;
    private String posttitle;
    private String postpassege;
    private Integer userid;
    private String posttime;
    private Integer postlikes;
    private Integer collections;
    private Integer status;

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
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

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postid=" + postid +
                ", posttitle='" + posttitle + '\'' +
                ", postpassege='" + postpassege + '\'' +
                ", userid=" + userid +
                ", posttime='" + posttime + '\'' +
                ", postlikes=" + postlikes +
                ", collections=" + collections +
                ", status=" + status +
                '}';
    }

    public String getPosttile() {
        return posttitle;
    }

    public void setPosttile(String posttitle) {
        this.posttitle = posttitle;
    }
}
