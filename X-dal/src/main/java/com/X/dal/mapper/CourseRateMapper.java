package com.X.dal.mapper;

import com.X.dal.domain.CourseRateDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 8:07 PM
 **/
@Repository
public interface CourseRateMapper {
    void save(CourseRateDO courseRate);

    long countShares(@Param("courseID") Long courseID);

    long countFavorites(@Param("courseID") Long courseID);

    long countJoin(@Param("courseID") Long courseID);

    CourseRateDO queryRateByRateType(@Param("courseID") final Long courseID,
                                     @Param("studentID") Long studentID,
                                     @Param("rateType") String rateType);

    List<Long> queryTopNHotCoursesIDs(@Param("start") String start,@Param("end") String end);


}
