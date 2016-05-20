package com.X.biz.bbs.vo;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-19 10:16 PM
 **/
public class BBSView {
    private long topics;
    private long members;

    public long getTopics() {
        return topics;
    }

    public BBSView setTopics(long topics) {
        this.topics = topics;
        return this;
    }

    public long getMembers() {
        return members;
    }

    public BBSView setMembers(long members) {
        this.members = members;
        return this;
    }
}
