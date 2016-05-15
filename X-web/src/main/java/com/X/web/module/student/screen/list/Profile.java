package com.X.web.module.student.screen.list;

import com.X.biz.exception.XException;
import com.X.biz.student.wrapper.StudentWrapper;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-11 12:55 PM
 **/
public class Profile extends BaseScreen {

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setUser(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setUser(Context context) throws Exception{
        StudentWrapper student  = (StudentWrapper) getUser();
        context.put("studentWrapper",student);
    }
}
