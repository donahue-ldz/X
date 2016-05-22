package com.X.web.module.admin.screen;

import com.X.biz.aggregation.XViewAgg;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }

    private void setView(Context context) throws XException {
        context.put("XView", xViewAgg.view());
    }
}
