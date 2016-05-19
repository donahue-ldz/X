package com.X.biz.bbs.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 8:41 PM
 **/
public class CommentVO implements Serializable {
    private Long id;
    /**
     * 评论者
     */
    private String user;
    private Long userID;
    private String userAvatar;
    private String content;
    private long favorites;
    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public CommentVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public CommentVO setUser(String user) {
        this.user = user;
        return this;
    }

    public Long getUserID() {
        return userID;
    }

    public CommentVO setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public CommentVO setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentVO setContent(String content) {
        this.content = content;
        return this;
    }

    public long getFavorites() {
        return favorites;
    }

    public CommentVO setFavorites(long favorites) {
        this.favorites = favorites;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CommentVO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }
}
