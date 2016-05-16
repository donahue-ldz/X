package com.X.web.module.student.screen.json;

import com.X.biz.aggregation.CourseAgg;
import com.X.biz.student.vo.CourseVO;
import com.X.web.common.BaseAction;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-16 4:27 PM
 **/
public class CourseRequest  extends BaseAction{

    @Autowired
    private CourseAgg courseAgg;


    public WebJsonResult doQueryCourses(@Param("category") final String category,
                                        @Param(name = "pageNO",defaultValue = "0") final int pageNO,
                                        @Param(name = "pageSize",defaultValue = "50") final int pageSize){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                List<CourseVO> courseVOs = courseAgg.queryCoursesByCategoryWithPage(category,pageNO,pageSize);
                return new WebJsonResult().setObjList(courseVOs);
            }
        });
    }
}
