package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 4:15 PM
 **/
public class TopicFavoriteDO implements Serializable{
    private static final long serialVersionUID = 3977314433226729915L;
    private long id;
    /**
     * 帖子ID
     */
    private long topicID;
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

    public Date getGmtModified() {
        return gmtModified;
    }

    public TopicFavoriteDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public long getId() {
        return id;
    }

    public TopicFavoriteDO setId(long id) {
        this.id = id;
        return this;
    }

    public long getTopicID() {
        return topicID;
    }

    public TopicFavoriteDO setTopicID(long topicID) {
        this.topicID = topicID;
        return this;
    }

    public long getUserID() {
        return userID;
    }

    public TopicFavoriteDO setUserID(long userID) {
        this.userID = userID;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public TopicFavoriteDO setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TopicFavoriteDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public TopicFavoriteDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }
}
