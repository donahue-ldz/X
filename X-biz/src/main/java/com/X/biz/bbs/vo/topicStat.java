package com.X.biz.bbs.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 3:12 PM
 **/
public class TopicStat implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long views;
    private Long favorites;
    private Long bookmarks;
    private Long comments;
    private Date createTime;

    public Long getViews() {
        return views;
    }

    public TopicStat setViews(Long views) {
        this.views = views;
        return this;
    }

    public Long getFavorites() {
        return favorites;
    }

    public TopicStat setFavorites(Long favorites) {
        this.favorites = favorites;
        return this;
    }

    public Long getBookmarks() {
        return bookmarks;
    }

    public TopicStat setBookmarks(Long bookmarks) {
        this.bookmarks = bookmarks;
        return this;
    }

    public Long getComments() {
        return comments;
    }

    public TopicStat setComments(Long comments) {
        this.comments = comments;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public TopicStat setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}
