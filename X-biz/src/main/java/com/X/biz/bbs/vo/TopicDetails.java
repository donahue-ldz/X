package com.X.biz.bbs.vo;

import com.X.dal.domain.CommentDO;

import java.io.Serializable;
import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 10:19 AM
 **/
public class TopicDetails implements Serializable {
    private TopicVO topicVO;
    private String title;
    private String content;
    private String category;

    private List<CommentDO> comments;

    public TopicVO getTopicVO() {
        return topicVO;
    }

    public TopicDetails setTopicVO(TopicVO topicVO) {
        this.topicVO = topicVO;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TopicDetails setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public TopicDetails setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public TopicDetails setCategory(String category) {
        this.category = category;
        return this;
    }

    public List<CommentDO> getComments() {
        return comments;
    }

    public TopicDetails setComments(List<CommentDO> comments) {
        this.comments = comments;
        return this;
    }
}
