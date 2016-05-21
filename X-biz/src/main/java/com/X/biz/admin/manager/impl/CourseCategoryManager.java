package com.X.biz.admin.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.admin.manager.ICourseCategoryManager;
import com.X.biz.exception.XException;
import com.X.common.validator.ValidateHelper;
import com.X.common.validator.ValidationResult;
import com.X.dal.domain.CourseCategoryDO;
import com.X.dal.mapper.CourseCategoryMapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-13 3:32 PM
 **/
@Service("courseCategoryManager")
public class CourseCategoryManager implements ICourseCategoryManager {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;
    @Override
    public long save(@NotEmpty final String name, @NotEmpty final long parentID, final String desc) throws XException {
        return RunWrapper.run(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                CourseCategoryDO courseCategory = new CourseCategoryDO();
                courseCategory.setName(name);
                courseCategory.setDescription(desc);
                courseCategory.setGmtCreate(new Date());
                courseCategory.setParentID(parentID);
                ValidationResult result = ValidateHelper.validateEntity(courseCategory);
                if(result.isHasErrors()) throw new XException(result.getErrorMsg().toString());
                else {
                    CourseCategoryDO exist = queryCourseCategoryByName(name);
                    if(exist==null) {
                        courseCategoryMapper.save(courseCategory);
                        return courseCategory.getId();
                    }
                    else
                        throw new XException("已经存在的分类名...");
                }
            }
        });
    }

    @Override
    public List<CourseCategoryDO> queryAllCourseCategories() throws XException {
        return RunWrapper.run(new Callable<List<CourseCategoryDO>>() {
            @Override
            public List<CourseCategoryDO> call() throws Exception {
               return courseCategoryMapper.queryAllCourseCategories();
            }
        });
    }

    @Override
    public CourseCategoryDO queryCourseCategoryByID(@Param(("id")) final long id) throws XException {
        return RunWrapper.run(new Callable<CourseCategoryDO>() {
            @Override
            public CourseCategoryDO call() throws Exception {
                return courseCategoryMapper.queryCourseCategoryByID(id);
            }
        });
    }

    @Override
    public CourseCategoryDO queryCourseCategoryByName(@Param(("name")) final String name) throws XException {
        return RunWrapper.run(new Callable<CourseCategoryDO>() {
            @Override
            public CourseCategoryDO call() throws Exception {
                return courseCategoryMapper.queryCourseCategoryByName(name);
            }
        });
    }
}
