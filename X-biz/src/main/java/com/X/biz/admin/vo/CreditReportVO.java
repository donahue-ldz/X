package com.X.biz.admin.vo;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-04 PM2:08
 **/
public class CreditReportVO {
    private String time;
    private long score;

    public String getTime() {
        return time;
    }

    public CreditReportVO setTime(String time) {
        this.time = time;
        return this;
    }

    public long getScore() {
        return score;
    }

    public CreditReportVO setScore(long score) {
        this.score = score;
        return this;
    }

    public CreditReportVO(String time, long score) {
        this.time = time;
        this.score = score;
    }

    public CreditReportVO() {
    }
}
