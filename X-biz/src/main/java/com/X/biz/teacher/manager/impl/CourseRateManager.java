package com.X.biz.teacher.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.constant.status.RateType;
import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ICourseRateManager;
import com.X.common.utils.DateUtils;
import com.X.dal.domain.CourseRateDO;
import com.X.dal.mapper.CourseRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 8:34 PM
 **/
@Service("courseRateManager")
public class CourseRateManager implements ICourseRateManager {
    @Autowired
    private CourseRateMapper courseRateMapper;

    @Override
    public long save(final CourseRateDO courseRate) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                CourseRateDO courseRateDO = courseRateMapper.queryRateByRateType(courseRate.getCourseID(),
                        courseRate.getStudentID(),
                        courseRate.getRateType()
                );
                if (courseRateDO == null) {
                    courseRateMapper.save(courseRate);
                    return courseRate.getId();
                } else throw new XException("已经评价过...");
            }
        }, courseRate);
    }

    @Override
    public long countShares(@NotNull final Long courseID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return courseRateMapper.countShares(courseID);
            }
        });
    }

    @Override
    public long countFavorites(@NotNull final Long courseID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return courseRateMapper.countFavorites(courseID);
            }
        });
    }

    @Override
    public long countJoin(@NotNull final Long courseID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return courseRateMapper.countJoin(courseID);
            }
        });
    }

    @Override
    public CourseRateDO queryRateByRateType(final Long courseID, final Long studentID, final RateType rateType) throws XException {
        return RunWrapper.run(new Callable<CourseRateDO>() {
            @Override
            public CourseRateDO call() throws Exception {
                return courseRateMapper.queryRateByRateType(courseID, studentID, rateType.SQLValue());
            }
        });
    }

    @Override
    public List<Long> queryTopNHotCoursesIDs() throws XException {

        Date end = new Date();
        Date start = DateUtils.day(end, -7);
        return courseRateMapper.queryTopNHotCoursesIDs(
                DateUtils.NORM_DATETIME_FORMAT.format(start),
                DateUtils.NORM_DATETIME_FORMAT.format(end)
        );
    }
}
