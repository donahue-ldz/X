package com.X.dal.domain;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-04 PM2:08
 **/
public class CreditReportDO {
    private String time;
    private long scores;

    public String getTime() {
        return time;
    }

    public CreditReportDO setTime(String time) {
        this.time = time;
        return this;
    }

    public long getScores() {
        return scores;
    }

    public CreditReportDO setScores(long scores) {
        this.scores = scores;
        return this;
    }

    public CreditReportDO(String time, long scores) {
        this.time = time;
        this.scores = scores;
    }

    public CreditReportDO() {
    }
}
