package com.X.dal.mapper;

import com.X.dal.domain.CourseCategoryDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 5:30 PM
 **/
@Repository
public interface CourseCategoryMapper {
    long save(CourseCategoryDO courseCategory);

    List<CourseCategoryDO> queryAllCourseCategories();

    CourseCategoryDO queryCourseCategoryByID(@Param(("id")) long id);

    CourseCategoryDO queryCourseCategoryByName(@Param(("name")) String name);
}

