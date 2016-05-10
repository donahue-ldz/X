package com.X.biz.bbs.vo;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 3:12 PM
 **/
public class TopicStat implements Serializable {
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

    public TopicStat setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getViews() {
        return views;
    }

    public TopicStat setViews(Long views) {
        this.views = views;
        return this;
    }

    public Long getLoves() {
        return loves;
    }

    public TopicStat setLoves(Long loves) {
        this.loves = loves;
        return this;
    }

    public Long getFavorites() {
        return favorites;
    }

    public TopicStat setFavorites(Long favorites) {
        this.favorites = favorites;
        return this;
    }

    public Long getSinks() {
        return sinks;
    }

    public TopicStat setSinks(Long sinks) {
        this.sinks = sinks;
        return this;
    }

    public Long getComments() {
        return comments;
    }

    public TopicStat setComments(Long comments) {
        this.comments = comments;
        return this;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public TopicStat setCreate_time(Long create_time) {
        this.create_time = create_time;
        return this;
    }
}
