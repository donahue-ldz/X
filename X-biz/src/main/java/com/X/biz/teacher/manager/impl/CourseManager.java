package com.X.biz.teacher.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ICourseManager;
import com.X.dal.domain.CourseDO;
import com.X.dal.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 4:48 PM
 **/
@Service("courseManager")
public class CourseManager implements ICourseManager {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public long save(final CourseDO course) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return courseMapper.save(course);
            }
        }, course);
    }

    @Override
    public CourseDO queryCourseByID(@NotNull final Long id) throws XException {
        return RunWrapper.run(new Callable<CourseDO>() {
            @Override
            public CourseDO call() throws Exception {
                return courseMapper.queryCourseByID(id);
            }
        });
    }
}
