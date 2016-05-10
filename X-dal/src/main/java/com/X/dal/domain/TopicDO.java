package com.X.dal.domain;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 3:04 PM
 **/
public class TopicDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    //发布人
    private Long userID;
    private String userRole;

    //所属分类
    private Long topicCategoryID;

    //帖子标题
    private String title;

    //帖子内容
    private String content;

    // 帖子权重
    private Double weight;

    //帖子创建时间
    private Long gmtCreate;

    //最后更新时间
    private Long gmtModified;

    //1:正常 2:删除
    private String status;

    public Long getId() {
        return id;
    }

    public TopicDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserID() {
        return userID;
    }

    public TopicDO setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public String getUserRole() {
        return userRole;
    }

    public TopicDO setUserRole(String userRole) {
        this.userRole = userRole;
        return this;
    }

    public Long getTopicCategoryID() {
        return topicCategoryID;
    }

    public TopicDO setTopicCategoryID(Long topicCategoryID) {
        this.topicCategoryID = topicCategoryID;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TopicDO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TopicDO setContent(String content) {
        this.content = content;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TopicDO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public TopicDO setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public TopicDO setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TopicDO setStatus(String status) {
        this.status = status;
        return this;
    }
}