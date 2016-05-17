package com.X.dal.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 9:01 AM
 **/
public class CourseAndCategoryDO implements Serializable {
    private Long id;
    @NotNull
    private Long courseID;
    @NotNull
    private Long categoryID;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public CourseAndCategoryDO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getCourseID() {
        return courseID;
    }

    public CourseAndCategoryDO setCourseID(Long courseID) {
        this.courseID = courseID;
        return this;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public CourseAndCategoryDO setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CourseAndCategoryDO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public CourseAndCategoryDO setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public CourseAndCategoryDO setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
