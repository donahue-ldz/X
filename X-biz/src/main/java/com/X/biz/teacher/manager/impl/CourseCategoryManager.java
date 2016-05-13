package com.X.biz.teacher.manager.impl;

import com.X.biz.RunWrapper;
import com.X.biz.exception.XException;
import com.X.biz.teacher.manager.ICourseCategoryManager;
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
                courseCategory.setDesc(desc);
                courseCategory.setGmtCreate(new Date());
                courseCategory.setParentID(parentID);
                ValidationResult result = ValidateHelper.validateEntity(courseCategory);
                if(result.isHasErrors()) throw new XException(result.getErrorMsg().toString());
                else {
                    CourseCategoryDO exist = queryCourseByName(name);
                    if(exist==null)
                        return courseCategoryMapper.save(courseCategory);
                    else
                        throw new XException("已经存在的分类名...");
                }
            }
        });
    }

    @Override
    public List<CourseCategoryDO> queryAllCourseCategories() throws XException {
        return null;
    }

    @Override
    public CourseCategoryDO queryCourseByID(@Param(("id")) long id) throws XException {
        return null;
    }

    @Override
    public CourseCategoryDO queryCourseByName(@Param(("name")) String name) throws XException {
        return null;
    }
}
