package com.X.biz.teacher.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CourseDO;

import javax.validation.constraints.NotNull;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 4:47 PM
 **/
public interface ICourseManager {
    long save(CourseDO course) throws XException;
    CourseDO queryCourseByID(@NotNull Long id) throws XException;
}
