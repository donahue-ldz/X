package com.X.biz.aggregation.impl;

import com.X.biz.aggregation.CourseCategoryAgg;
import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ICourseAndCategoryManager;
import com.X.biz.teacher.manager.ICourseCategoryManager;
import com.X.biz.teacher.wrapper.CourseCategoryWrapper;
import com.X.dal.domain.CourseCategoryDO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:46 PM
 **/
@Service("courseCategoryAgg")
public class CourseCategoryAggImpl implements CourseCategoryAgg {
    @Autowired
    private ICourseCategoryManager courseCategoryManager;
    @Autowired
    private ICourseAndCategoryManager courseAndCategoryManager;

    @Override
    public List<CourseCategoryWrapper> queryAllCategories() throws XException {
        List<CourseCategoryDO> courseCategoryDOs = courseCategoryManager.queryAllCourseCategories();
        List<CourseCategoryWrapper> courseCategoryWrappers = Lists.newArrayList();
        for(CourseCategoryDO courseCategory:courseCategoryDOs){
            Long courseSize = courseAndCategoryManager.countCourseSizeByCategory(courseCategory.getId());
            CourseCategoryWrapper courseCategoryWrapper = new CourseCategoryWrapper();
            courseCategoryWrapper.setCourseCategory(courseCategory);
            courseCategoryWrapper.setCourseSize(courseSize);
            courseCategoryWrappers.add(courseCategoryWrapper);
        }
        return courseCategoryWrappers;
    }
}
