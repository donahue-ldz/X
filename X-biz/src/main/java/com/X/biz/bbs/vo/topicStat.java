package com.X.biz.bbs.vo;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 3:12 PM
 **/
public class topicStat implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long views;
    private Long loves;
    private Long favorites;
    private Long sinks;
    private Long comments;
    private Long create_time;
    public Long getId() {
        return id;
    }

    public topicStat setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getViews() {
        return views;
    }

    public topicStat setViews(Long views) {
        this.views = views;
        return this;
    }

    public Long getLoves() {
        return loves;
    }

    public topicStat setLoves(Long loves) {
        this.loves = loves;
        return this;
    }

    public Long getFavorites() {
        return favorites;
    }

    public topicStat setFavorites(Long favorites) {
        this.favorites = favorites;
        return this;
    }

    public Long getSinks() {
        return sinks;
    }

    public topicStat setSinks(Long sinks) {
        this.sinks = sinks;
        return this;
    }

    public Long getComments() {
        return comments;
    }

    public topicStat setComments(Long comments) {
        this.comments = comments;
        return this;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public topicStat setCreate_time(Long create_time) {
        this.create_time = create_time;
        return this;
    }
}
