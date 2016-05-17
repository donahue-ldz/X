package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 11:10 PM
 **/
public class CourseAndTeacherDO  implements Serializable {
    private Long id;
    private Long course_ID;
    private Long teacher_ID;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public CourseAndTeacherDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCourse_ID() {
        return course_ID;
    }

    public CourseAndTeacherDO setCourse_ID(Long course_ID) {
        this.course_ID = course_ID;
        return this;
    }

    public Long getTeacher_ID() {
        return teacher_ID;
    }

    public CourseAndTeacherDO setTeacher_ID(Long teacher_ID) {
        this.teacher_ID = teacher_ID;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CourseAndTeacherDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CourseAndTeacherDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CourseAndTeacherDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
