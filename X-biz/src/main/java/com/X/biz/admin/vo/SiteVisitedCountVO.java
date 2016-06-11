package com.X.biz.admin.vo;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 PM2:53
 **/
public class SiteVisitedCountVO implements Serializable{
    private String time;
    private long visited;

    public String getTime() {
        return time;
    }

    public SiteVisitedCountVO setTime(String time) {
        this.time = time;
        return this;
    }

    public long getVisited() {
        return visited;
    }

    public SiteVisitedCountVO setVisited(long visited) {
        this.visited = visited;
        return this;
    }

    public SiteVisitedCountVO(String time, long visited) {
        this.time = time;
        this.visited = visited;
    }

    public SiteVisitedCountVO() {
    }
}
