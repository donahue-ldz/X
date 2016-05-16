package com.X.web.module.student.screen;

import com.X.biz.aggregation.CourseAgg;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 3:13 PM
 **/
public class Index extends BaseScreen {
    @Autowired
    private CourseAgg courseAgg;


    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setTopNHotCourses(context);
        setTopNRecentlyCourses(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setTopNHotCourses(Context context) throws Exception {
        context.put("topNHotCourses", courseAgg.queryTopNHotCourses());
    }

    private void setTopNRecentlyCourses(Context context) throws Exception {
        context.put("topNRecentlyCourses", courseAgg.queryTopNRecentlyCourses());
    }

}
