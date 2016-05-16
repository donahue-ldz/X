package com.X.biz.teacher.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.common.Void;
import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ICourseAndCategoryManager;
import com.X.dal.domain.CourseAndCategoryDO;
import com.X.dal.domain.CourseDO;
import com.X.dal.mapper.CourseAndCategoryMapper;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 11:28 PM
 **/
@Service("courseAndCategoryManager")
public class CourseAndCategoryManager implements ICourseAndCategoryManager{
    @Autowired
    private CourseAndCategoryMapper courseAndCategoryMapper;

    @Override
    public long save(final CourseAndCategoryDO courseAndCategory) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                 courseAndCategoryMapper.save(courseAndCategory);
                return courseAndCategory.getId();
            }
        },courseAndCategory);
    }

    @Override
    public void saveList(final List<CourseAndCategoryDO> courseCourseCategories) throws XException {
            RunWrapper.run(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    courseAndCategoryMapper.saveList(courseCourseCategories);
                    return Void.instance;
                }
            });
    }

    @Override
    public List<CourseDO> queryCoursesByCategoryWithPage(final String category, final int pageNO, final int pageSize) throws XException {
        return RunWrapper.run(new Callable<List<CourseDO>>() {
            @Override
            public List<CourseDO> call() throws Exception {
                Preconditions.checkArgument(!StringUtils.isEmpty(category));
                int length = pageSize<0?0:pageSize;
                int start = pageNO<0?0:pageNO * length;
                return courseAndCategoryMapper.queryCoursesByCategoryWitePage(category,start,length);
            }
        });
    }

    @Override
    public long countCourseSizeByCategory(@NotEmpty final Long categoryID) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return courseAndCategoryMapper.countCourseSizeByCategory(categoryID);
            }
        });
    }
}
