package com.X.web.module.admin.screen;

import com.X.biz.aggregation.XViewAgg;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 10:43 AM
 **/
public class Index extends BaseScreen {
    @Autowired
    private XViewAgg xViewAgg;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setView(context);
        setVisitedReport(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setView(Context context) throws XException {
        context.put("XView", xViewAgg.view());
    }

    private void setVisitedReport(Context context) throws XException{
        Map<String,String> times = Maps.newHashMap();
        Calendar fromCal = Calendar.getInstance();
        fromCal.add(Calendar.DAY_OF_MONTH,-30);
        Date fromDate  = fromCal.getTime();
        Date toDate = new Date();
        SimpleDateFormat format = new ThreadLocal<SimpleDateFormat>(){
            @Override
            protected synchronized SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd");
            }
        }.get();
        times.put("fromDay",format.format(fromDate));
        times.put("toDay",format.format(toDate));
        context.put("time",times);
    }
}
