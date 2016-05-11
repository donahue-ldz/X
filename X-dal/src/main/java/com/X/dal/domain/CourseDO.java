package com.X.dal.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by donahue on 5/6/16.
 */
public class CourseDO implements Serializable {

    private static final long serialVersionUID = -8369135425468792288L;

    private long id;
    /**
     * 课程名
     */
    @NotEmpty(message = "课程名不能空")
    private String course;
    /**
     * 课程图片
     */
    private long pictureID;

    /**
     * 状态
     */
    private String status;


    /**
     * 课程创建时间
     */
    private Date gmtCreate;
    /**
     * 课程更新时间
     */
    private Date gmtModified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public CourseDO setCourse(String course) {
        this.course = course;
        return this;
    }

    public long getPictureID() {
        return pictureID;
    }

    public CourseDO setPictureID(long pictureID) {
        this.pictureID = pictureID;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
