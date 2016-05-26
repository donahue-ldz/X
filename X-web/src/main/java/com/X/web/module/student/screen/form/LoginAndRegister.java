package com.X.web.module.student.screen.form;

import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-25 PM11:08
 **/
public class LoginAndRegister extends BaseScreen {

    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

}
