package com.X.web.module.admin.screen.json;

import com.X.biz.admin.manager.ITrafficAnalysisManager;
import com.X.biz.student.manager.IStudentDBManager;
import com.X.web.common.BaseAction;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-11 PM2:54
 **/
public class IndexRequest extends BaseAction{
    @Autowired
    private ITrafficAnalysisManager trafficAnalysisManager;
    @Autowired
    private IStudentDBManager studentDBManager;


    public WebJsonResult doVisitedReport(@Param("fromDay") final String fromDay,
                                     @Param("toDay") final String toDay){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {

                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();
                Date fromDate = format.parse(fromDay);
                Date toDate  = format.parse(toDay);
                return new WebJsonResult().setObjList(trafficAnalysisManager.visitedReport(fromDate,toDate));
            }
        });
    }

    public WebJsonResult doRegisterReport(@Param("fromDay") final String fromDay,
                                         @Param("toDay") final String toDay){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {

                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM-dd");
                    }
                }.get();
                Date fromDate = format.parse(fromDay);
                Date toDate  = format.parse(toDay);
                return new WebJsonResult().setObjList(studentDBManager.registerReport(fromDate,toDate));
            }
        });
    }
}
