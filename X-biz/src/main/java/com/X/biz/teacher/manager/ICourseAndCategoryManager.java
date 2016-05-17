package com.X.biz.teacher.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CourseAndCategoryDO;
import com.X.dal.domain.CourseDO;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 11:27 PM
 **/
public interface ICourseAndCategoryManager {
    long save(CourseAndCategoryDO courseAndCategory) throws XException;
    void saveList(List<CourseAndCategoryDO> courseCourseCategories) throws XException;


    List<CourseDO> queryCoursesByCategoryWithPage(String category,int pageNO,int pageSize) throws XException;

    /**
     * 取分类下的课程数目
     * @param categoryID
     * @return
     * @throws XException
     */
    long countCourseSizeByCategory(@NotEmpty Long categoryID) throws XException;

}
