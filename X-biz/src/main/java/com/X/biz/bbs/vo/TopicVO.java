package com.X.biz.bbs.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 10:15 AM
 **/
public class TopicVO implements Serializable {
    private Long id;
    private String title;
    private String user;
    private Long userID;
    private String userAvatar;
    private TopicStat topicStat;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public TopicVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TopicVO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUser() {
        return user;
    }

    public TopicVO setUser(String user) {
        this.user = user;
        return this;
    }

    public Long getUserID() {
        return userID;
    }

    public TopicVO setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public TopicVO setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
        return this;
    }

    public TopicStat getTopicStat() {
        return topicStat;
    }

    public TopicVO setTopicStat(TopicStat topicStat) {
        this.topicStat = topicStat;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public TopicVO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
