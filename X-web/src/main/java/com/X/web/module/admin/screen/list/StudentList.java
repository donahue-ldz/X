package com.X.web.module.admin.screen.list;

import com.X.biz.exception.XException;
import com.X.biz.student.manager.impl.StudentDBManager;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-21 10:14 PM
 **/
public class StudentList extends BaseScreen {
    @Autowired
    private StudentDBManager studentDBManager;

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setStudents(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setStudents(Context context) throws XException {
        context.put("students", studentDBManager.queryAllStudents());
    }
}
