package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

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

    //帖子标题
    private String title;

    //帖子内容
    private String content;

    //帖子关键字
    private String keyWords;

    // 帖子权重
    private Double weight;

    //帖子创建时间
    private Date gmtCreate;

    //最后更新时间
    private Date gmtModified;

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

    public String getKeyWords() {
        return keyWords;
    }

    public TopicDO setKeyWords(String keyWords) {
        this.keyWords = keyWords;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TopicDO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public TopicDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public TopicDO setGmtModified(Date gmtModified) {
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