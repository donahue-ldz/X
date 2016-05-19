package com.X.biz.bbs.vo;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:16 PM
 **/
public class BBSView {
    private Long topics;
    private Long members;

    public Long getTopics() {
        return topics;
    }

    public BBSView setTopics(Long topics) {
        this.topics = topics;
        return this;
    }

    public Long getMembers() {
        return members;
    }

    public BBSView setMembers(Long members) {
        this.members = members;
        return this;
    }
}
