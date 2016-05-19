package com.X.biz.bbs.vo;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:16 PM
 **/
public class UserView implements Serializable {
    private Long favorites;
    private Long bookmarks;
    private Long topics;
    private Long comments;

    public Long getFavorites() {
        return favorites;
    }

    public UserView setFavorites(Long favorites) {
        this.favorites = favorites;
        return this;
    }

    public Long getBookmarks() {
        return bookmarks;
    }

    public UserView setBookmarks(Long bookmarks) {
        this.bookmarks = bookmarks;
        return this;
    }

    public Long getTopics() {
        return topics;
    }

    public UserView setTopics(Long topics) {
        this.topics = topics;
        return this;
    }

    public Long getComments() {
        return comments;
    }

    public UserView setComments(Long comments) {
        this.comments = comments;
        return this;
    }
}
