package com.X.biz.teacher.wrapper;

import com.X.dal.domain.CourseCategoryDO;

import java.io.Serializable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:43 PM
 **/
public class CourseCategoryWrapper implements Serializable {
    private CourseCategoryDO courseCategory;
    private long courseSize;

    public CourseCategoryDO getCourseCategory() {
        return courseCategory;
    }

    public CourseCategoryWrapper setCourseCategory(CourseCategoryDO courseCategory) {
        this.courseCategory = courseCategory;
        return this;
    }

    public long getCourseSize() {
        return courseSize;
    }

    public CourseCategoryWrapper setCourseSize(long courseSize) {
        this.courseSize = courseSize;
        return this;
    }
}
