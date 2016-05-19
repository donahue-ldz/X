package com.X.web.module.bbs.control;

import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-18 5:31 PM
 **/
public class Sidebar extends BaseScreen {
    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        return null;
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setUserInfo(Context context) throws XException{


    }
    private void setBBSInfo(Context context) throws XException{

    }
}
