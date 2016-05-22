package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.ICourseAndCategoryManager;
import com.X.biz.admin.manager.ICourseManager;
import com.X.biz.common.IImageCourseManager;
import com.X.biz.constant.TopNConfig;
import com.X.biz.exception.XException;
import com.X.dal.domain.CourseAndCategoryDO;
import com.X.dal.domain.CourseDO;
import com.X.dal.mapper.CourseMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 4:48 PM
 **/
@Service("courseManager")
public class CourseManager implements ICourseManager {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ICourseAndCategoryManager courseAndCategoryManager;
    @Autowired
    private IImageCourseManager imageCourseManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long save(final CourseDO course, final List<Long> courseCategoryIDs, final byte[] imageBytes) throws XException {
        return RunWrapper.runWithArgsCheck(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Preconditions.checkArgument(!CollectionUtils.isEmpty(courseCategoryIDs), "请选择分类");
                long picID = imageCourseManager.save(imageBytes);
                course.setPictureID(picID);
                courseMapper.save(course);
                long courseID = course.getId();
                List<CourseAndCategoryDO> courseAndCategoryDOs = Lists.newArrayList();
                for (Long categoryID : courseCategoryIDs) {
                    CourseAndCategoryDO courseAndCategory = new CourseAndCategoryDO();
                    courseAndCategory.setCourseID(courseID).setCategoryID(categoryID);
                    courseAndCategory.setGmtCreate(new Date());
                    courseAndCategoryDOs.add(courseAndCategory);
                }
                courseAndCategoryManager.saveList(courseAndCategoryDOs);
                return  courseID;
            }
        }, course);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CourseDO queryCourseByID(@NotNull final Long id) throws XException {
        return RunWrapper.run(new Callable<CourseDO>() {
            @Override
            public CourseDO call() throws Exception {
                return courseMapper.queryCourseByID(id);
            }
        });
    }

    @Override
    public long countAll() throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return courseMapper.countAll();
            }
        });
    }

    @Override
    public List<CourseDO> queryTopNRecentlyCourses() throws XException {
        return RunWrapper.run(new Callable<List<CourseDO>>() {
            @Override
            public List<CourseDO> call() throws Exception {
                return courseMapper.queryTopNRecentlyCourses(TopNConfig.INDEX_TOPN_COURSE);
            }
        });
    }
}
