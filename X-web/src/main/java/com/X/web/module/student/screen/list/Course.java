package com.X.web.module.student.screen.list;

import com.X.biz.aggregation.CourseCategoryAgg;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-13 9:06 PM
 **/
public class Course extends BaseScreen {
    @Autowired
    private CourseCategoryAgg courseCategoryAgg;



    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setCourseCategories(context);

        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setCourseCategories(Context context) throws Exception{
        context.put("categories",courseCategoryAgg.queryAllCategories());
    }
}
