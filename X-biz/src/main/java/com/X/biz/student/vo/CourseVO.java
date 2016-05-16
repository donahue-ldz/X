package com.X.biz.student.vo;

import com.X.dal.domain.CourseDO;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:16 PM
 **/
public class CourseVO implements Serializable {

    private CourseDO course;


    private long teacherID;
    private String teacherName;
    private String teacherAvatar;


    private long courseFavorite;
    private long courseShare;

    public CourseDO getCourse() {
        return course;
    }

    public CourseVO setCourse(CourseDO course) {
        this.course = course;
        return this;
    }

    public long getTeacherID() {
        return teacherID;
    }

    public CourseVO setTeacherID(long teacherID) {
        this.teacherID = teacherID;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public CourseVO setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public CourseVO setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
        return this;
    }

    public long getCourseFavorite() {
        return courseFavorite;
    }

    public CourseVO setCourseFavorite(long courseFavorite) {
        this.courseFavorite = courseFavorite;
        return this;
    }


    public long getCourseShare() {
        return courseShare;
    }

    public CourseVO setCourseShare(long courseShare) {
        this.courseShare = courseShare;
        return this;
    }
}
