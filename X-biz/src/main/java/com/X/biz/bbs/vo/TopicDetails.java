package com.X.biz.bbs.vo;

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
    private List<CommentVO> comments;
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

    public List<CommentVO> getComments() {
        return comments;
    }

    public TopicDetails setComments(List<CommentVO> comments) {
        this.comments = comments;
        return this;
    }
}
