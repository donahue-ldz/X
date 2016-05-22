package com.X.biz.admin.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CourseDO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 4:47 PM
 **/
public interface ICourseManager {
    long save(CourseDO course, List<Long> courseCategoryIDs, byte[] imageBytes) throws XException;

    CourseDO queryCourseByID(@NotNull Long id) throws XException;

    long countAll() throws XException;

    List<CourseDO> queryTopNRecentlyCourses() throws XException;

}
