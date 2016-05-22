package com.X.dal.mapper;

import com.X.dal.domain.CourseDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by donahue on 5/6/16.
 */
public interface CourseMapper {
    long save(CourseDO course);

    CourseDO queryCourseByID(@Param("id") Long id);

    List<CourseDO> queryCoursesByName(@Param("name") String name);

    List<CourseDO> queryTopNRecentlyCourses(@Param("topN") Long topN);

    long countAll();
}
