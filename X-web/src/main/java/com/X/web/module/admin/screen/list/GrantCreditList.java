package com.X.web.module.admin.screen.list;

import com.X.biz.admin.manager.IGrantCreditManager;
import com.X.biz.exception.XException;
import com.X.web.common.BaseScreen;
import com.X.web.common.WebResult;
import com.alibaba.citrus.turbine.Context;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-22 11:08 AM
 **/
public class GrantCreditList extends BaseScreen {
    @Autowired
    private IGrantCreditManager grantCreditManager;
    @Override
    protected WebResult handleRequest(Context context) throws Exception {
        setGrants(context);
        return new WebResult();
    }

    @Override
    protected List<String> getPermissionList() throws XException {
        return null;
    }
    private void setGrants(Context context) throws XException{
        context.put("grants",grantCreditManager.queryAllGrants());
    }
}
