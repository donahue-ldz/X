package com.X.web.module.bbs.screen;

import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-10 2:23 PM
 **/
public class Index extends BaseScreen{
    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        return null;
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setTab(Context context)throws Exception{
        String tab  = reqContext.getParameters().getString("tab");
        context.put("tab",tab);
    }
    private void setTopics(Context context) throws Exception{
        context.put("topics",null);
    }
}
