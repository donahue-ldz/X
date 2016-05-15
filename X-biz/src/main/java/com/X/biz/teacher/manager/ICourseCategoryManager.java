package com.X.biz.teacher.manager;

import com.X.biz.exception.XException;
import com.X.dal.domain.CourseCategoryDO;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-13 3:29 PM
 **/
public interface ICourseCategoryManager {
    long save(@NotEmpty String name ,@NotEmpty long parentID,String desc) throws XException;

    List<CourseCategoryDO> queryAllCourseCategories() throws XException;

    CourseCategoryDO queryCourseCategoryByID(@Param(("id")) long id) throws XException;

    CourseCategoryDO queryCourseCategoryByName(@Param(("name")) String name) throws XException;
}
