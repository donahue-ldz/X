package com.X.biz.bbs.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 10:15 AM
 **/
public class TopicVO implements Serializable {
    // 帖子的ID,唯一区分
    private Long id;
    // 帖子的标题
    private String title;
    // 发帖人
    private String user;
    // 发帖人的ID
    private Long userID;
    //用户头像
    private String userAvatar;
    //帖子分类
    private String topicCategory;
    // 帖子的统计状态
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

    public String getTopicCategory() {
        return topicCategory;
    }

    public TopicVO setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
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
