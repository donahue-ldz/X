package com.X.web.module.admin.screen.list;

import com.X.biz.admin.manager.ICreditReportManager;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-06-08 PM8:49
 **/
public class StudentCreditReport extends BaseScreen {
    @Autowired
    private ICreditReportManager creditReportManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setStudentID(context);
        setDefaultTime(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setDefaultTime(Context ctx) throws XException {
        String fromDay = creditReportManager.getDayFrom();
        String toDay = creditReportManager.getDayTo();
        String fromMonth = creditReportManager.getMonthForm();
        String toMonth = creditReportManager.getMonthTo();
        Map time = Maps.newHashMap();
        time.put("fromDay", fromDay);
        time.put("toDay", toDay);
        time.put("fromMonth", fromMonth);
        time.put("toMonth", toMonth);
        ctx.put("time", time);
    }

    private void setStudentID(Context context) throws XException {
        String studentID = reqContext.getParameters().getString("studentID");
        context.put("studentID", studentID);
    }
}
