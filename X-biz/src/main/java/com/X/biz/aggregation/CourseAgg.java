package com.X.biz.aggregation;

import com.X.biz.exception.XException;
import com.X.biz.student.vo.CourseVO;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:24 PM
 **/

public interface CourseAgg {
    List<CourseVO> queryTopNHotCourses()throws XException;
    List<CourseVO> queryTopNRecentlyCourses()throws XException;
    List<CourseVO> queryCoursesByCategoryWithPage(@NotEmpty String category, int pageNO, int pageSize)throws XException;
}
