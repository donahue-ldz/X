package com.X.biz.aggregation;

import com.X.biz.exception.XException;
import com.X.biz.teacher.wrapper.CourseCategoryWrapper;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:46 PM
 **/
public interface CourseCategoryAgg {
    List<CourseCategoryWrapper> queryAllCategories()throws XException;
}
