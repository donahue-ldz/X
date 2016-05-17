package com.X.biz.teacher.manager;

import com.X.biz.constant.status.RateType;
import com.X.biz.exception.XException;
import com.X.dal.domain.CourseRateDO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by donahue on 5/16/16.
 */
public interface ICourseRateManager {
    long save(CourseRateDO courseRate) throws XException;

    long countShares(@NotNull Long courseID) throws XException;

    long countFavorites(@NotNull Long courseID) throws XException;

    long countJoin(@NotNull Long courseID) throws XException;

    CourseRateDO queryRateByRateType(final Long courseID, Long studentID, RateType rateType) throws XException;

    List<Long> queryTopNHotCoursesIDs()throws XException;
}
