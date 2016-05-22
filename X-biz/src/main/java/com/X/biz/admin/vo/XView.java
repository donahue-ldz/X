package com.X.biz.admin.vo;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 10:32 AM
 **/
public class XView implements Serializable {
    /**
     * 访问数
     */
    private long views;

    private long courses;
    private long topics;
    private long courseCategories;

    public long getViews() {
        return views;
    }

    public XView setViews(long views) {
        this.views = views;
        return this;
    }

    public long getCourses() {
        return courses;
    }

    public XView setCourses(long courses) {
        this.courses = courses;
        return this;
    }

    public long getTopics() {
        return topics;
    }

    public XView setTopics(long topics) {
        this.topics = topics;
        return this;
    }

    public long getCourseCategories() {
        return courseCategories;
    }

    public XView setCourseCategories(long courseCategories) {
        this.courseCategories = courseCategories;
        return this;
    }
}
