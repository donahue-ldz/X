package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 4:16 PM
 **/
public class CommentFavoriteDO implements Serializable {

    private static final long serialVersionUID = -8369135425468792288L;

    private long id;
    /**
     * 评论ID
     */
    private long commentID;
    /**
     * 用户ID
     */
    private long userID;
    /**
     * 用户角色
     */
    private String userRole;
    /**
     * 状态
     */
    private String status;

    private Date gmtCreate;
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public CommentFavoriteDO setId(long id) {
        this.id = id;
        return this;
    }

    public long getCommentID() {
        return commentID;
    }

    public CommentFavoriteDO setCommentID(long commentID) {
        this.commentID = commentID;
        return this;
    }

    public long getUserID() {
        return userID;
    }

    public CommentFavoriteDO setUserID(long userID) {
        this.userID = userID;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public CommentFavoriteDO setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CommentFavoriteDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CommentFavoriteDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CommentFavoriteDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
