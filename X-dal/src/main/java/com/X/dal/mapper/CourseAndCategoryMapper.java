package com.X.dal.mapper;

import com.X.dal.domain.CourseAndCategoryDO;
import com.X.dal.domain.CourseDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by donahue on 5/16/16.
 */
@Repository
public interface CourseAndCategoryMapper {
    Long save(CourseAndCategoryDO courseCourseCategory);

    void saveList(List<CourseAndCategoryDO> courseCourseCategories);

    List<CourseDO> queryCoursesByCategoryWitePage(@Param("category") String category,
                                                  @Param("start") long start,
                                                  @Param("length") long length);

    long countCourseSizeByCategory(@Param("categoryID") Long categoryID);


}
