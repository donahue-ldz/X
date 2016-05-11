package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 11:02 PM
 **/
public class CourseRateDO implements Serializable{

    private static final long serialVersionUID = -6790524301116578005L;

    private long id;
    /**
     * 课程ID
     */
    private long courseID;
    /**
     * 用户ID
     */
    private long studentID;

    /**
     * 状态
     */
    private String status;
    /**
     * 1. favorite 2.share 3.join
     */
    private String rateType;

    private Date gmtCreate;
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public CourseRateDO setId(long id) {
        this.id = id;
        return this;
    }

    public long getCourseID() {
        return courseID;
    }

    public CourseRateDO setCourseID(long courseID) {
        this.courseID = courseID;
        return this;
    }

    public long getStudentID() {
        return studentID;
    }

    public CourseRateDO setStudentID(long studentID) {
        this.studentID = studentID;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CourseRateDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getRateType() {
        return rateType;
    }

    public CourseRateDO setRateType(String rateType) {
        this.rateType = rateType;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CourseRateDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CourseRateDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
