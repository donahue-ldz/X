package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-17 9:41 PM
 **/
public class TopicAndCategoryDO implements Serializable {
    private Long id;
    private Long topicID;
    private Long topicCategoryID;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public TopicAndCategoryDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getTopicID() {
        return topicID;
    }

    public TopicAndCategoryDO setTopicID(Long topicID) {
        this.topicID = topicID;
        return this;
    }

    public Long getTopicCategoryID() {
        return topicCategoryID;
    }

    public TopicAndCategoryDO setTopicCategoryID(Long topicCategoryID) {
        this.topicCategoryID = topicCategoryID;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TopicAndCategoryDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public TopicAndCategoryDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public TopicAndCategoryDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
