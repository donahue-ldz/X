package com.X.biz.aggregation.impl;

import com.X.biz.aggregation.CourseAgg;
import com.X.biz.exception.XException;
import com.X.biz.student.vo.CourseVO;
import com.X.biz.teacher.manager.ICourseManager;
import com.X.biz.teacher.manager.ICourseRateManager;
import com.X.dal.domain.CourseDO;
import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:25 PM
 **/
@Service("courseAgg")
public class CourseAggImpl implements CourseAgg {
    @Autowired
    private ICourseRateManager rateManager;
    @Autowired
    private ICourseManager courseManager;

    @Override
    public List<CourseVO> queryTopNHotCourses() throws XException {
        return null;
    }

    @Override
    public List<CourseVO> queryTopNRecentlyCourses() throws XException {
        List<CourseDO> courseDOs = courseManager.queryTopNRecentlyCourses();
        List<CourseVO> courseVOs = Lists.newArrayList();
        for(CourseDO courseDO:courseDOs){
            CourseVO courseVO = new CourseVO();
            courseVO.setCourse(courseDO);
        }
        return courseVOs;
    }

    @Override
    public List<CourseVO> queryCoursesByCategoryWithPage(@NotEmpty String category, int pageNO, int pageSize) throws XException {
        return null;
    }
}
