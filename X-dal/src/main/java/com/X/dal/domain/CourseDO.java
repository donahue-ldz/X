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
    private String name;
    /**
     * 描述
     */
    @NotEmpty(message = "描述不能为空")
    private String description;
    /**
     * 简短描述
     */
    @NotEmpty(message = "简短描述不能为空")
    private String shortDesc;

    /**
     * 课程学分
     */
    private int courseCredit;
    /**
     * 课时
     */
    private int courseHours;

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

    public CourseDO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CourseDO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public CourseDO setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
        return this;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public CourseDO setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
        return this;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public CourseDO setCourseHours(int courseHours) {
        this.courseHours = courseHours;
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

    public CourseDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CourseDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CourseDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
