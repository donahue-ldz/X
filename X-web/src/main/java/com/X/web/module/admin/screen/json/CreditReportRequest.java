package com.X.web.module.admin.screen.json;

import com.X.biz.admin.manager.ICreditReportManager;
import com.X.web.common.BaseAction;
import com.X.web.common.WebJsonResult;
import com.alibaba.citrus.turbine.dataresolver.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-04 PM1:56
 **/
public class CreditReportRequest extends BaseAction {
    @Autowired
    private ICreditReportManager creditReportManager;

    public WebJsonResult doYearReport(@Param("studentID")final String studentID){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                return new WebJsonResult().setObjList(creditReportManager.yearReport(studentID));
            }
        });
    }

    public WebJsonResult doMonthReport(@Param("studentID")final String studentID,
                                       @Param("fromMonth") final String fromMonth,
                                       @Param("toMonth") final String toMonth){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {
                WebJsonResult result =  new WebJsonResult();
                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM");
                    }
                }.get();
                Date fromDate = format.parse(fromMonth);
                Date toDate  = format.parse(toMonth);
                return result.setObjList(creditReportManager.monthReport(studentID,fromDate,toDate));
            }
        });
    }
    public WebJsonResult doDayReport(@Param("studentID")final String studentID,
                                     @Param("fromDay") final String fromDay,
                                     @Param("toDay") final String toDay){
        return runWrapper(new Callable<WebJsonResult>() {
            @Override
            public WebJsonResult call() throws Exception {

                SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
                    @Override
                    synchronized protected SimpleDateFormat initialValue() {
                        return new SimpleDateFormat("yyyy-MM");
                    }
                }.get();
                Date fromDate = format.parse(fromDay);
                Date toDate  = format.parse(toDay);
                return new WebJsonResult().setObjList(creditReportManager.monthReport(studentID,fromDate,toDate));
            }
        });
    }
}
